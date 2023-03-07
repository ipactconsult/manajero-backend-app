package com.manazello.projectmanagement.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manazello.projectmanagement.entities.document.Stakholder;
import com.manazello.projectmanagement.entities.enumeration.Status;
import com.manazello.projectmanagement.entities.enumeration.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "projects")
public class Project {
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
        private Boolean archived;
        private List<Stakholder> stakholders;
}
