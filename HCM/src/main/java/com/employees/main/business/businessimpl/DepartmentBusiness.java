package com.employees.main.business.businessimpl;

import java.time.Instant;
import java.util.*;

import com.employees.main.business.ibusiness.IDepartmentBusiness;
import com.employees.main.entities.Department;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employees.main.business.dto.DepartmentDTO;
import com.employees.main.repositories.DepartmentRepository;

import javax.transaction.Transactional;

@Service
public class DepartmentBusiness implements IDepartmentBusiness {


	final
	DepartmentRepository departmentRepo;

	final ModelMapper mapper;

	public DepartmentBusiness(DepartmentRepository departmentRepo, ModelMapper mapper) {
		this.departmentRepo = departmentRepo;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<Department> createDepartment(DepartmentDTO departmentdto) {

		Department d = this.mapper.map(departmentdto, Department.class);
		Date date = new Date();
		Instant instanceDateNow = date.toInstant();
		d.setDepartmentReference(departmentdto.getDepartmentReference());
		d.setDepartmentName(departmentdto.getDepartmentName());
		d.setEmployee(departmentdto.getEmployee());
		d.setLevel(departmentdto.getLevel());
		d.setIsArchived("No");
		d.setCreatedAt(instanceDateNow);
		d.setUser(departmentdto.getUser());
		departmentRepo.save(d);
		return ResponseEntity.status(HttpStatus.CREATED).body(d);
	}


	@Override
	public List<Department> findAllDepartments() {
		return departmentRepo.findAll(Sort.by("departmentReference"));
	}

	@Override
	public List<Department> historyDepts() {
		return departmentRepo.findDepartmentsByIsArchived("No");
	}

	@Override
	@Transactional
	public Department updateDepartment(String id, DepartmentDTO departmentDTO) {
		Department d = this.mapper.map(departmentDTO, Department.class);
		Date date = new Date();
		Instant toupdate = date.toInstant();
		Optional<Department> editObject = departmentRepo.findById(id);
		d.setUpdateAt(toupdate);
		return (editObject.isPresent() ? departmentRepo.save(d) : null);
	}
	@Override
	public ResponseEntity<String> deleteDepartmentByReference(String id) {
		departmentRepo.deleteById(id);
		return new ResponseEntity<>("Operation Deleted Successfuly", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Department> findByDepartment(DepartmentDTO departmentDTO) {
		Optional<Department> findbyobj = departmentRepo.findById(departmentDTO.getId());
		return (
				findbyobj.isPresent() ?
						new ResponseEntity<>(findbyobj.get(),HttpStatus.OK) :
						new ResponseEntity<>(HttpStatus.NOT_FOUND)
				);
	}

	@Override
	public ResponseEntity<Department> findByid(String id) {
		Optional<Department> findbyref = departmentRepo.findById(id);
		return (
				findbyref.isPresent() ?
						new ResponseEntity<>(findbyref.get(), HttpStatus.OK)
						: new ResponseEntity<>(HttpStatus.NOT_FOUND)
				);
	}

	@Override
	public long countDepartments() {
		return departmentRepo.count();
	}

	@Override
	public List getDepartmentByDepartmentName(String departmentName) {
		return departmentRepo.findDepartmentByDepartmentName(departmentName);
	}

	@Override
	public Department listDepartment(String employeeName) {
		return departmentRepo.findDepartmentByEmployeeName(employeeName);
	}

	@Override
	public Department updateDepartmentByIsArchived(DepartmentDTO departmentDTO,String id) {
		Department d = this.mapper.map(departmentDTO, Department.class);
		Date date = new Date();
		Instant toupdate = date.toInstant();
		Optional<Department> editObject = departmentRepo.findById(id);
		d.setIsArchived("Yes");
		d.setUpdateAt(toupdate);
		return (editObject.isPresent() ? departmentRepo.save(d) : null);
	}

	@Override
	public Department updateDepartmentByIsRestored(DepartmentDTO departmentDTO, String id) {
		Department d = this.mapper.map(departmentDTO, Department.class);
		Date date = new Date();
		Instant toupdate = date.toInstant();
		Optional<Department> editObject = departmentRepo.findById(id);
		d.setIsArchived("No");
		d.setUpdateAt(toupdate);
		return (editObject.isPresent() ? departmentRepo.save(d) : null);
	}


}
