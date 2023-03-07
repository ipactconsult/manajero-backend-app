package com.employees.main.business.ibusiness;

import com.employees.main.business.dto.SkillsDTO;
import com.employees.main.business.dto.SoftSkillsDTO;
import com.employees.main.entities.SoftSkills;

import java.util.List;
import java.util.Optional;

public interface IBusinessSoftSkills {

    SoftSkills addSoft(SoftSkillsDTO skillsDTO);
    List<SoftSkills> findAllSofts();
    SoftSkills editSoft(SoftSkillsDTO softSkillsDTO, String id);
    Optional<SoftSkills> showSoft(String id);
    SoftSkills archiveSoft(SoftSkillsDTO softSkillsDTO, String id);
    SoftSkills restoreSoft(SoftSkillsDTO softSkillsDTO, String id);
    void deleteSoft(String id);

    List<SoftSkills> getAllByEmployee(String id);

}
