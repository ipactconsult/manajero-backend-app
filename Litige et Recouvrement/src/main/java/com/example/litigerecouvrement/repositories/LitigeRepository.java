package com.example.litigerecouvrement.repositories;

import com.example.litigerecouvrement.entites.Litige;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LitigeRepository extends MongoRepository<Litige,String> {
}
