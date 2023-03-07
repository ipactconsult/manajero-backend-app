package com.employees.main.repositories;

import com.employees.main.entities.Skills;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SkillsRepository extends MongoRepository<Skills,String> {

    List<Skills> findAllByEmployee(String id);

}
