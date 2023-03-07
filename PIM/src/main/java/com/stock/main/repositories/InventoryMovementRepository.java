package com.stock.main.repositories;

import com.stock.main.entities.InventoryMovement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryMovementRepository extends MongoRepository<InventoryMovement, String> {
    
}
