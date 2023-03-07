package com.manazellocrm.mailingsmanagement.business.ibusiness;

import org.springframework.http.ResponseEntity;


public interface IMailingBusiness {


    void sendMail();
    void sendMailEmployee();
    void invitEmployee(String email, String matriculate , String role);





    }
