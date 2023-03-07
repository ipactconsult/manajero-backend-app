package com.employees.main.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Id;

@Document(collection = "soft_skills_hr")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SoftSkills {

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
