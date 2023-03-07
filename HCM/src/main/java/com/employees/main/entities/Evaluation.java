package com.employees.main.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Id;
import java.util.Date;

@Document(collection = "evaluation_hr")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evaluation {

    @Id
    private String id;

    @DocumentReference
    private Employee employee;

    private String evaluationType;

    private String user;

    private Date limitDate;

    private String attachmentEvaluation;

    private String status;

    private String isArchived;
}
