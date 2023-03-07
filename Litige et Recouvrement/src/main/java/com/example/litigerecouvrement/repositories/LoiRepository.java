package com.example.litigerecouvrement.repositories;

import com.example.litigerecouvrement.entites.CategorieDoc;
import com.example.litigerecouvrement.entites.Loi;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LoiRepository extends MongoRepository<Loi, String> {
   // @Query("{'cat.categoriename': ?0}")
    List<Loi> getLoiByCat(CategorieDoc cat);

}
