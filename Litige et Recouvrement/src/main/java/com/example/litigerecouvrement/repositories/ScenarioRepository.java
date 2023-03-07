package com.example.litigerecouvrement.repositories;

import com.example.litigerecouvrement.entites.Scenario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioRepository extends MongoRepository<Scenario, String> {
}
