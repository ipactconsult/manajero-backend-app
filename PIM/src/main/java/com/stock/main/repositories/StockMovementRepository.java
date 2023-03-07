package com.stock.main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stock.main.entities.StockMovement;

@Repository
public interface StockMovementRepository extends MongoRepository<StockMovement, String> {

}
