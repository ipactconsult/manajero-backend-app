package com.manazellocrm.customermanagement.business.dtos;

import com.manazellocrm.customermanagement.entities.Visit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.Instant;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DealsDTO {


    private String id;

    private String dealName;

    private int dealValue;

    private Date forecastDate;

    private int customerBudget;

    private int winChance;

    private String budgetStage;

    private double quoteValue;

    private Date quoteDate;

    private String quoteVsBudget;

    private String dealStatus;

    private String source;

    private String comment;

    private String dealType;

    private String negotiation;

    private Date dealDate;

    private String archive;

    private int leftDays;

    private Instant createdAt;


    private Instant modifiedAt;

    @DocumentReference
    private Visit visit;



}
