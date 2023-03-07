package com.communicationMarketing.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.communicationMarketing.main.entity.Persona;

@Repository
public interface PersonnaRepository  extends MongoRepository<Persona,String> {

}
