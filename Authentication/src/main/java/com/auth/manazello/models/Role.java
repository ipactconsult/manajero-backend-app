package com.auth.manazello.models;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "roles")
public class Role {
    @Id
    private String id;
    @Indexed(unique = true)
    private RolesEnum name;

}