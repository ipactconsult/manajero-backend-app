package com.recruitment.recruitmenthcmmanagement.business.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobOfferDTO {

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

    private Object employee;

    private String isArchived;
}
