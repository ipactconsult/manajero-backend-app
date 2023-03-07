package com.example.litigerecouvrement.controller;


import com.example.litigerecouvrement.entites.SMS;
import com.example.litigerecouvrement.ibusniess.SMSIBusiness;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path= {"/sms"}, produces= APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class SMSController {
    private final ModelMapper modelMapper;
    @Autowired
    final
    SMSIBusiness smsIB;

    public SMSController(ModelMapper modelMapper, SMSIBusiness smsIB) {
        this.modelMapper = modelMapper;
        this.smsIB = smsIB;
    }

    @PostMapping("/sendSms/{ar}")
    @ResponseBody
    public int sendSms(@RequestBody SMS sms , @PathVariable String ar){
        smsIB.sendSMS(sms,ar);

        return 1;
    }
}
