package com.example.litigerecouvrement.repositories;

import com.example.litigerecouvrement.entites.Avocat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvocatReposiotry extends MongoRepository<Avocat,String> {

    List<Avocat> findAvocatsByArchive(String archive);





}
