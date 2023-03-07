package com.communicationMarketing.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.communicationMarketing.main.entity.Like;

@Repository
public interface LikeRepository  extends MongoRepository<Like,String>{

}
