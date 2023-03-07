package com.example.litigerecouvrement.controller;

import com.example.litigerecouvrement.busniess.EmailSendService;
import com.example.litigerecouvrement.entites.Litige;
import com.example.litigerecouvrement.repositories.LitigeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins="*")
public class EmailController {



    @Autowired
    EmailSendService emailSendService;
    @Autowired
    LitigeRepository or;
    @PostMapping("/sendEmail/{id}")
    @ResponseBody
    public int sendEmail(@PathVariable("id") String id){
        Litige ord = or.findById(id).orElse(null) ;


        emailSendService.sendEmail("wassim.rabai@esprit.tn", "Mangement Dispute", "hello !!",ord);



        return 1;
    }


    @PostMapping("/sendEmailApres/{id}")
    @ResponseBody
    public int sendEmailResolu(@PathVariable("id") String id) {
        Litige ord = or.findById(id).orElse(null) ;


        emailSendService.sendEmailResolu("wassim.rabai@esprit.tn", "Mangement Dispute", "hello !!",ord);

        return 1 ;
    }
}

