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
public class LeaveRequestDTO {

    private String id;

    private String requestStatus;

    private String motif;

    private long availableQuantity;

    private long remainderQuantity;

    private Date startDate;

    private String start;

    private Date endDate;

    private String end;

    private long duration;

    private Employee employee;

    private String comments;

    private Employee validatedBy;

    private Employee rejectedBy;

    private String isArchived;

    private String user;
}
