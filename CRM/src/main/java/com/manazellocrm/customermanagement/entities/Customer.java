package com.manazellocrm.customermanagement.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customers")
public class Customer {

    @Id
    @Indexed(unique = true)
    private String id;


    @Indexed(unique = true)
    private String matriculateFiscal;


    @NotBlank
    private String name;

    @NotBlank
    @Size(max = 50)
    @Email
    private String workEmail;

    private String secondEmail;

    private String title;

    private String image;

    @Pattern(message = "phone number must be a number ", regexp = "^[0-9]*$")
    private String phone;

    private String secondPhone;

    @NotBlank
    private String workWebsite;

    private String description;

    private String address;

    private String city;

    private String gender;

    private String otherGender;

    private Date dateOfBirth;

    private String contactType;

    private String postalCode;

    private String archive;

    private Object assignee;

    private String country;

    private String linkedinUrl;

    private boolean active;

    private String status;

    private String user;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;


    @Column(name = "modified_at")
    private Instant modifiedAt;


}
