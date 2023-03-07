package com.employees.main.repositories;

import com.employees.main.entities.Mckenzie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MckenzieRepository extends MongoRepository<Mckenzie,String> {
}
