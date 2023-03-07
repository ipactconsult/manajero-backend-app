package com.manazello.projectmanagement.controllers;

import com.manazello.projectmanagement.business.businessImpl.RequirementImpl;
import com.manazello.projectmanagement.business.ibusiness.IService;
import com.manazello.projectmanagement.dtos.RequirementDto;
import com.manazello.projectmanagement.entities.Requirement;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/requirement")
@CrossOrigin(origins = "http://localhost:4200")
public class RequirementController {
    final
    IService<Requirement> iProjectService;
    RequirementImpl requirementImpl;
    private final ModelMapper modelMapper;

    public RequirementController(IService<Requirement> iProjectService, ModelMapper modelMapper, RequirementImpl requirementImpl) {
        this.iProjectService = iProjectService;
        this.modelMapper = modelMapper;
        this.requirementImpl=requirementImpl;
    }

     @PostMapping("/addRequirement")
    public ResponseEntity<Requirement> createRequirement(@RequestBody RequirementDto requirementDto) {
         Requirement project = modelMapper.map(requirementDto, Requirement.class);
        return ((iProjectService.add(project) != null)
                ? new ResponseEntity<>(iProjectService.add(project), HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping("/AllActiveRequirement")
    public ResponseEntity<List<Requirement>> getAllActiveRequirement() {
        try {
            List<Requirement> requirementList = iProjectService.findAllActive();

            if (requirementList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(requirementList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/AllArchivedRequirement")
    public ResponseEntity<List<Requirement>> getAllArchivedRequirement() {
        try {
            List<Requirement> requirementList = iProjectService.findAllArchived();

            if (requirementList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(requirementList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/findRequirementById/{id}")
    public ResponseEntity<Requirement> findRequirementById(@PathVariable String id) {
        try {
            Requirement requirement = iProjectService.findById(id);

            if (requirement==null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(requirement, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/findAllRequirementByIdProject/{id}")
    public ResponseEntity<List<Requirement>> findAllRequirementByIdProject(@PathVariable String id) {
        try {
            List<Requirement>  requirementList  = requirementImpl.findAllActiveRequirementByProject(id);

            if (requirementList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(requirementList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/findAllArchivedRequirementByProject/{id}")
    public ResponseEntity<List<Requirement>> findAllArchivedRequirementByProject(@PathVariable String id) {
        try {
            List<Requirement>  requirementList  = requirementImpl.findAllArchivedRequirementByProject(id);

            if (requirementList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(requirementList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/updateRequirement")
    public ResponseEntity<Requirement> updateRequirement(@RequestBody RequirementDto requirementDto) {
        Requirement requirement = modelMapper.map(requirementDto, Requirement.class);
        return ((iProjectService.update(requirement) != null)
                ? new ResponseEntity<>(iProjectService.update(requirement), HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }



}
