package com.manazello.projectmanagement.business.businessImpl;

import com.manazello.projectmanagement.business.ibusiness.IService;
import com.manazello.projectmanagement.entities.Project;
import com.manazello.projectmanagement.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements IService<Project> {

    final ProjectRepository projectRepository;

    public ServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project add(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> findAllActive() {
        return projectRepository.findByArchivedNot(true);
    }

    @Override
    public List<Project> findAllArchived() {
        return projectRepository.findByArchivedNot(false);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Project update(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project findById(String id) {

        return projectRepository.findById(id).orElse(null);
    }

}
