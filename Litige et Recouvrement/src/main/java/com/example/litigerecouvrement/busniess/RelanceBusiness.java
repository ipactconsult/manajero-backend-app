package com.example.litigerecouvrement.busniess;

import com.example.litigerecouvrement.entites.Invoice;
import com.example.litigerecouvrement.entites.Mail;
import com.example.litigerecouvrement.entites.Relance;
import com.example.litigerecouvrement.ibusniess.RelanceIBusiness;
import com.example.litigerecouvrement.repositories.RelanceRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RelanceBusiness implements RelanceIBusiness {

    final RelanceRepository screp ;
     final RestTemplate rest;
    final JavaMailSender javaMailSender;





    public RelanceBusiness(RelanceRepository screp, RestTemplate rest, JavaMailSender javaMailSender) {
        this.screp = screp;
        this.rest = rest;
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String subject, String body, String email){
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



    @Override
    public Relance createRelance(Relance rel) {

        return screp.save(rel)  ;

    }
    public List<Invoice> getAllInvoices() {
        final String url = "https://accounting-erp.herokuapp.com/invoice/getpastdue-relance";
        final HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> requestEntity = new HttpEntity<>( requestHeaders);
        ResponseEntity<Object> invoice = rest.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                Object.class
        );
        ObjectMapper mapper = new ObjectMapper(); // or inject it as a dependency
        System.out.println(invoice);
        return mapper.convertValue(invoice.getBody(), new TypeReference<List<Invoice>>() {
        });
    }


    @Override
    public List<Relance> findAllRelances(String ar,Boolean clo) {


        return screp.findRelanceByArchiveAndCloture(ar,clo);
    }

    @Override
    public Relance updateRelance(String id, Relance relance) {

        Optional<Relance> relanceOptional= screp.findById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<>(headers);
        Object facture= rest.exchange("https://accounting-erp.herokuapp.com/invoice/getbyid/"+id, HttpMethod.GET,
                entity, Object.class).getBody();
        return (relanceOptional.isPresent()?

                screp.save(relance):null);    }

    @Override
    public Relance findByid(String id) {
        return screp.findById(id).orElse(null);

    }


    @Override
    public String deleteRelance(String idl) {
        screp.deleteById(idl);
        return "Scenario deleted" ;
    }


    @Override
    public Relance cancelArchiveRelance(Relance relance, String id) {
        Optional<Relance> relanceDetails= screp.findById(id);
        Date date= new Date();
        Instant dateToUpdate= date.toInstant();
        relance.setModifiedAt(dateToUpdate);
        relance.setArchive("False");
        return (relanceDetails.isPresent() ?
                screp.save(relance)
                : null);

    }

    @Override
    public List<Mail> findEmailbyRelance(String id) {
         Relance re= screp.findById(id).orElse(null);
         return re.getEmail();
    }



    @Override
    public void sendMail() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<List> invoiceRest = rest.exchange("https://accounting-erp.herokuapp.com/invoice/getpastdue",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<>() {
                });
        String msg = "You have invoice  : " + invoiceRest;
        List<Invoice> list = invoiceRest.getBody();
        assert list != null;
        for (Invoice facture: list) {
            sendEmail("Invoice Management", EmailTemplate.EMAIL, facture.getClientEmail());

    }
}


}
