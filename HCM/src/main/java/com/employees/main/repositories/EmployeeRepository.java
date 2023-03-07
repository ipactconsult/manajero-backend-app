package com.employees.main.repositories;

import com.employees.main.business.dto.EmployeeCRM;
import com.employees.main.business.dto.EmployeeDTOData;
import com.employees.main.business.dto.EmployeePMP;
import com.employees.main.business.dto.EmployeeSelect;
import com.employees.main.entities.Employee;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    @Query("{$expr:{$and:[{$eq:[{$dayOfMonth:'$employeeDateOfBirth'}, ?0]}, {$eq:[{$month:'$employeeDateOfBirth'}, ?1]}]}}")
    List<Employee> findByCustomQuery(int day, int month);
    List<Employee> findEmployeesByIsArchived (String isArchived);
    List<EmployeeCRM> getEmployeeCRMByRoleEmployeeAndIsArchived(String roleEmployee, String isArchived);

    List<EmployeePMP> findEmployeesByIsArchivedAndEmployeeProfile (String isArchived,String employeeProfile);

    @Aggregation(pipeline = {"{'$group': {'_id': '$employeeProfile' }}"})
    List<String> findDistinctEmployeeProfiles ();

    @Aggregation("{'$project':{'employeeName':1,'employeeProfileImage': 1,'employeeEmail': 1,'employeeCellPhone': 1, 'department': 1,'employeeProfile': 1, 'roleEmployee': 1}  }")
    List<EmployeeDTOData> customQueryEmployeesLight ();

   List<EmployeeSelect> getEmployeesByIsArchived(String isArchived);

   List<Employee> findAllById(List<String>ids);

   Optional<EmployeePMP>getById(String id);


   List<EmployeePMP>findAllByIsArchived(String isArchived);
   
   EmployeePMP findEmployeesByEmployeeEmail(String employeeEmail);




}
