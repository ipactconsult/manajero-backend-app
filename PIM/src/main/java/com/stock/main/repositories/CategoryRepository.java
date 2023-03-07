package com.stock.main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stock.main.entities.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}
