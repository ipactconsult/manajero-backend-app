package com.example.litigerecouvrement.repositories;

import com.example.litigerecouvrement.entites.CallRapport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallRapportRepository extends MongoRepository<CallRapport,String> {
}
