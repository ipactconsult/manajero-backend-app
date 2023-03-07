package com.communicationMarketing.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.communicationMarketing.main.entity.PostData;

@Repository
public interface PostDataRepository   extends MongoRepository<PostData,String>  {

}
