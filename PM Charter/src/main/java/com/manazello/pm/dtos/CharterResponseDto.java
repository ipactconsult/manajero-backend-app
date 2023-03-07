package com.manazello.pm.dtos;

import com.manazello.pm.entities.enumerations.StatusRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharterResponseDto {
    private String id;
    private String title;
    private String statementWork;
    private StatusRequest status;
    private Date dateSubmited;
}
