package com.example.litigerecouvrement.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Penalty {
    private UUID id = UUID.randomUUID();
    private float taux ;
    private float montant ;
    private int nbrdejours;
    private float totale;
}
