package com.employees.main.controllers;

import com.employees.main.business.dto.SoftSkillsDTO;
import com.employees.main.business.ibusiness.IBusinessSoftSkills;
import com.employees.main.entities.Employee;
import com.employees.main.entities.SoftSkills;
import com.employees.main.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/soft_skills")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class SoftSkillsController {

    private final IBusinessSoftSkills iBusinessSoftSkills;

    private final EmployeeRepository employeeRepository;

    public SoftSkillsController(IBusinessSoftSkills iBusinessSoftSkills, EmployeeRepository employeeRepository) {
        this.iBusinessSoftSkills = iBusinessSoftSkills;
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/create")
    public SoftSkills addS(@RequestBody SoftSkillsDTO skillsDTO)
    {
        return  iBusinessSoftSkills.addSoft(skillsDTO);
    }

    @GetMapping("/all")
    public List<SoftSkills> findAllT()
    {
        return  iBusinessSoftSkills.findAllSofts();
    }

    @PutMapping("/edit/{id}")
    public SoftSkills editS(@RequestBody SoftSkillsDTO skillsDTO,@PathVariable("id") String id)
    {
        return  iBusinessSoftSkills.editSoft(skillsDTO,id);
    }

    @PutMapping("/archive/{io}")
    public SoftSkills archiveS(@RequestBody SoftSkillsDTO skillsDTO,@PathVariable("id") String id)
    {
        return  iBusinessSoftSkills.archiveSoft(skillsDTO,id);
    }

    @PutMapping("/restore/{io}")
    public SoftSkills restoreS(@RequestBody SoftSkillsDTO skillsDTO,@PathVariable("id") String id)
    {
        return  iBusinessSoftSkills.restoreSoft(skillsDTO,id);
    }

    @GetMapping("/show/{id}")
    public Optional<SoftSkills> showT(@PathVariable("id")String id)
    {
        return iBusinessSoftSkills.showSoft(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteT(@PathVariable("id") String id)
    {
        iBusinessSoftSkills.deleteSoft(id);
    }

    @GetMapping("/getbyemployee/{id}")
    public List<SoftSkills> showByEmployee(@PathVariable("id")String idEmployee)
    {
        return iBusinessSoftSkills.getAllByEmployee(idEmployee);
    }

}
