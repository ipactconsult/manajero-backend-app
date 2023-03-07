package com.manazellocrm.customermanagement.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "visits")
public class Visit {

    @Id
    @Indexed(unique  = true)
    public String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotBlank(message = "This field must be not blank")
    @NotNull(message = "This field must be not null")
    private Date dateVisit;

    @NotBlank(message = "This field must be not blank")
    @NotNull(message = "This field must be not null")
    private String hourVisit;

    private String refVisit;

    private String description;

    private String availability;

    private String status;

    private String title;

    private String archive;

    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    @Column(name = "modified_at")
    private Instant modifiedAt;

    @DocumentReference
    private Customer customer;

    private Object property;

}
