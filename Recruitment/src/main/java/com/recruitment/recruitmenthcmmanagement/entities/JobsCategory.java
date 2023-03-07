package com.recruitment.recruitmenthcmmanagement.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "job_category_hr")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobsCategory {

    @Id
    private String id;

    private String categoryName;

}
