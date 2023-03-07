package com.example.litigerecouvrement.controller;

import com.example.litigerecouvrement.dto.MailDTO;

import com.example.litigerecouvrement.entites.Mail;
import com.example.litigerecouvrement.ibusniess.MailIBusiness;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path= {"/email"}, produces= APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class MailController {
    private final ModelMapper modelMapper;


    public static final String DIRECTERY =System.getProperty("user.home")+"Downloads/uploads/";
    @Autowired
    final
    MailIBusiness mailIB;
    @Autowired
    MailIBusiness mailService;

    public MailController(ModelMapper modelMapper, MailIBusiness mailIB) {
        this.modelMapper = modelMapper;
        this.mailIB = mailIB;
    }

    @PostMapping("/sendEmail")
    @ResponseBody
    public int sendEmail(@RequestBody MailDTO mailDTO ){
        Mail mm = modelMapper.map(mailDTO,Mail.class);
        mailService.sendEmail(mm);

        return 1;
    }

}
