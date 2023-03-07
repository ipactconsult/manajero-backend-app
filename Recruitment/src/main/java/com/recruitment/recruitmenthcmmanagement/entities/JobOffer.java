package com.recruitment.recruitmenthcmmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;

@Document(collection = "jobOffer_hr")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobOffer {

    @Id
    private String id;

    private Date hiringDate;

    private String hiringSource;

    private String jobTitle;

    private String jobOffice;

    private String jobStatus;

    private String place;

    private long nb_people_hired;

    private long nb_people_positions;

    private String jobDescription;

    private String profile_needed;

    @DocumentReference
    private Object user;

    @DocumentReference
    private JobsCategory jobsCategory;

    private String isArchived;
}
