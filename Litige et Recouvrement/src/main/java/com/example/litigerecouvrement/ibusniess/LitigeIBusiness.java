package com.example.litigerecouvrement.ibusniess;

import com.example.litigerecouvrement.entites.Litige;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LitigeIBusiness {
    Litige createLitige(Litige lit);
    List<Litige> findAllLitige();
     Litige deleteLitige(String idl) ;
    long countLitige();
     ResponseEntity<Litige> findByid(String id) ;
      Litige updateLitige(String id,Litige litige) ;
     Litige getLitigeById(String id);

}
