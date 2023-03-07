package com.employees.main.business.dto;

import com.employees.main.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReleaseDTO {

    private String id;

    private String motifRelease;

    private String startTime;

    private String endTime;

    private String releaseStatus;

    private String commentsRelease;

    private Employee employee;

    private Employee rejectedReleaseBy;

    private Employee validatedReleaseBy;

    private Instant createdAt;

    private Instant updateAt;

    private String isArchive;

    private String user;

}
