package com.manazello.pm.entities.document;

import com.manazello.pm.entities.enumerations.AreCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Are {
    private UUID id = UUID.randomUUID();
    private String item;
    private AreCategory category;


}
