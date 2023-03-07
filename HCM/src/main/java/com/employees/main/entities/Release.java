package com.employees.main.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Id;
import java.time.Instant;

@Document(collection = "release_hr")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Release {

    @Id
    private String id;

    private String motifRelease;

    private String startTime;

    private String endTime;

    private String releaseStatus;

    private String commentsRelease;

    @DocumentReference
    private Employee employee;

    @DocumentReference
    private Employee rejectedReleaseBy;

    @DocumentReference
    private Employee validatedReleaseBy;

    private Instant createdAt;

    private Instant updateAt;

    private String isArchive;

    private String user;

}
