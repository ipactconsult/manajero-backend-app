package com.employees.main.repositories;

import com.employees.main.entities.Level;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends MongoRepository<Level,String> {
}
