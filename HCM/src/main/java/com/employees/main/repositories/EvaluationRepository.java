package com.employees.main.repositories;

import com.employees.main.entities.Evaluation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepository extends MongoRepository<Evaluation,String> {

    List<Evaluation>findAllByIsArchived(String isArchived);

}
