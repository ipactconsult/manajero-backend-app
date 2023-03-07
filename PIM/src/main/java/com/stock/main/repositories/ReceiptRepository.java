package com.stock.main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stock.main.entities.Receipt;

@Repository
public interface ReceiptRepository extends MongoRepository<Receipt, String> {

}
