package com.manazellocrm.customermanagement.business.businessimpl;

import com.manazellocrm.customermanagement.business.dtos.VisitDTO;
import com.manazellocrm.customermanagement.business.ibusiness.ICustomerBusiness;
import com.manazellocrm.customermanagement.business.ibusiness.IVisitsBusiness;
import com.manazellocrm.customermanagement.entities.Customer;
import com.manazellocrm.customermanagement.entities.Visit;
import com.manazellocrm.customermanagement.repositories.CustomerRepository;
import com.manazellocrm.customermanagement.repositories.VisitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import com.twilio.type.PhoneNumber;

import java.time.Instant;
import java.util.*;

@Service
public class VisitsBusiness implements IVisitsBusiness {

    private static final Logger logger = LoggerFactory.getLogger(VisitsBusiness.class);
    private final VisitRepository visitRepository;

    private final RestTemplate rest;

    private final CustomerRepository customerRepository;


    private final ICustomerBusiness iCustomerBusiness;




    public VisitsBusiness(VisitRepository visitRepository, RestTemplate rest, CustomerRepository customerRepository, ICustomerBusiness iCustomerBusiness) {
        this.visitRepository = visitRepository;
        this.rest = rest;
        this.customerRepository = customerRepository;
        this.iCustomerBusiness = iCustomerBusiness;
    }


    @Override
    public ResponseEntity<Visit> addVisit(VisitDTO visitDTO,  String idProperty, String idCustomer) {
        try {

            Date date = new Date();
            Instant instanceNow = date.toInstant();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity <String> entity = new HttpEntity<>(headers);

            Object property= rest.exchange("https://pim-manazello-backend.herokuapp.com/property/show/"+idProperty, HttpMethod.GET,
                    entity, Object.class).getBody();

            Customer customer = customerRepository.findById(idCustomer).get();

            Visit visitToPersist = new Visit(visitDTO.getId(),
                    visitDTO.getDateVisit(),
                    visitDTO.getHourVisit(),
                    visitDTO.getRefVisit(),
                    visitDTO.getDescription(),
                    visitDTO.getAvailability(),
                    visitDTO.getStatus(),
                    visitDTO.getTitle(),
                    "False",
                    instanceNow, instanceNow,
                    customer,
                    property);

            iCustomerBusiness.updateCustomerStatusAsClient(customer,idCustomer);
            visitRepository.save(visitToPersist);
           Twilio.init("AC0d0a24903b106bdb1f05aa3c201745a4", "fa78cbd496d10a7312f9c2b2db7b2cd9");
                Message.creator(new com.twilio.type.PhoneNumber(customer.getPhone()),
                        new PhoneNumber("+15619446504"),
                        "Hello from Manazello CRM, you get a visit "+visitDTO.getTitle()+" in "+
                                visitDTO.getDateVisit() +" at "+visitDTO.getHourVisit()).create();



            return ResponseEntity.status(HttpStatus.CREATED).body(visitToPersist);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional
    public Visit updateVisit(Visit visit, String idProperty) {
        Optional<Visit> visitOptional= visitRepository.findById(visit.getId());
        Date date= new Date();
        Instant dateToUpdate= date.toInstant();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<>(headers);


        Object property= rest.exchange("https://pim-manazello-backend.herokuapp.com/property/show/"+idProperty, HttpMethod.GET,
                entity, Object.class).getBody();

            visit.setProperty(property);
        visit.setModifiedAt(dateToUpdate);
        return (visitOptional.isPresent() ?
                visitRepository.save(visit)
                : null);
    }

    @Override
    public ResponseEntity<String> deleteVisit(String id) {
        if(visitRepository.findById(id).isPresent()){
            visitRepository.deleteById(id);
            return new ResponseEntity<>("Visit deleted Successfully!",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Visit not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Visit> getAllVisits() {
        return visitRepository.findAll(Sort.by("dateVisit").descending());
    }

    @Override
    public ResponseEntity<Visit> getVisitByID(String id) {
        Optional<Visit> visitData = visitRepository.findById(id);
        return visitData.map(visit -> new ResponseEntity<>(visit, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

    }


    @Override
    public Visit archiveVisit(Visit visit, String id) {
        Optional<Visit> visitDetails= visitRepository.findById(id);
        Date date= new Date();
        Instant dateToUpdate= date.toInstant();
        visit.setModifiedAt(dateToUpdate);
        visit.setArchive("True");
        return (visitDetails.isPresent() ?
                visitRepository.save(visit)
                : null);
    }

    @Override
    public Visit cancelArchiveVisit(Visit visit, String id) {
        Optional<Visit> visitDetails= visitRepository.findById(id);
        Date date= new Date();
        Instant dateToUpdate= date.toInstant();
        visit.setModifiedAt(dateToUpdate);
        visit.setArchive("False");
        return (visitDetails.isPresent() ?
                visitRepository.save(visit)
                : null);
    }

    @Override
    public List<Visit> findAllVisitTitleASC(String archive) {
        return visitRepository.findVisitsByArchiveOrderByTitleAsc(archive);
    }


    @Override
    public List<Visit> findAllVisitTitleDESC(String archive) {
        return visitRepository.findVisitsByArchiveOrderByTitleDesc(archive);
    }

    @Override
    public List<Visit> findAllLastsVisitTitleDESC(String archive, Customer id) {
        return visitRepository.findVisitsByArchiveAndCustomerOrderByDateVisitDesc(archive,id);
    }


    @Override
    public List<Visit> getVisitsCreatedAtDesc( String archive) {
        return visitRepository.findVisitsByArchiveOrderByCreatedAtDesc(archive);
    }


    @Override
    public List<Visit> getVisitsCreatedAtAsc( String archive) {
        return visitRepository.findVisitsByArchiveOrderByCreatedAtAsc(archive);
    }
    @Override
    public  List<Visit> getVisitsNonArchived( String archive) {
        return visitRepository.findVisitsByArchive(archive);
    }
    @Override
    public List<Visit> getVisitsByCustomers() {
        return visitRepository.findVisitsByCustomerOrderByCreatedAt();
    }


}
