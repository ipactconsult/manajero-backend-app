package com.example.litigerecouvrement.repositories;

import com.example.litigerecouvrement.entites.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment,String>{

}
