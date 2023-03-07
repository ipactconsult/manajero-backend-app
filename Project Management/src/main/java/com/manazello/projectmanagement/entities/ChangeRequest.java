package com.manazello.projectmanagement.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manazello.projectmanagement.entities.enumeration.ChangeRequestCategory;
import com.manazello.projectmanagement.entities.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ChangeRequests")
public class ChangeRequest {
    private String id;
    private ChangeRequestCategory changeType;
    private String description;

    private Employee requestor;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date submittedDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date approvedDate;
    private Status status;
    private String comment;
    private boolean archived;
    @DocumentReference
    private Project project;


}
