package com.manazello.projectmanagement.dtos;

import com.manazello.projectmanagement.entities.Project;
import com.manazello.projectmanagement.entities.document.Stakholder;
import com.manazello.projectmanagement.entities.enumeration.Piority;
import com.manazello.projectmanagement.entities.enumeration.RequirementCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequirementDto {

    private String id;
    private Stakholder requestedby;
    private Piority priority;
    private String description;
    private RequirementCategory category;
    private String acceptedCriteria;
    private boolean archived;
    private Project project;

}
