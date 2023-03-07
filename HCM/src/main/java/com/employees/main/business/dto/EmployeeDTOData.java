package com.employees.main.business.dto;

import com.employees.main.entities.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTOData {

    private String id;

    private String employeeName;

    private String employeeProfileImage;

    private String employeeEmail;

    private String employeeCellPhone;

    @DocumentReference(lazy = true)
    private Department department;

    private String profileEmployee;

    private String roleEmployee;

    private String isArchived;
}
