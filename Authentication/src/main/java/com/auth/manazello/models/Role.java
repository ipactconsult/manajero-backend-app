package com.auth.manazello.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "roles")
public class Role {
    @Id
    private String id;
    private String name;
    
        public Role(String name) {
        this.name = name;
    }
}