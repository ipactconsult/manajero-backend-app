package com.employees.main.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;

@Document(collection = "training_hr")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Training {

    @Id
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

    @DocumentReference
    private Employee employee;

    private String user;

}
