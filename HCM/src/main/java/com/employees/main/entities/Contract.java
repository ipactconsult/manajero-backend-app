package com.employees.main.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Id;
import java.util.Date;

@Document(collection="contract_hr")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contract {

    @Id
    private String id;

    private String contractType;

    private Date hiringDate;
    
    private Date endDate;

    private long noticePeriod;

    private String status;

    private Date officialSignature;

    private long durationOfTrialPeriod; //if in trial status

    private String startTime;

    private int duration;




    private long nbOfHoursWorkedPerDay;

    private long nbOfWeeklyWorkingHours;

    private long hourlyWorkRate;

    private float dailyCost;

    private String hourlyDistribution;




    private String companyName;

    private String companyAddress;

    private String workAddress;

    private String job;





    private long bonusCoef;

    private float grossHourlyWage;

    private float minimumMonthlySalary;

    private float grossAnnualSalary;

    private float overallMonthlyCost;

    @DocumentReference
    private Employee employee;

    private String isArchived;

    private String user;

}
