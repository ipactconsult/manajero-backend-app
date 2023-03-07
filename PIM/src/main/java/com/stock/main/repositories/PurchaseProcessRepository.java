package com.stock.main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stock.main.entities.PurchaseProcess;

@Repository
public interface PurchaseProcessRepository extends MongoRepository<PurchaseProcess, String> {
    
}
