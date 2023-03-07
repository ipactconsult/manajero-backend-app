package com.example.litigerecouvrement.busniess;

import com.example.litigerecouvrement.entites.Mail;
import com.example.litigerecouvrement.ibusniess.MailIBusiness;
import com.example.litigerecouvrement.repositories.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Optional;


@Service
public class MailBusiness implements MailIBusiness {
    @Autowired
    private MailRepository mailrepo;
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public Mail createMail(Mail mail) {
        return mailrepo.save(mail);
    }

    @Override
    public List<Mail> findAllMail() {
        return null;
    }

    @Override
    public String deleteMail(String ida) {
        return null;
    }

    @Override
    public ResponseEntity<Mail> findByid(String id) {
        Optional<Mail> findbyref = mailrepo.findById(id);
        return (
                findbyref.isPresent() ?
                        new ResponseEntity<>(findbyref.get(), HttpStatus.OK)
                        : new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public long countMail() {
        return mailrepo.count();
    }

    @Override
    public void sendEmail(Mail mail ) {

        MimeMessage messsg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(messsg, true);
            helper.setTo(mail.getEmetteur());
            helper.setSubject(mail.getObjet());
            helper.setText(mail.getMaile(),false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(messsg);

    }

    @Override
    public Mail updateMail(Mail mail) {
        return null;
    }


}
