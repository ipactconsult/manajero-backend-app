package com.example.litigerecouvrement.ibusniess;



import com.example.litigerecouvrement.entites.SMS;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SMSIBusiness {
    void sendSMS(SMS sms ,String id  ) ;
    List<SMS> findAllSMS();
    public String deleteSMS(String idc) ;
    ResponseEntity<SMS> findByid(String id);

    long countSMS ();
    public SMS updateSMS(SMS sms);
}
