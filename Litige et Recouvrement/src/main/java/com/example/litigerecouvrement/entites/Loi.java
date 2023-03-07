package com.example.litigerecouvrement.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "lois")

public class Loi {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    private String docName;
    private String docType;
    private String file ;

@DocumentReference
    private CategorieDoc cat;
    private String archive;






}
