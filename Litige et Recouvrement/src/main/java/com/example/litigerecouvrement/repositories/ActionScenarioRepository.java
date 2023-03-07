package com.example.litigerecouvrement.repositories;

import com.example.litigerecouvrement.entites.ActionScenario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionScenarioRepository  extends MongoRepository<ActionScenario, String> {
}
