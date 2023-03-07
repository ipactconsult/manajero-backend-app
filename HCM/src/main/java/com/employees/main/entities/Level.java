package com.employees.main.entities;


import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "level_hr")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Level {

    @Id
    private String id;

    @Indexed(unique = true)
    private long levelReference;

}

