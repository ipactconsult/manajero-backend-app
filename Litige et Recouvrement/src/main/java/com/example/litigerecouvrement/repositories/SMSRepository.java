package com.example.litigerecouvrement.repositories;

import com.example.litigerecouvrement.entites.SMS;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SMSRepository extends MongoRepository<SMS,String> {
}
