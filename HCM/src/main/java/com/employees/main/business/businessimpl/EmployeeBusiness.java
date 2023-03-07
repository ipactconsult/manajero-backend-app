package com.employees.main.business.businessimpl;

import com.employees.main.business.dto.*;
import com.employees.main.business.ibusiness.IBusinessEmploye;
import com.employees.main.entities.Employee;
import com.employees.main.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeBusiness implements IBusinessEmploye {

    private final
    EmployeeRepository employeeRepo;

    final ModelMapper mapper;


    public EmployeeBusiness(EmployeeRepository employeeRepo, ModelMapper mapper) {
        this.employeeRepo = employeeRepo;
        this.mapper = mapper;
    }


    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
            Employee employee = new Employee(
                    employeeDTO.getId(),
                    employeeDTO.getEmployeeReference(),
                    employeeDTO.getEmployeeName(),
                    employeeDTO.getEmployeeProfileImage(),
                    employeeDTO.getEmployeeProfile(),
                    employeeDTO.getEmployeePasseport(),
                    employeeDTO.getEmployeeSocialSecurity(),
                    employeeDTO.getEmployeeGender(),
                    employeeDTO.getEmployeeEducation(),
                    employeeDTO.getEmployeeDateOfBirth(),
                    employeeDTO.getEmployeeNationality(),
                    employeeDTO.getEmployeeMaritalStatus(),
                    employeeDTO.getEmployeeNbKids(),
                    employeeDTO.getEmployeeDrivingLicence(),
                    employeeDTO.getEmployeeEmail(),
                    employeeDTO.getEmployeeCellPhone(),
                    employeeDTO.getEmployeeCity(),
                    employeeDTO.getEmployeeCountry(),
                    employeeDTO.getEmployeeEmergencyContractPerson(),
                    employeeDTO.getEmployeeContractInfo(),
                    employeeDTO.getEmployeeBloodType(),
                    employeeDTO.getEmployeeHealthProblem(),
                    employeeDTO.getActive(),
                    employeeDTO.getCreatedAt(),
                    employeeDTO.getRoleEmployee(),
                    employeeDTO.getSubDepartment(),
                  "No",
                    employeeDTO.getAccountNum(),
                    employeeDTO.getExpirationDate(),
                    employeeDTO.getSecretCode(),
                    employeeDTO.getUser()
            );
            return employeeRepo.save(employee);

    }

    @Override
    public List<Employee> findAllEmps()  {
        return employeeRepo.findEmployeesByIsArchived("No");
    }

    @Override
    public int countEmps() {
        return (int) employeeRepo.count();
    }

    public List<EmployeePMP> findAllDataById(List<String> ids)  {
        List<EmployeePMP> results = new ArrayList<>();
        for (String id : ids){
             employeeRepo.getById(id).ifPresent(results::add);
        }
        return results;
    }

    @Override
    public List<String> getDistinctProfiles() {
        return  employeeRepo.findDistinctEmployeeProfiles();
    }

    @Override
    public List<EmployeeSelect> getEmployeesSelect() {
        return employeeRepo.getEmployeesByIsArchived("No");
    }

    @Override
    public List<EmployeePMP> findEmpsPMP(String employeeProfile) {
        return employeeRepo.findEmployeesByIsArchivedAndEmployeeProfile("No",employeeProfile);
    }

    @Override
    public List<Employee> findAllEmployeesAsc() {
        return employeeRepo.findAll(Sort.by("employeeName").ascending());
    }

    @Override
    public List<EmployeeDTOData> findCustomEmployees() {
        return employeeRepo.customQueryEmployeesLight();
    }

    @Override
    public EmployeePMP getByEmail(String employeeEmail) {
        return employeeRepo.findEmployeesByEmployeeEmail(employeeEmail);
    }

    @Override
    public List<Employee> getEmployeeByBirthDate() {
        Date d = new Date();

        return employeeRepo.findByCustomQuery(d.getDay()+3, d.getMonth()+1);
    }

    @Override
    public Optional<EmployeePMP> getOne(String id) {
        return employeeRepo.getById(id);
    }

    @Override
    public List<EmployeePMP> getAllEmpPmp() {
        return employeeRepo.findAllByIsArchived("No");
    }

    @Override
    public List<Employee> findAllEmployeesDESC() {
        return employeeRepo.findAll(Sort.by("employeeName").descending());
    }


    @Override
    public ResponseEntity<String> deleteEmployeeById(String id) {
        employeeRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public long countEmployees() {
        return employeeRepo.count();
    }

    @Override
    public ResponseEntity<Employee> findByid(String id) {
         Optional< Employee > findbyref = employeeRepo.findById(id);
        return (
                findbyref.isPresent() ?
                        new ResponseEntity<>(findbyref.get(), HttpStatus.OK)
                        : new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public Employee updateEmployee(String id, EmployeeDTO employeeDTO) {
        Employee employee = this.mapper.map(employeeDTO, Employee.class);
        Optional<Employee> editEmployee = employeeRepo.findById(id);
        employee.setIsArchived("No");
        return (
                editEmployee.isPresent() ? employeeRepo.save(employee) : null
                );
    }

    @Override
    public List<EmployeeCRM> getByRoleEmployee() {
        return employeeRepo.getEmployeeCRMByRoleEmployeeAndIsArchived("Commercial","No");
    }

    @Override
    public Employee editArchived(EmployeeDTO employeeDTO, String id) {
        Employee employee = this.mapper.map(employeeDTO, Employee.class);
        Optional<Employee> editObject = employeeRepo.findById(id);
        employee.setIsArchived("Yes");
        return (editObject.isPresent() ? employeeRepo.save(employee) : null);
    }

    @Override
    public Employee editRestored(EmployeeDTO employeeDTO, String id) {
        Employee employee = this.mapper.map(employeeDTO, Employee.class);
        Optional<Employee> editObject = employeeRepo.findById(id);
        employee.setIsArchived("No");
        return (editObject.isPresent() ? employeeRepo.save(employee) : null);
    }


}
