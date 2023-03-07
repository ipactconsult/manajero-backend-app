package com.employees.main.business.dto;

import com.employees.main.entities.SubDepartment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private String id;

    private String employeeReference;

    private String employeeName;

    private String employeeProfileImage;

    private String employeeProfile;

    private String employeePasseport;

    private String employeeSocialSecurity;

    private String employeeGender;

    private String employeeEducation;

    private Date employeeDateOfBirth;

    private String employeeNationality;

    private String employeeMaritalStatus;

    private int employeeNbKids;

    private String employeeDrivingLicence;

    private String employeeEmail;

    private String employeeCellPhone;

    private String employeeCity;

    private String employeeCountry;

    private String employeeEmergencyContractPerson;

    private String employeeContractInfo;

    private String employeeBloodType;

    private String employeeHealthProblem;

    private String active;

    private String roleEmployee;

    private Instant createdAt;

    private SubDepartment subDepartment;

    private String isArchived;

    private String accountNum;

    private Date expirationDate;

    private String secretCode;

    private String user;

}
