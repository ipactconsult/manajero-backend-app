package com.recruitment.recruitmenthcmmanagement.business.dto;

import com.recruitment.recruitmenthcmmanagement.entities.JobOffer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDTO {

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
