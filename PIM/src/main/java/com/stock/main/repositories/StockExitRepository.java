package com.stock.main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stock.main.entities.StockExit;

@Repository
public interface StockExitRepository extends MongoRepository<StockExit, String> {

}
