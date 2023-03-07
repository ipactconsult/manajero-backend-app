package com.manazello.pm.repositories;

import com.manazello.pm.dtos.CharterResponseDto;
import com.manazello.pm.entities.Charter;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharterRepository extends MongoRepository<Charter,String> {
    @Aggregation("{ '$project': { 'title' : 1,'statementWork':1,'status':1,'dateSubmited':1 } }")
    List<CharterResponseDto> displaySomeFields();
}
