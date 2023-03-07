package com.example.litigerecouvrement.ibusniess;

import com.example.litigerecouvrement.entites.Avocat;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AvocatIBusiness {
    Avocat createAvocat(Avocat avocat);
    List<Avocat> findAllAvocat();
    public String deleteAvocat(String ida) ;
    ResponseEntity<Avocat> findByid(String id);

    long countAvocat ();
    List<Avocat> findAllAvocatASC();
    List<Avocat> findAllAvocatDESC();

    Avocat archiveAvocat(Avocat avocat, String id);
    Avocat cancelArchiveAvocat(Avocat avocat, String id);

    List<Avocat> findNonArchivedAvocat(String archive);




     Avocat updateAvocat(Avocat avc,String id);
    ResponseEntity<List<Avocat>> findAvocatBySpecialite();
}
