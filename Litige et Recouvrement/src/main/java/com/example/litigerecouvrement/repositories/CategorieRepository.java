package com.example.litigerecouvrement.repositories;

import com.example.litigerecouvrement.entites.CategorieDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends MongoRepository<CategorieDoc, String> {
}
