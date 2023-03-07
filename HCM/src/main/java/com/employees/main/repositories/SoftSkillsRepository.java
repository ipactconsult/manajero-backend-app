package com.employees.main.repositories;

import com.employees.main.entities.SoftSkills;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoftSkillsRepository extends MongoRepository<SoftSkills,String> {

    List<SoftSkills> findByEmployeeIsNotNull(String idEmployee, String isArchived);
}
