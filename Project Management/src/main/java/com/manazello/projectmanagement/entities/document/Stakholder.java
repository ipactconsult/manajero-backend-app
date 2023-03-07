package com.manazello.projectmanagement.entities.document;

import com.manazello.projectmanagement.entities.enumeration.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Stakholder {
    private UUID id = UUID.randomUUID();
    private String name;
    private String role;
    private String businessUnit;
    private Level engagementLevel;
    private String note;
}
