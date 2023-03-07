package com.manazello.projectmanagement.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manazello.projectmanagement.entities.Employee;
import com.manazello.projectmanagement.entities.document.Stakholder;
import com.manazello.projectmanagement.entities.enumeration.Status;
import com.manazello.projectmanagement.entities.enumeration.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    @Id
    private String id;
    private String title;
    private Employee projectManager;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    private Status status;
    private String description;
    private String organization;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date closingDate;
    private Type type;
        private List<Stakholder> stakholders;
    private boolean archived=false;

}
