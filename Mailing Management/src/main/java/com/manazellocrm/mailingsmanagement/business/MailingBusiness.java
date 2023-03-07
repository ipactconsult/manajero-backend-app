package com.manazellocrm.mailingsmanagement.business;

import com.manazellocrm.mailingsmanagement.business.ibusiness.IMailingBusiness;
import com.manazellocrm.mailingsmanagement.entities.Customer;
import com.manazellocrm.mailingsmanagement.entities.Employee;
import com.manazellocrm.mailingsmanagement.utils.BirthdayMail;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;



import java.util.*;

import static com.manazellocrm.mailingsmanagement.utils.EmailInvitation.*;


@Service
@RequiredArgsConstructor
public class MailingBusiness implements IMailingBusiness {

    private static final Logger logger = LoggerFactory.getLogger(MailingBusiness.class);
    private final RestTemplate rest;
    final JavaMailSender javaMailSender;

    final RestTemplate restTemplate;
    public void sendEmail(String subject, String body, String email){
        MimeMessage emailMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(emailMessage, true);
            helper.setTo( email);
            helper.setSubject(subject);
            helper.setText(body, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
                javaMailSender.send(emailMessage);
    }


    @Override
    public void invitEmployee(String email, String matriculate , String role){
        String token = restTemplate.getForObject("https://auth-manazello.herokuapp.com/api/auth/generateToken/"+email, String.class);
        String vue =EMAIL_PART_ONE+ "https://manazello-client-henna.vercel.app/#/register/"+email+"/"+token+"/"+matriculate+"/"+role+""+EMAIL_PART_TWO;

        sendEmail("Invitation",vue,email);
    }



    @Override
   // @Scheduled(cron="*/10 * * * * *")
    public void sendMail() {
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<List<Customer>> customerRest = rest.exchange("http://localhost:8083/api/customer/customer-by-birth",
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<List<Customer>>() {});
            String msg = "Customer : " + customerRest;
            logger.info(msg);
            List<Customer> listCustomers = customerRest.getBody();
            assert listCustomers != null;
            for (Customer customer1: listCustomers) {
                sendEmail("Birthday Wishes", EMAIL_PART_ONE+ BirthdayMail.EMAIL_PART_TWO, customer1.getWorkEmail());

            }
        } catch (Exception e) {

          logger.error("Exception : "+e);

        }
    }

    @Override
    @Scheduled(cron="*/10 * * * * *")
    public void sendMailEmployee() {
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<List<Employee>> customerRest = rest.exchange("http://localhost:8060/employee/getbydate",
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<>() {
                    });
            String msg = "Employee : " + customerRest;
            logger.info(msg);
            List<Employee> list = customerRest.getBody();
            assert list != null;
            for (Employee employee: list) {
                sendEmail("Birthday Wishes", EMAIL_PART_ONE+ BirthdayMail.EMAIL_PART_TWO, employee.getEmployeeEmail());

            }
        } catch (Exception e) {

            logger.error(""+e);

        }
    }





}

