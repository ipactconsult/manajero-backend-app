package com.example.litigerecouvrement.dto;

import com.example.litigerecouvrement.entites.CategorieDoc;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoiDTO {

    private String id;

    private String docName;
    private String docType;
    private String file ;

    private CategorieDoc cat;
    private String archive;




}
