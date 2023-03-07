package com.stock.main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stock.main.entities.Material;

@Repository
public interface MaterialRepository extends MongoRepository<Material, String> {

}
