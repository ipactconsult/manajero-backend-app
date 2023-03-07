package com.manazello.projectmanagement.controllers;

import com.manazello.projectmanagement.business.ibusiness.IService;
import com.manazello.projectmanagement.dtos.ProjectDto;
import com.manazello.projectmanagement.entities.Project;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {
    final
    IService<Project> iProjectService;
    private final ModelMapper modelMapper;
    public ProjectController(IService<Project> iProjectService, ModelMapper modelMapper) {
        this.iProjectService = iProjectService;
        this.modelMapper=modelMapper;
    }

    @PostMapping("/addProject")
    public ResponseEntity<Project> createProject(@RequestBody ProjectDto projectDto) {
        Project project = modelMapper.map(projectDto, Project.class);
        return ((iProjectService.add(project) != null)
                ? new ResponseEntity<>(iProjectService.add(project), HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping("/AllActiveProjects")
    public ResponseEntity<List<Project>> getAllActiveProject() {
        try {
            List<Project> projectList = iProjectService.findAllActive();

            if (projectList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(projectList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/AllArchivedProjects")
    public ResponseEntity<List<Project>> getAllArchivedProject() {
        try {
            List<Project> projectList = iProjectService.findAllArchived();

            if (projectList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(projectList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/findProjectById/{id}")
    public ResponseEntity<Project> findProjectById(@PathVariable String id) {
        try {
            Project project = iProjectService.findById(id);

            if (project==null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(project, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/updateProject")
    public ResponseEntity<Project> updateProject(@RequestBody ProjectDto projectDTO) {
        Project project = modelMapper.map(projectDTO, Project.class);
        return ((iProjectService.update(project) != null)
                ? new ResponseEntity<>(iProjectService.update(project), HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }


}
