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
@AllArgsConstructor
@NoArgsConstructor
public class ClaimsDTO {

    private String id;

    private String claimCode;

    private String claimTitle;

    private String claimMotif;

    private String otherInfos;

    private String responseClaim;

    private String evaluationClaim;

    private Date claimDate;

    private Date closingDate;

    private String claimType;

    private String urgencyType;

    private String descriptionClaim;

    private String status;

    private String user;

    private String archive;

    private Instant createdAt;

    private Instant modifiedAt;

    @DocumentReference
    private Customer customer;

    private Object employee;

}
