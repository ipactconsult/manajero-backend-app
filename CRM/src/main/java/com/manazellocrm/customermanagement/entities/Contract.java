package com.manazellocrm.customermanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import java.time.Instant;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "contracts")
public class Contract  {
    @Id
    private String id;

    private String contractCode;

    private Date dateContract;

    private Date dateFin;

    private int duration;

    private String contractType;

    private String contractName;

    private String state;

    private String designation;

    private Object laws;

    private String archive;

    private String contractBody;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    @Column(name = "modified_at")
    private Instant modifiedAt;






}
