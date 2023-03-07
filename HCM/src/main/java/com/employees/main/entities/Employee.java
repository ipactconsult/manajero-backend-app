package com.employees.main.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Date;

@Document(collection="employee_hr")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    private String id;

    @NotBlank(message = "This field must be not blank")
    @NotNull(message = "This field must be not null")
    private String employeeReference;
    @Indexed(unique = true)

    @NotBlank(message = "This field must be not blank")
    @NotNull(message = "This field must be not null")
    private String employeeName;

    private String employeeProfileImage;

    private String employeeProfile;

    @NotBlank(message = "This field must be not blank")
    @NotNull(message = "This field must be not null")
    private String employeePasseport;

    @NotBlank(message = "This field must be not blank")
    @NotNull(message = "This field must be not null")
    private String employeeSocialSecurity;

    @NotBlank(message = "This field must be not blank")
    @NotNull(message = "This field must be not null")
    private String employeeGender;


    @NotBlank(message = "This field must be not blank")
    @NotNull(message = "This field must be not null")
    private String employeeEducation;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date employeeDateOfBirth;

    @NotBlank(message = "This field must be not blank")
    @NotNull(message = "This field must be not null")
    private String employeeNationality;

    @NotBlank(message = "This field must be not blank")
    @NotNull(message = "This field must be not null")
    private String employeeMaritalStatus; //célibataire,marié,...

    private int employeeNbKids;

    @NotBlank(message = "This field must be not blank")
    @NotNull(message = "This field must be not null")
    private String employeeDrivingLicence;

    @NotBlank(message = "This field must be not blank")
    @NotNull(message = "This field must be not null")
    private String employeeEmail;

    private String employeeCellPhone;

    @NotBlank(message = "This field must be not blank")
    @NotNull(message = "This field must be not null")
    private String employeeCity;

    @NotBlank(message = "This field must be not blank")
    @NotNull(message = "This field must be not null")
    private String employeeCountry;

    private String employeeEmergencyContractPerson;

    private String employeeContractInfo;

    private String employeeBloodType;

    @NotBlank(message = "This field must be not blank")
    @NotNull(message = "This field must be not null")
    private String employeeHealthProblem;

    private String active;

    @Column(name="createdAt", updatable = false)
    private Instant createdAt = new Date().toInstant();

    private String roleEmployee;

    @DocumentReference
    private SubDepartment subDepartment;

    private String isArchived;


    private String accountNum;

    private Date expirationDate;

    private String secretCode;

    private String user;
}
