package com.example.litigerecouvrement.ibusniess;

import com.example.litigerecouvrement.entites.Promise;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PromiseIBusiness {

    Promise createPromise(Promise promise);
    public String deletePromise(String ida) ;
    ResponseEntity<Promise> findByid(String id);
    long countPromise ();
    Promise getPromiseRelance(String id) ;
    List<Promise> findAllPromise();
    Promise updatePromise(Promise avc,String id);

}
