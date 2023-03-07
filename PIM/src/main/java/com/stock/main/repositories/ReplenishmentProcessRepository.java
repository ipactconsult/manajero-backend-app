package com.stock.main.repositories;

import com.stock.main.entities.ReplenishmentProcess;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplenishmentProcessRepository extends MongoRepository<ReplenishmentProcess, String> {
    
}
