package com.employees.main.business.businessimpl;

import com.employees.main.business.dto.SkillsDTO;
import com.employees.main.business.ibusiness.ISkillsBusiness;
import com.employees.main.entities.Skills;
import com.employees.main.repositories.SkillsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SkillsBusinessImpl implements ISkillsBusiness {

     private final SkillsRepository skillsRepository;

     final ModelMapper mapper;

    public SkillsBusinessImpl(SkillsRepository skillsRepository, ModelMapper mapper) {
        this.skillsRepository = skillsRepository;
        this.mapper = mapper;
    }

    @Override
    public Skills addSkills(SkillsDTO skillsDTO) {
        Skills skills = new Skills(
                skillsDTO.getId(),
                skillsDTO.getSkillName(),
                skillsDTO.getExperience(),
                skillsDTO.getScore(),
                "No",
                skillsDTO.getEmployee(),
                skillsDTO.getUser()
        );
        return skillsRepository.save(skills);
    }

    @Override
    public List<Skills> findAllSkills() {
        return skillsRepository.findAll();
    }

    @Override
    public Skills editSkills(SkillsDTO skillsDTO, String id) {
        Skills skills = this.mapper.map(skillsDTO, Skills.class);
        Optional<Skills> editObject = skillsRepository.findById(id);
        return (editObject.isPresent()? skillsRepository.save(skills):null);
    }

    @Override
    public Optional<Skills> showSkills(String id) {
        return skillsRepository.findById(id);
    }

    @Override
    public Skills archiveSkills(SkillsDTO skillsDTO, String id) {
        Skills skills = this.mapper.map(skillsDTO, Skills.class);
        Optional<Skills> editObject = skillsRepository.findById(id);
        skills.setIsArchived("Yes");
        return (editObject.isPresent()? skillsRepository.save(skills):null);
    }

    @Override
    public Skills restoreSkills(SkillsDTO skillsDTO, String id) {
        Skills skills = this.mapper.map(skillsDTO, Skills.class);
        Optional<Skills> editObject = skillsRepository.findById(id);
        skills.setIsArchived("No");
        return (editObject.isPresent()? skillsRepository.save(skills):null);
    }

    @Override
    public void deleteSkills(String id) {
        skillsRepository.deleteById(id);
    }

    @Override
    public List<Skills> getAllByEmployee(String id) {
        return skillsRepository.findAllByEmployee(id);
    }


}
