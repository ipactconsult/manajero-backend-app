package com.stock.main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stock.main.entities.Supplier;

@Repository
public interface SupplierRepository extends MongoRepository<Supplier, String> {

}
