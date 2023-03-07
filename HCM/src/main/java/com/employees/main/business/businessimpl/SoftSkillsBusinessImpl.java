package com.employees.main.business.businessimpl;

import com.employees.main.business.dto.SoftSkillsDTO;
import com.employees.main.business.ibusiness.IBusinessSoftSkills;
import com.employees.main.entities.SoftSkills;
import com.employees.main.repositories.SoftSkillsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoftSkillsBusinessImpl implements IBusinessSoftSkills {

    private final SoftSkillsRepository softSkillsRepository;

    private final ModelMapper mapper;

    public SoftSkillsBusinessImpl(SoftSkillsRepository softSkillsRepository, ModelMapper mapper) {
        this.softSkillsRepository = softSkillsRepository;
        this.mapper = mapper;
    }

    @Override
    public SoftSkills addSoft(SoftSkillsDTO skillsDTO) {
        SoftSkills softSkills = new SoftSkills(
                skillsDTO.getId(),
                skillsDTO.getSkillName(),
                skillsDTO.getExperience(),
                skillsDTO.getScore(),
                "No",
                skillsDTO.getEmployee(),
                skillsDTO.getUser()
        );
        return softSkillsRepository.save(softSkills);
    }

    @Override
    public List<SoftSkills> findAllSofts() {
        return softSkillsRepository.findAll();
    }

    @Override
    public SoftSkills editSoft(SoftSkillsDTO softSkillsDTO, String id) {
        SoftSkills soft = this.mapper.map(softSkillsDTO, SoftSkills.class);
        Optional<SoftSkills> editObject = softSkillsRepository.findById(id);
        return (editObject.isPresent()? softSkillsRepository.save(soft):null);
    }

    @Override
    public Optional<SoftSkills> showSoft(String id) {
        return softSkillsRepository.findById(id);
    }

    @Override
    public SoftSkills archiveSoft(SoftSkillsDTO softSkillsDTO, String id) {
        SoftSkills softSkills = this.mapper.map(softSkillsDTO, SoftSkills.class);
        Optional<SoftSkills> editObject = softSkillsRepository.findById(id);
        softSkills.setIsArchived("Yes");
        return (editObject.isPresent()? softSkillsRepository.save(softSkills):null);
    }

    @Override
    public SoftSkills restoreSoft(SoftSkillsDTO softSkillsDTO, String id) {
        SoftSkills softSkills = this.mapper.map(softSkillsDTO, SoftSkills.class);
        Optional<SoftSkills> editObject = softSkillsRepository.findById(id);
        softSkills.setIsArchived("No");
        return (editObject.isPresent()? softSkillsRepository.save(softSkills):null);
    }

    @Override
    public void deleteSoft(String id) {
            softSkillsRepository.deleteById(id);
    }

    @Override
    public List<SoftSkills> getAllByEmployee(String idEmployee) {
        return softSkillsRepository.findByEmployeeIsNotNull(idEmployee,"No");
    }
}
