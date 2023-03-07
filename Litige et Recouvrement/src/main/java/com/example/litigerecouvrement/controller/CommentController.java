package com.example.litigerecouvrement.controller;

import com.example.litigerecouvrement.ibusniess.CommentIBusiness;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path= {"/comment"}, produces= APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class CommentController {
    private final ModelMapper modelMapper;
    @Autowired
    final
    CommentIBusiness commentIB;


    public CommentController(ModelMapper modelMapper, CommentIBusiness commentIB) {
        this.modelMapper = modelMapper;
        this.commentIB = commentIB;
    }
}
