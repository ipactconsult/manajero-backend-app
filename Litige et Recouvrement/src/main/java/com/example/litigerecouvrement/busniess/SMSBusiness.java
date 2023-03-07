package com.example.litigerecouvrement.busniess;

import com.example.litigerecouvrement.entites.Relance;
import com.example.litigerecouvrement.entites.SMS;
import com.example.litigerecouvrement.ibusniess.SMSIBusiness;
import com.example.litigerecouvrement.repositories.RelanceRepository;
import com.example.litigerecouvrement.repositories.SMSRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SMSBusiness implements SMSIBusiness {
final private SMSRepository smsrepo;
   final private RelanceRepository repo;

    public SMSBusiness(SMSRepository smsrepo, RelanceRepository repo) {
        this.smsrepo = smsrepo;
        this.repo = repo;
    }


    @Override
    public void sendSMS(SMS sms ,String id) {

        Relance relance  =repo.findById(id).orElse(null);

        System.out.println(relance);
if (relance!=null){

        String body = "Hello from Manazello CRM, you get a visit "+relance.getInvoice().getTitle() ;
        Twilio.init("AC9344995aa45100628015d6da4c5ad2d2", "544b84e1bdef5e6d3bb794e7fec1f0ab");
    System.out.println(relance.getInvoice().getClientPhone());
        Message.creator(new com.twilio.type.PhoneNumber("+21624551966"),
                new PhoneNumber("+18646598483"),
               sms.getRapportsms()).create();


}





    }

    @Override
    public List<SMS> findAllSMS() {
        return null;
    }

    @Override
    public String deleteSMS(String idc) {
        return null;
    }

    @Override
    public ResponseEntity<SMS> findByid(String id) {

        Optional<SMS> findbyref = smsrepo.findById(id);
        return (
                findbyref.isPresent() ?
                        new ResponseEntity<>(findbyref.get(), HttpStatus.OK)
                        : new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public long countSMS() {
        return smsrepo.count();
    }

    @Override
    public SMS updateSMS(SMS sms) {
        return null;
    }
}
