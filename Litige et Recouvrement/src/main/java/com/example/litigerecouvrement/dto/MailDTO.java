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
public class MailDTO {
    private UUID id = UUID.randomUUID();
    private String maile ;
    private String objet ;
    private String emetteur ;
}
