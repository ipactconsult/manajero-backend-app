package com.employees.main.repositories;


import com.employees.main.entities.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {

    @Query(value = "{'employees.employeeName' : ?0}", fields = "{'employees': 0}")
    Department findDepartmentByEmployeeName(String employeeName);
    List<Department> findDepartmentByDepartmentName(String departmentName);

    List<Department> findDepartmentsByIsArchived(String isArchived);
}
