package com.example.litigerecouvrement.entites;

import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="actionscenario")

public class ActionScenario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    private String actionename ;
    private int nbrjr ;
    private String typeaction ;
    @DocumentReference
    private Scenario sce;


}
