package com.manazello.pm.entities.document;

import com.manazello.pm.entities.Charter;
import com.manazello.pm.entities.document.Contact;
import com.manazello.pm.entities.enumerations.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Stakeholder {
    private UUID id = UUID.randomUUID();
    private String name;
    private String role ;
    private String businessUnit;
    private String notes;
    private String delights;
    private Level engagementLevel;
    private Contact contact;
}
