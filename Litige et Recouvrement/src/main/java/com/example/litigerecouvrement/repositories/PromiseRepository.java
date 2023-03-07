package com.example.litigerecouvrement.repositories;

import com.example.litigerecouvrement.entites.Promise;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PromiseRepository extends MongoRepository<Promise,String> {

}
