package com.example.litigerecouvrement.dto;

import com.example.litigerecouvrement.entites.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelanceRequestDTO {

    private String id;
    private String invoice ;
    private Instant premierrelance ;
    private List<Mail> email =new ArrayList<>();
    private List<Comment> comment =new ArrayList<>();
    private List<CallRapport> call =new ArrayList<>();
    private List<SMS> sms =new ArrayList<>() ;
    private List<Promise> promise =new ArrayList<>() ;
    private Instant datecloture ;
    private Boolean cloture = Boolean.FALSE ;
    private String archive ="false";
    private Instant modifiedAt;
    private float penalty ;

}
