package com.stock.main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stock.main.entities.RequestForQuotation;

@Repository
public interface RequestForQuotationRepository extends MongoRepository<RequestForQuotation, String> {

}
