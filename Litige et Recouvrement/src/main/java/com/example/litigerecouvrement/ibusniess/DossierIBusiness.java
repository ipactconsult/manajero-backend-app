package com.example.litigerecouvrement.ibusniess;

import com.example.litigerecouvrement.dto.DossierDTO;
import com.example.litigerecouvrement.entites.Dossier;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DossierIBusiness {

    Dossier createDossier(Dossier dos);
    List<Dossier> findAllDosssier();
    ResponseEntity<Dossier> findByDossier(DossierDTO dossierDTO);


   Dossier findByid(String id);
    Dossier updateDossier(String id,Dossier dossier);


    String deleteDossier(String ida) ;
}
