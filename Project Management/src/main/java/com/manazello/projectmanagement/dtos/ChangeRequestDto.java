package com.manazello.projectmanagement.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manazello.projectmanagement.entities.Employee;
import com.manazello.projectmanagement.entities.Project;
import com.manazello.projectmanagement.entities.enumeration.ChangeRequestCategory;
import com.manazello.projectmanagement.entities.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeRequestDto {
    private String id;
    private ChangeRequestCategory changeType;
    private String description;
    private Employee requestor;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date submittedDate=new Date();
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date approvedDate;
    private Status status=Status.IN_PROGRESS;
    private String comment;
    private boolean archived=false;
    private Project project;



}
