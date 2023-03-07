package com.example.litigerecouvrement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CallRapportDTO {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id ;
    private String rapport ;
}
