package com.example.litigerecouvrement.ibusniess;

import com.example.litigerecouvrement.entites.Mail;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MailIBusiness {
    Mail createMail(Mail mail);
    List<Mail> findAllMail();
     String deleteMail(String ida) ;
    ResponseEntity<Mail> findByid(String id);
    long countMail();
    void sendEmail(Mail mail ) ;
     Mail updateMail(Mail mail);

}
