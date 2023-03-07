package com.manazello.pm.repositories;

import com.manazello.pm.entities.Historique;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistoriqueRepository extends MongoRepository<Historique,String> {
}
