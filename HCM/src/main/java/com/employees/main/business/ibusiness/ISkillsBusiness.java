package com.employees.main.business.ibusiness;

import com.employees.main.business.dto.SkillsDTO;
import com.employees.main.entities.Skills;

import java.util.List;
import java.util.Optional;

public interface ISkillsBusiness {

    Skills addSkills(SkillsDTO skillsDTO);
    List<Skills> findAllSkills();
    Skills editSkills(SkillsDTO skillsDTO, String id);
    Optional<Skills> showSkills(String id);
    Skills archiveSkills(SkillsDTO skillsDTO, String id);
    Skills restoreSkills(SkillsDTO skillsDTO, String id);
    void deleteSkills(String id);

    List<Skills> getAllByEmployee(String id);

}
