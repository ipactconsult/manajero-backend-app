package com.manazellocrm.customermanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "deals")
public class Deals {

    @Id
    public String id;
    @Indexed(unique  = true)

    @NotBlank
    private String dealName;

    private int dealValue;

    @NotBlank
    private Date forecastDate;

    @NotBlank
    private int customerBudget;

    private int winChance;

    @NotBlank
    private String budgetStage;

    private double quoteValue;

    private Date quoteDate;

    private String quoteVsBudget;

    @NotBlank
    private String dealStatus;

    private String source;

    private String comment;

    private String dealType;

    private String negotiation;

    private Date dealDate;

    private String archive;

    private int leftDays;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    @Column(name = "modified_at")
    private Instant modifiedAt;

    @DocumentReference
    private Visit visit;



}
