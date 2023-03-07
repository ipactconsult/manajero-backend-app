package com.manazello.projectmanagement.controllers;

import com.manazello.projectmanagement.business.businessImpl.ChangeRequestImpl;
import com.manazello.projectmanagement.business.ibusiness.IService;

import com.manazello.projectmanagement.dtos.ChangeRequestDto;
import com.manazello.projectmanagement.entities.ChangeRequest;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/changeRequest")
@CrossOrigin(origins = "http://localhost:4200")
public class ChangeRequestController {
    final
    IService<ChangeRequest> changeRequestIService;
    final ChangeRequestImpl changeRequestImpl;
    private final ModelMapper modelMapper;

    public ChangeRequestController(IService<ChangeRequest> changeRequestIService, ChangeRequestImpl changeRequestImpl, ModelMapper modelMapper) {
        this.changeRequestIService = changeRequestIService;
        this.changeRequestImpl = changeRequestImpl;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/addChangeRequest")
    public ResponseEntity<ChangeRequest> createChangeRequest(@RequestBody ChangeRequestDto changeRequestDto) {
        ChangeRequest changeRequest = modelMapper.map(changeRequestDto, ChangeRequest.class);
        return ((changeRequestIService.add(changeRequest) != null)
                ? new ResponseEntity<>(changeRequestIService.add(changeRequest), HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping("/AllActiveChangeRequest/{id}")
    public ResponseEntity<List<ChangeRequest>> getAllActiveChangeRequest(@PathVariable String id) {
        try {
            List<ChangeRequest> changeRequestList = changeRequestImpl.findAllActiveByProject(id);

            if (changeRequestList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(changeRequestList, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/AllArchivedChangeRequest/{id}")
    public ResponseEntity<List<ChangeRequest>> getAllArchivedChangeRequest(@PathVariable String id) {
        try {
            List<ChangeRequest> changeRequestList = changeRequestImpl.findAllArchivedByProject(id);

            if (changeRequestList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(changeRequestList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/findChangeRequestById/{id}")
    public ResponseEntity<ChangeRequest> findProjectById(@PathVariable String id) {
        try {
            ChangeRequest changeRequest = changeRequestIService.findById(id);

            if (changeRequest == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(changeRequest, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/findChangeRequestByRequestor/{id}/{email}")
    public ResponseEntity< List<ChangeRequest>> findChangeRequestByRequestorEmailAndProject(@PathVariable String id,@PathVariable String email) {
        try {
            System.out.println(email +id);
            List<ChangeRequest> changeRequestList = changeRequestImpl.findChangeRequestByRequestorEmailAndProject(email,id);

            if (changeRequestList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(changeRequestList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/updateChangeRequest")
    public ResponseEntity<ChangeRequest> updateChangeRequest(@RequestBody ChangeRequestDto changeRequestDto) {
        ChangeRequest changeRequest = modelMapper.map(changeRequestDto, ChangeRequest.class);
        return ((changeRequestIService.update(changeRequest) != null)
                ? new ResponseEntity<>(changeRequestIService.update(changeRequest), HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }



}
