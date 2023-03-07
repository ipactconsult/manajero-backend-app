package com.example.litigerecouvrement.controller;

import com.example.litigerecouvrement.ibusniess.CallRapportIBusiness;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path= {"/call"}, produces= APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class CallRapportController {
    private final ModelMapper modelMapper;
    @Autowired
    final
    CallRapportIBusiness call;


    public CallRapportController(ModelMapper modelMapper, CallRapportIBusiness call) {
        this.modelMapper = modelMapper;
        this.call = call;
    }
}
