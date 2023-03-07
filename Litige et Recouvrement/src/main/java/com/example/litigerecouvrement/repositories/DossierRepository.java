package com.example.litigerecouvrement.repositories;

import com.example.litigerecouvrement.entites.Dossier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DossierRepository extends MongoRepository<Dossier,String> {
}
