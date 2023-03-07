package com.employees.main.business.dto;

import com.employees.main.entities.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubDepartmentDTO {

    private String id;

    private String subDepartmentName;

    private Department department;

    private String user;

}
