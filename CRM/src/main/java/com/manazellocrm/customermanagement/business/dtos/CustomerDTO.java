package com.manazellocrm.customermanagement.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private String id;

    private String matriculateFiscal;

    private String name;

    private String workEmail;

    private String secondEmail;

    private String title;

    private String image;

    private String phone;

    private String secondPhone;

    private String gender;
    private String contactType;
    private String otherGender;
    private String postalCode;

    private Date dateOfBirth;

    private String archive;

    private String workWebsite;

    private String description;

    private String address;

    private String city;

    private Object assignee;

    private String country;

    private String linkedinUrl;

    private boolean active;

    private String status;


    private String user;

    private Instant createdAt;


    private Instant modifiedAt;

}
