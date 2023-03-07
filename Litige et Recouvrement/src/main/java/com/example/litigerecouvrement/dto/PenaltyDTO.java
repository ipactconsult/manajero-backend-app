package com.example.litigerecouvrement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PenaltyDTO {

    private UUID id = UUID.randomUUID();
    private float taux ;
    private float montant ;
    private int nbrdejours;
    private float totale;
}
