package com.manazellocrm.customermanagement.business.dtos;


import com.manazellocrm.customermanagement.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitDTO {

    private String id;

    private Date dateVisit;

    private String hourVisit;

    private String refVisit;

    private String description;

    private String availability;

    private String status;

    private String title;

    private Instant createdAt;

    private Instant modifiedAt;

    private String archive;

    @DocumentReference
    private Customer customer;


    private Object employee;

    private Object property;
}
