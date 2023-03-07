package com.manazello.pm.entities.document;

import com.manazello.pm.entities.Charter;
import com.manazello.pm.entities.enumerations.Level;
import com.manazello.pm.entities.enumerations.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Risk {
    private UUID id = UUID.randomUUID();
    private String title;
    private String  description;
    private Type category;
    private Level probability;
    private int severity;
    private String riskResponseStrategic;
    private List<String> triggers;
    private double cost;
    private String action;
    private Level impactLevel;

}
