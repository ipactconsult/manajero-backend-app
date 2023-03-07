package com.employees.main.business.ibusiness;

import com.employees.main.business.dto.SubDepartmentDTO;
import com.employees.main.entities.SubDepartment;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IBusinessSubDepartment {

    ResponseEntity<SubDepartment> createSubDepartment(SubDepartmentDTO subDepartmentDTO);
    List<SubDepartment> findAllSubDepartments();
    List<SubDepartment> findByDepartment(String departmentName);
    SubDepartment editSubDepartment(String id, SubDepartmentDTO subDepartmentDTO);
    Optional<SubDepartment> findById(String id);
    ResponseEntity<String>deleteSub(String id);

}
