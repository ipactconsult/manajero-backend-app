package com.manazello.pm.entities.document;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectCharterDocument {
    private UUID id = UUID.randomUUID();
    private String name;
    private String description;
}
