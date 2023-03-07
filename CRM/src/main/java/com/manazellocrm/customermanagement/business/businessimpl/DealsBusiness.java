package com.manazellocrm.customermanagement.business.businessimpl;

import com.manazellocrm.customermanagement.business.dtos.DealsDTO;
import com.manazellocrm.customermanagement.business.ibusiness.IDealsBusiness;
import com.manazellocrm.customermanagement.entities.Deals;
import com.manazellocrm.customermanagement.repositories.DealsRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.Instant;

import java.time.LocalDate;

import java.time.ZoneId;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

@RequiredArgsConstructor
@Service
public class DealsBusiness implements IDealsBusiness {

    private static final Logger logger = LoggerFactory.getLogger(DealsBusiness.class);
    private final DealsRepository dealsRepository;
    final JavaMailSender javaMailSender;


    @Override
    public ResponseEntity<Deals> addDeal(DealsDTO dealsDTO) {
        try {


            Date date = new Date();
            Instant instanceNow = date.toInstant();
            Deals dealToPersist = new Deals(dealsDTO.getId(),
                    dealsDTO.getDealName(),
                    dealsDTO.getDealValue(),
                    dealsDTO.getForecastDate(),
                    dealsDTO.getCustomerBudget(),
                    dealsDTO.getWinChance(),
                    dealsDTO.getBudgetStage(),
                    dealsDTO.getQuoteValue(),
                    dealsDTO.getQuoteDate(),
                    dealsDTO.getQuoteVsBudget(),
                    dealsDTO.getDealStatus(),
                    dealsDTO.getSource(),
                    dealsDTO.getComment(),
                    dealsDTO.getDealType(),
                    dealsDTO.getNegotiation(),
                    dealsDTO.getDealDate(),
                    "False",
                    date.getDate() - dealsDTO.getDealDate().getDate(),
                    instanceNow,
                    instanceNow,
                    dealsDTO.getVisit()
            );

            dealsRepository.save(dealToPersist);
            String message = "Deal added to DATABASE : " + dealToPersist;
            logger.info(message);

            return ResponseEntity.status(HttpStatus.CREATED).body(dealToPersist);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

        public void sendEmail(String subject,String body,String email){
            MimeMessage emailMessage = javaMailSender.createMimeMessage();

            try {
                MimeMessageHelper helper = new MimeMessageHelper(emailMessage, true);
                helper.setTo(email);
                helper.setSubject(subject);
                helper.setText(body, true);
            } catch (MessagingException e) {
                e.printStackTrace();
            }


            javaMailSender.send(emailMessage);

        }
    @Transactional
    public Deals updateDeal(Deals deals, String id) {
        Optional<Deals> dealsOptional = dealsRepository.findById(id);
        Date date = new Date();
        Instant dateToUpdate = date.toInstant();
                deals.setModifiedAt(dateToUpdate);

            return (dealsOptional.isPresent() ?
                    dealsRepository.save(deals)
                    : null);
    }



    @Override
    public void cancelDealPassed(Deals deals, String id) {
        Optional<Deals> dealsOptional = dealsRepository.findById(id);
        Date date = new Date();
        Instant dateToUpdate = date.toInstant();

        deals.setModifiedAt(dateToUpdate);
        deals.setDealStatus("Canceled");

        if (dealsOptional.isPresent()) {
            dealsRepository.save(deals);
            String body=EmailTemplate.EMAIL+
                    "We have tried to reach out to you to continue the process of deal," +
                    " but 60 days had been passed . so the deal has been canceled."+
                    EmailTemplate.email2;
            sendEmail("Deal actually status",body,deals.getVisit().getCustomer().getWorkEmail());
        }
    }

    public boolean calculateDate(Date dateDeal){
        Date currentDate = new Date();
        LocalDate localDateBefore = Instant
                .ofEpochMilli(dateDeal.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate localDateAfter = Instant
                .ofEpochMilli(currentDate.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        long daysBetween = DAYS.between( localDateBefore,localDateAfter);

       return daysBetween >= 60;
    }

    @Override
    @Scheduled(cron="0 0 0 * * ?")
    public void cancelDeal() {
        Date date = new Date();
        List<Deals> dealsToUpdate= dealsRepository.findDealsByDealDateIsGreaterThanAndDealStatus(date, "paused");
       for (Deals deals:dealsToUpdate) {
          if( calculateDate(deals.getDealDate()))
              cancelDealPassed(deals, deals.getId());
       }
    }

    @Override
    public ResponseEntity<String> deleteDeal(String id) {
        if (dealsRepository.findById(id).isPresent()) {
            dealsRepository.deleteById(id);
            return new ResponseEntity<>("Deal deleted Successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Deal not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Deals> getAllDeals() {
        return dealsRepository.findAll();
    }

    @Override
    public ResponseEntity<Deals> getDealByID(String id) {
        Optional<Deals> dealData = dealsRepository.findById(id);
        return dealData.map(deal -> new ResponseEntity<>(deal, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }


    @Override
    public Deals archiveDeals(Deals deals, String id) {
        Optional<Deals> dealsDetails = dealsRepository.findById(id);
        Date date = new Date();
        Instant dateToUpdate = date.toInstant();
        deals.setModifiedAt(dateToUpdate);
        deals.setArchive("True");
        return (dealsDetails.isPresent() ?
                dealsRepository.save(deals)
                : null);
    }

    @Override
    public Deals cancelArchiveDeals(Deals deals, String id) {
        Optional<Deals> visitDetails = dealsRepository.findById(id);
        Date date = new Date();
        Instant dateToUpdate = date.toInstant();
        deals.setModifiedAt(dateToUpdate);
        deals.setArchive("False");
        return (visitDetails.isPresent() ?
                dealsRepository.save(deals)
                : null);
    }

    @Override
    public List<Deals> findAllDealsASC() {
        return dealsRepository.findAll(Sort.by("dealName").ascending().and(Sort.by("created_at").descending()));
    }


    @Override
    public List<Deals> findAllDealsDESC() {
        return dealsRepository.findAll(Sort.by("dealName").descending().and(Sort.by("created_at").descending()));
    }

    @Override
    public List<Deals> findAllDealsByArchive(String archive) {
        return dealsRepository.findDealsByArchive(archive);
    }





}
