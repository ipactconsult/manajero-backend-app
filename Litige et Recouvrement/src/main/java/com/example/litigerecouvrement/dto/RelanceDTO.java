package com.example.litigerecouvrement.dto;

import com.example.litigerecouvrement.entites.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelanceDTO {

    private String id;
    private Invoice  invoice ;
    private Instant premierrelance ;
    private List<Mail> email ;
    private List<Comment> comment ;
    private List<CallRapport> call ;
    private List<SMS> sms ;
    private Promise promise ;
    private Instant datecloture ;
    private Boolean cloture ;
    private String archive;
    private Instant modifiedAt;
    private float penalty ;

}
