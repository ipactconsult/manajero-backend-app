package com.recruitment.recruitmenthcmmanagement.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "application_hr")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Application {

    @Id
    private String id;

    private String quality;

    private String cin;

    private String firstName;

    private String lastName;

    private String date;

    private String gender;

    private String city;

    private String email;

    private String phoneNumber;

    private String diploma;

    private String university;

    private String domain;

    private String obtainedDate;

    private String seniority;

    private String curriculumVitae;

    private String status;

}
