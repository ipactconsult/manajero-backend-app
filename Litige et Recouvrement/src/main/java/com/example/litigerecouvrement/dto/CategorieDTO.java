package com.example.litigerecouvrement.dto;

import com.example.litigerecouvrement.entites.Loi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategorieDTO {

    private String id;

    private String categoriename ;
    private List<Loi> lois ;
    private String description ;
    private String archive;



}
