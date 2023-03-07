package com.manazellocrm.mailingsmanagement.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String id;

    private String employeeReference;

    private String employeeName;

    private String employeeProfileImage;

    private String employeeProfile;

    private String employeePasseport;


    private String employeeSocialSecurity;


    private String employeeGender;



    private String employeeEducation;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date employeeDateOfBirth;

    private String employeeNationality;

    private String employeeMaritalStatus; //célibataire,marié,...

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

    @Column(name="createdAt", updatable = false)
    private Instant createdAt = new Date().toInstant();

    private String roleEmployee;

    private String isArchived;

    private String user;
}

