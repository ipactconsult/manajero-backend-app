package com.example.litigerecouvrement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AvocatDTO {
    private String id;
    private String nom ;
    private String prenom ;
    private String imageUrl ;
    private String specialite;
    private String adresse;
    private Date dateofBirth ;
    private String gmail ;
    private String description;
    private int numtelephone;
    private String secondEmail;
    private String secondPhone;
    private String archive;
    private Instant modifiedAt;
    private Date disponabilite ;






}
