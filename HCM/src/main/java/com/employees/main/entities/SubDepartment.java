package com.employees.main.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Document(collection="subdepartment_hr")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubDepartment {

    @Id
    private String id;
    @Indexed(unique = true)

    @NotBlank(message = "This field must be not null")
    private String subDepartmentName;

    @DocumentReference
    private Department department;

    private String user;


}
