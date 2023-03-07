package com.stock.main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stock.main.entities.Warehouse;

@Repository
public interface WarehouseRepository extends MongoRepository<Warehouse, String> {

}
