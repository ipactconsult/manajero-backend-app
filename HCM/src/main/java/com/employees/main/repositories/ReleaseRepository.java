package com.employees.main.repositories;

import com.employees.main.entities.Employee;
import com.employees.main.entities.Release;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReleaseRepository extends MongoRepository<Release,String> {

    List<Release> findAllByReleaseStatus(String releaseStatus);
    List<Release> findReleasesByEmployee(Employee employee);
}
