package com.communicationMarketing.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.communicationMarketing.main.entity.GraphicalCharter;

@Repository
public interface GraphicalCharterRepository   extends MongoRepository<GraphicalCharter,String> {

}

