package com.stock.main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stock.main.entities.Property;

@Repository
public interface PropertyRepository extends MongoRepository<Property, String> {

}
