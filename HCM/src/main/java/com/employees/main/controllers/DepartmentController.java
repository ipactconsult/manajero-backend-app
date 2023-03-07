package com.employees.main.controllers;

import com.employees.main.business.ibusiness.IDepartmentBusiness;
import com.employees.main.entities.Department;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.employees.main.business.dto.DepartmentDTO;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
@RequestMapping(path= {"/department"}, produces= APPLICATION_JSON_VALUE)
public class DepartmentController  {

	final
	IDepartmentBusiness departmentIB;

	public DepartmentController(IDepartmentBusiness departmentIB) {
		this.departmentIB = departmentIB;
	}

	@PostMapping(value = "/create",consumes = "application/json")
	public ResponseEntity<Department> createDepartment(@RequestBody DepartmentDTO department){
			return departmentIB.createDepartment(department);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<Department>> findAllDepartment(){
		return new ResponseEntity<>(departmentIB.findAllDepartments(), HttpStatus.OK);
	}

	@GetMapping(value = "/history")
	public ResponseEntity<List<Department>> history(){
		return new ResponseEntity<>(departmentIB.historyDepts(), HttpStatus.OK);
	}

	@PutMapping( "/update/{id}")
	public Department editDepartment(@PathVariable("id") String id, @RequestBody DepartmentDTO departmentDTO)
	{
		return departmentIB.updateDepartment(id,departmentDTO);
	}
	@DeleteMapping( "/delete/{id}")
	public ResponseEntity<String> deleteDepartmentByRef(@PathVariable("id") String id)
	{
		return departmentIB.deleteDepartmentByReference(id);
	}

	@GetMapping(value = "/findOne")
	public ResponseEntity<Department> getDepartment(@RequestBody DepartmentDTO departmentDTO)
	{
		return departmentIB.findByDepartment(departmentDTO);
	}

	@GetMapping(value = "/findbyid/{id}")
	public ResponseEntity<Department> getDepartmentByid(@PathVariable("id") String id)
	{
		return departmentIB.findByid(id);
	}

	@GetMapping(value = "/count")
	public ResponseEntity<Number>getCount(){
		return new ResponseEntity<>(departmentIB.countDepartments(), HttpStatus.OK);
	}

	@GetMapping(value = "/get/{departmentName}")
	public ResponseEntity<List<Department>>getDepartmentByName(@PathVariable ("departmentName") String departmentName){
		return new ResponseEntity<>(departmentIB.getDepartmentByDepartmentName(departmentName), HttpStatus.OK);
	}

	@GetMapping(value = "/{employeeName}/emp")
	public ResponseEntity<Department> findDepartmentByEmployeeName(@PathVariable ("employeeName") String employeeName){
		return new ResponseEntity<>(departmentIB.listDepartment(employeeName), HttpStatus.OK);
	}

	@PutMapping( "/update-is-archived/{id}")
	public Department editIsArchived(@RequestBody DepartmentDTO departmentDTO, @PathVariable("id") String id)
	{
		return departmentIB.updateDepartmentByIsArchived(departmentDTO,id);
	}

	@PutMapping( "/update-is-restored/{id}")
	public Department editIsRestored(@RequestBody DepartmentDTO departmentDTO, @PathVariable("id") String id)
	{
		return departmentIB.updateDepartmentByIsRestored(departmentDTO,id);
	}




}
