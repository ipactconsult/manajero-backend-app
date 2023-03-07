package com.employees.main.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expenses {
    @Id
    private String id;

    private Object project;
    private String expenseName;
    private String expenseType;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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

    private Boolean archive;

    @Column(name="createdAt", updatable = false)
    private Instant createdAt;

    @Column(name="updatedAt")
    private Instant updateAt;

    @DocumentReference
    private Employee employee;
}
