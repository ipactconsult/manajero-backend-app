package com.example.litigerecouvrement.repositories;

import com.example.litigerecouvrement.entites.Relance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface RelanceRepository extends MongoRepository<Relance, String> {
    List<Relance> findRelanceByArchiveAndCloture(String archive,Boolean cloture);
    List<Relance> findAllByPremierrelance(Instant ins);




}
