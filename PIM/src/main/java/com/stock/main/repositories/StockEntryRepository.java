package com.stock.main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stock.main.entities.StockEntry;

@Repository
public interface StockEntryRepository extends MongoRepository<StockEntry, String> {

}
