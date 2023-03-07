package com.example.litigerecouvrement.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="avocats")
public class Avocat {
    @Id
    @Indexed(unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    private String nom ;
    private String prenom ;
    private String imageUrl ;
    private String specialite;
    private String adresse;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateofBirth ;
    private String gmail ;
    private String description;
    private int numtelephone;
    private String secondEmail;
    private String secondPhone;
    private String archive;
    @Column(name = "modified_at")
    private Instant modifiedAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date disponabilite ;








}
