package com.employees.main.business.dto;

import com.employees.main.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDTO {


    private String id;

    private String expenseName;

    private Object project;

    private String expenseType;

    private Date expenseDate;

    private Double totalTTCAmount;

    private String toBeInvoiced;

    private String status;

    private String comments;

    private Double tvaAmount;

    private Double htAmount;

    private long distanceDriven;

    private String startingCity;

    private String endingCity;

    private String fiscalPower;

    private Employee employee;
}
