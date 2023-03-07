package com.employees.main.repositories;

import com.employees.main.entities.SubDepartment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubDepartmentRepository extends MongoRepository<SubDepartment,String> {

    List<SubDepartment> findByDepartment(String departmentName);
}
