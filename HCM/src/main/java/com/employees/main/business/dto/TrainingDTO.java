package com.employees.main.business.dto;

import com.employees.main.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainingDTO {

    private String id;

    private String object;

    private String category;

    private long nbHours;

    private Date startDate;

    private Date endDate;

    private String description;

    private String program;

    private String status;

    private long score;

    private float budget;

    private float cost;

    private String isArchived;

    private Employee employee;

    private String user;
}
