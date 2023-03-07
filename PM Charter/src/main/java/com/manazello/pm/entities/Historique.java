package com.manazello.pm.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Historique {
    @Id
    private String id;
    private String actionType;
    private Date date;
    private String newData;
    private String oldData;
}
