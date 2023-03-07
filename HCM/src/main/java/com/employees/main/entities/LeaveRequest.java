package com.employees.main.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Id;
import java.util.Date;

@Document(collection="leave_request_hr")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequest {

    @Id
    private String id;

    private String requestStatus;

    private String motif;

    private long availableQuantity;

    private Date startDate;

    private String start;

    private Date endDate;

    private String end;

    private long duration; //qte demandée


    private long remainderQuantity;


    @DocumentReference
    private Employee employee;

    private String comments;

    @DocumentReference
    private Employee validatedBy;

    @DocumentReference
    private Employee rejectedBy;

    private String isArchived;

    private String user;
}
