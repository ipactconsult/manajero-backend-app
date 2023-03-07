package com.communicationMarketing.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.communicationMarketing.main.entity.GlobalCharter;;

@Repository
public interface GlobalCharterRepository  extends MongoRepository<GlobalCharter,String>  {

}
