package com.employees.main.business.ibusiness;

import com.employees.main.business.dto.DepartmentDTO;
import com.employees.main.entities.Department;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDepartmentBusiness {
    ResponseEntity<Department> createDepartment(DepartmentDTO department);
    List<Department> findAllDepartments();

    List<Department> historyDepts();
    Department updateDepartment(String id, DepartmentDTO departmentDTO);
    ResponseEntity<String> deleteDepartmentByReference(String id);
    ResponseEntity<Department>findByDepartment(DepartmentDTO departmentDTO);
    ResponseEntity<Department>findByid(String id);
    long countDepartments ();
    List<Department> getDepartmentByDepartmentName(String departmentName);
    Department listDepartment(String employeeName);
    Department updateDepartmentByIsArchived(DepartmentDTO departmentDTO, String id);
    Department updateDepartmentByIsRestored(DepartmentDTO departmentDTO, String id);
}
