package com.example.litigerecouvrement.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "litige")
public class Litige {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    String id ;
    String typelitige ;
    String description ;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date datederesoution ;
    Statut statut ;
    Date nouvelledatechance ;
    private String archive;


}
