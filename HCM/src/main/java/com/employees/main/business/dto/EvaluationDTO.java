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
public class EvaluationDTO {

    private String id;

    private Employee employee;

    private String evaluationType;

    private String user;

    private Date limitDate;

    private String attachmentEvaluation;

    private String status;

    private String isArchived;
}
