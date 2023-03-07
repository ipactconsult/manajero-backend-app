package com.example.litigerecouvrement.dto;

import com.example.litigerecouvrement.entites.Avocat;
import com.example.litigerecouvrement.entites.Penalty;
import com.example.litigerecouvrement.entites.Relance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DossierDTO {

    private String id ;
    private Relance relance ;
    private Avocat avocat ;
    private Penalty penalty=new Penalty();
    private Boolean statut = false ;
    private Date date = new Date();


}
