package com.manazellocrm.customermanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Column;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "claims")
public class Claims {
    @Id
    private String id;

    private String claimCode;

    private String claimMotif;

    private String otherInfos;

    private String responseClaim;

    private String evaluationClaim;

    private String claimTitle;

    private Date claimDate;

    private Date closingDate;

    private String claimType;

    private String urgencyType;

    private String descriptionClaim;

    private String status;

    private Boolean archive;

    private String user;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    @Column(name = "modified_at")
    private Instant modifiedAt;

    @DocumentReference
    private Customer customer;

    private Object employee;

}
