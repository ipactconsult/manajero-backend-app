package com.employees.main.controllers;

import com.employees.main.business.dto.SubDepartmentDTO;
import com.employees.main.business.ibusiness.IBusinessSubDepartment;
import com.employees.main.entities.SubDepartment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "/subDepartment", produces = APPLICATION_JSON_VALUE)
public class SubDepartmentController {

    IBusinessSubDepartment subDepartmentIB;

    public SubDepartmentController(IBusinessSubDepartment subDepartmentIB){
        this.subDepartmentIB = subDepartmentIB;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<SubDepartment>createSub(@Valid @RequestBody SubDepartmentDTO subDepartmentDTO){
        return subDepartmentIB.createSubDepartment(subDepartmentDTO);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<SubDepartment>> getAll(){
        return new ResponseEntity<>(subDepartmentIB.findAllSubDepartments(), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public SubDepartment editSub(@PathVariable("id") String id, @RequestBody SubDepartmentDTO subDepartmentDTO)
    {
        return subDepartmentIB.editSubDepartment(id,subDepartmentDTO);
    }

    @DeleteMapping( "/delete/{id}")
    public ResponseEntity<String> deleteSubById(@PathVariable("id") String id)
    {
        return subDepartmentIB.deleteSub(id);
    }
    @GetMapping( "/getSubDepartmentById/{id}")
    public ResponseEntity<SubDepartment> getSub(@PathVariable("id") String id)
    {
        return new ResponseEntity(subDepartmentIB.findById(id), HttpStatus.OK);
    }
}
