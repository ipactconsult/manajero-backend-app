package com.example.litigerecouvrement.dto;

import com.example.litigerecouvrement.entites.Statut;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LitigeDTO {
    String id ;
    String typelitige ;
    String description ;
    Date date;
    Date datederesoution ;
    Statut statut ;
    Date nouvelledatechance ;
    private String archive;




}
