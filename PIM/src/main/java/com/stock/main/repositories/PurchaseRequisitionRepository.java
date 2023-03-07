package com.stock.main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stock.main.entities.PurchaseRequisition;

@Repository
public interface PurchaseRequisitionRepository extends MongoRepository<PurchaseRequisition, String> {

}
