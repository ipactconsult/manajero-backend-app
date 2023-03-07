package com.employees.main.business.ibusiness;

import com.employees.main.business.dto.*;
import com.employees.main.entities.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IBusinessEmploye {

    Employee createEmployee(EmployeeDTO employeeDTO);
    List<Employee> findAllEmps();

    int countEmps();

    List<String>getDistinctProfiles();

    List<EmployeeSelect> getEmployeesSelect();

    List findAllDataById(List<String>ids);

    List<EmployeePMP> findEmpsPMP(String employeeProfile);

    List<Employee> findAllEmployeesDESC();
    ResponseEntity<String> deleteEmployeeById(String id);
    long countEmployees();
    ResponseEntity<Employee>findByid(String id);
    Employee updateEmployee(String id, EmployeeDTO employeeDTO);
    List<EmployeeCRM> getByRoleEmployee();
    Employee editArchived(EmployeeDTO employeeDTO, String id);
    Employee editRestored(EmployeeDTO employeeDTO, String id);

    List<Employee> findAllEmployeesAsc();

    List<EmployeeDTOData>findCustomEmployees();

    EmployeePMP getByEmail(String employeeEmail);

    List<Employee> getEmployeeByBirthDate();

    Optional<EmployeePMP> getOne(String id);

    List<EmployeePMP> getAllEmpPmp();
}
