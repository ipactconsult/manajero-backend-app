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
public class Budget {
    private UUID id = UUID.randomUUID();
    private String area;
    private long amount;
}
