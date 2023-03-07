package com.employees.main.controllers;

import com.employees.main.business.dto.*;
import com.employees.main.business.ibusiness.IBusinessEmploye;
import com.employees.main.entities.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path= {"/employee"}, produces= APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class EmployeeController {

  private final IBusinessEmploye employeeIB;



    @PostMapping(value = "/create")
    public Employee createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){

        return employeeIB.createEmployee(employeeDTO) ;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Employee>> getAll()  {
        return new ResponseEntity<>(employeeIB.findAllEmps(), HttpStatus.OK);
    }


    @GetMapping(value = "/count_emps")
    public int count()  {
        return employeeIB.countEmps();
    }



    @GetMapping(value = "/all_pmp")
    public ResponseEntity<List<EmployeePMP>> getAllPmp()  {
        return new ResponseEntity<>(employeeIB.getAllEmpPmp(), HttpStatus.OK);
    }

    @GetMapping(value = "/all_emps")
    public ResponseEntity<List<EmployeeDTOData>> getAllEmpsLight()  {
        return new ResponseEntity<>(employeeIB.findCustomEmployees(), HttpStatus.OK);
    }

    @PostMapping(value = "/allById")
    public ResponseEntity<List<EmployeePMP>> getAllById(@RequestBody List<String>ids)  {
        return new ResponseEntity<>(employeeIB.findAllDataById(ids), HttpStatus.OK);
    }

    @GetMapping(value = "/employees_select")
    public ResponseEntity<List<EmployeeSelect>> getEmpsSelect()  {
        return new ResponseEntity<>(employeeIB.getEmployeesSelect(), HttpStatus.OK);
    }

    @GetMapping(value = "/profiles")
    public ResponseEntity<List<String>> getProfiles()  {
        return new ResponseEntity<>(employeeIB.getDistinctProfiles(), HttpStatus.OK);
    }

    @GetMapping( "/all_emps_pmp/{employeeProfile}")
    public ResponseEntity<List<EmployeePMP>> getEmpsPmp(@PathVariable("employeeProfile") String employeeProfile)  {
        return new ResponseEntity<>(employeeIB.findEmpsPMP(employeeProfile), HttpStatus.OK);
    }

    @GetMapping(value = "/all/descending")
    public ResponseEntity<List<Employee>> listEmployeesDesc(){
        return new ResponseEntity<>(employeeIB.findAllEmployeesDESC(), HttpStatus.OK);
    }


    @GetMapping( "/all/ascending")
    public ResponseEntity<List<Employee>> listEmployeesAsc(){
        return new ResponseEntity<>(employeeIB.findAllEmployeesAsc(), HttpStatus.OK);
    }

    @GetMapping(value = "/findbyid/{id}")
    public ResponseEntity<Employee> getDepartmentByid(@PathVariable("id") String id)
    {
        return employeeIB.findByid(id);
    }


    @PutMapping("/update/{id}")
    public Employee editEmployee (@PathVariable("id")String id, @RequestBody EmployeeDTO employeeDTO)
    {
           return employeeIB.updateEmployee(id,employeeDTO);
    }


    @GetMapping("/get/{id}")
    public Optional<EmployeePMP> getEmp (@PathVariable("id")String id){
        return employeeIB.getOne(id);
    }

    @DeleteMapping( "/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") String id)
    {
        return employeeIB.deleteEmployeeById(id);
    }

    @GetMapping(value = "/count")
    public ResponseEntity<Integer> countList(){
        return new ResponseEntity<>((int) employeeIB.countEmployees(), HttpStatus.OK);
    }

    @GetMapping(value = "/commercial")
    public ResponseEntity<List<EmployeeCRM>> getByRole(){
        return new ResponseEntity<>(employeeIB.getByRoleEmployee(), HttpStatus.OK);
    }

    @PutMapping( "/update-is-archived/{id}")
    public Employee editIsArchived(@RequestBody EmployeeDTO employeeDTO, @PathVariable("id") String id)
    {
        return employeeIB.editArchived(employeeDTO,id);
    }

    @PutMapping( "/update-is-restored/{id}")
    public Employee editIsRestored(@RequestBody EmployeeDTO employeeDTO, @PathVariable("id") String id)
    {
        return employeeIB.editRestored(employeeDTO,id);
    }

    @GetMapping(value = "/getbyemail/{employeeEmail}")
    public EmployeePMP getByEmailEmployee(@PathVariable("employeeEmail") String employeeEmail)
    {
        return employeeIB.getByEmail(employeeEmail);
    }


    @GetMapping(value = "/getbydate")
    public List<Employee> getByDate()
    {
        return employeeIB.getEmployeeByBirthDate();
    }






}
