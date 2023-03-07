package com.employees.main.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Document(collection="department_hr")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    private String id;
    @Indexed(unique = true)

    @NotBlank(message = "This field must be not blank")
    @NotNull(message = "This field must be not null")
    private String departmentReference;

    @NotBlank(message = "This field must be not blank")
    @NotNull(message = "This field must be not null")
    private String departmentName;

    @Column(name="createdAt", updatable = false)
    private Instant createdAt;

    @Column(name="updatedAt")
    private Instant updateAt;

    @DocumentReference
    private Employee employee;

    @DocumentReference
    private Level level;

    private String isArchived;

    private String user;

}
