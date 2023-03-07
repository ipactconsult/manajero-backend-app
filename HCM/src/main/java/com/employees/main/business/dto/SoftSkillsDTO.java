package com.employees.main.business.dto;

import com.employees.main.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SoftSkillsDTO {

    private String id;

    private String skillName;

    private long experience;

    private long score;

    private Employee employee;

    private String user;
}
