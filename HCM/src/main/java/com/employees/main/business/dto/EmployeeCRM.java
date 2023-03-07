package com.employees.main.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeCRM {

    private String id;

    private String employeeName;

    private String employeeEmail;

    private String employeeProfileImage;

    private String employeeCellPhone;

    private String roleEmployee;

    private String isArchived;
}
