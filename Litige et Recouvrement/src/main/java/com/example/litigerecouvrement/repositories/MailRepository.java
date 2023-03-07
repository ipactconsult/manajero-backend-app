package com.example.litigerecouvrement.repositories;

import com.example.litigerecouvrement.entites.Mail;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface MailRepository extends MongoRepository<Mail,String> {


}
