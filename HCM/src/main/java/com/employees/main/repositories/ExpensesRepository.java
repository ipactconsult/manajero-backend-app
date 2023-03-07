package com.employees.main.repositories;

import com.employees.main.entities.Expenses;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpensesRepository extends MongoRepository<Expenses,String> {

    List<Expenses> findAllByStatus(String status);
}
