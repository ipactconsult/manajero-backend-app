package com.communicationMarketing.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.communicationMarketing.main.entity.Comment;

@Repository
public interface CommentRepository  extends MongoRepository<Comment,String> {

}
