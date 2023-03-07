package com.employees.main.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Document(collection = "skills_hr")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skills {

    @Id
    private String id;

    private String skillName;

    private long experience;

    private long score;

    private String isArchived;

    @DocumentReference
    private Employee employee;

    private String user;
}
