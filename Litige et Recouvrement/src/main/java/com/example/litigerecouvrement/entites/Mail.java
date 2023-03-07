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
public class Mail {
    private UUID id = UUID.randomUUID();
    private String maile ;
    private String objet ;
    private String emetteur ;




}
