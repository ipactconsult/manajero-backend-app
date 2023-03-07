package com.employees.main.controllers;

import com.employees.main.business.dto.SkillsDTO;
import com.employees.main.business.ibusiness.ISkillsBusiness;
import com.employees.main.entities.Skills;
import com.employees.main.entities.SoftSkills;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/skills")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class SkillsController {

    private final ISkillsBusiness iSkillsBusiness;

    public SkillsController(ISkillsBusiness iSkillsBusiness) {
        this.iSkillsBusiness = iSkillsBusiness;
    }

    @PostMapping("/create")
    public Skills addS(@RequestBody SkillsDTO skillsDTO)
    {
        return  iSkillsBusiness.addSkills(skillsDTO);
    }

    @GetMapping("/all")
    public List<Skills> findAllT()
    {
        return  iSkillsBusiness.findAllSkills();
    }

    @PutMapping("/edit/{id}")
    public Skills editS(@RequestBody SkillsDTO skillsDTO,@PathVariable("id") String id)
    {
        return  iSkillsBusiness.editSkills(skillsDTO,id);
    }

    @PutMapping("/archive/{io}")
    public Skills archiveS(@RequestBody SkillsDTO skillsDTO,@PathVariable("id") String id)
    {
        return  iSkillsBusiness.archiveSkills(skillsDTO,id);
    }

    @PutMapping("/restore/{io}")
    public Skills restoreS(@RequestBody SkillsDTO skillsDTO,@PathVariable("id") String id)
    {
        return  iSkillsBusiness.restoreSkills(skillsDTO,id);
    }

    @GetMapping("/show/{id}")
    public Optional<Skills> showT(@PathVariable("id")String id)
    {
        return iSkillsBusiness.showSkills(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteT(@PathVariable("id") String id)
    {
        iSkillsBusiness.deleteSkills(id);
    }


    @GetMapping("/getbyemployee/{id}")
    public List<Skills> showByEmployee(@PathVariable("id")String id)
    {
        return iSkillsBusiness.getAllByEmployee(id);
    }

}
