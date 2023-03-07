package com.employees.main.repositories;

import com.employees.main.entities.Pay;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PayRepository extends MongoRepository<Pay,String> {

        List<Pay> findAllByIsArchived(String isArchived);
}
