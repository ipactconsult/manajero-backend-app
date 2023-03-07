package com.manazello.projectmanagement.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manazello.projectmanagement.entities.Employee;
import com.manazello.projectmanagement.entities.document.Stakholder;
import com.manazello.projectmanagement.entities.enumeration.Piority;
import com.manazello.projectmanagement.entities.enumeration.RequirementCategory;
import com.manazello.projectmanagement.entities.enumeration.Status;
import com.manazello.projectmanagement.entities.enumeration.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "requirements")
public class Requirement {
    @Id
    private String id;
    private Stakholder requestedby;
    private Piority priority;
    private String description;
    private RequirementCategory category;
    private String acceptedCriteria;
    @DocumentReference
    private Project project;
    private boolean archived;
}
