package com.manazellocrm.mailingsmanagement.controllers;

import com.manazellocrm.mailingsmanagement.business.ibusiness.IMailingBusiness;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = { "/api/mailing" }, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
@RestController
public class MailingController {

    IMailingBusiness iMailingBusiness;
    public MailingController(IMailingBusiness iMailingBusiness){
        this.iMailingBusiness = iMailingBusiness;
    }


    @GetMapping ("/mailings")
    public void addCustomer (){
         iMailingBusiness.sendMail( );
    }


    @PostMapping("/invite/{email}/{matriculate}/{role}")
    public void invite(@PathVariable("email")String email, @PathVariable("matriculate")String matriculate, @PathVariable("role")String role)
    {
        iMailingBusiness.invitEmployee(email,matriculate,role);
    }


}
