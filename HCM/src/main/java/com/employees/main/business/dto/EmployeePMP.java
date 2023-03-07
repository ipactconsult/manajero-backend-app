package com.employees.main.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePMP {

    private String id;

    private String employeeName;

    private String employeeProfileImage;

    private String employeeEmail;

    private String employeeProfile;

    private String isArchived;
}
