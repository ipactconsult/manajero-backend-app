package com.example.litigerecouvrement.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="dossierjuridique")
public class Dossier {
  private String id ;

  @DocumentReference
    private Relance relance ;
    private Penalty penalty;

    @DocumentReference
    private Avocat avocat ;
   private Boolean statut  ;
   private Date date ;

//AC9344995aa45100628015d6da4c5ad2d2
// 544b84e1bdef5e6d3bb794e7fec1f0ab
}
