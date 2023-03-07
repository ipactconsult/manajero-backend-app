package com.example.litigerecouvrement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PromiseDTO {

    private String id;
    private float amount ;
    private Date datedepaiement ;


}
