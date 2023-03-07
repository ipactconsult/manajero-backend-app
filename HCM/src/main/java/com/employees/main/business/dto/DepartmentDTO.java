package com.employees.main.business.dto;


import com.employees.main.entities.Employee;
import com.employees.main.entities.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {


	private String id;

	private String departmentReference;

	private String departmentName;

	private Instant createdAt;
	
	private Instant updateAt;

	private Employee employee;

	private Level level;

	private String isArchived;

	private String user;
	
}
