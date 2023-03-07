package com.employees.main.controllers;


import com.employees.main.business.dto.LeaveRequestDTO;
import com.employees.main.business.ibusiness.IBusinessLeaveRequest;
import com.employees.main.entities.Employee;
import com.employees.main.entities.LeaveRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
@RequestMapping(path= {"/leave-request"}, produces= APPLICATION_JSON_VALUE)
public class LeaveRequestController {


    private final IBusinessLeaveRequest iBusinessLeaveRequest;

    public LeaveRequestController(IBusinessLeaveRequest iBusinessLeaveRequest) {
        this.iBusinessLeaveRequest = iBusinessLeaveRequest;
    }

    @PostMapping(value = "/create")
    public LeaveRequest createRequestLeave(@Valid @RequestBody LeaveRequestDTO leaveRequestDTO){
        return  iBusinessLeaveRequest.createRequest(leaveRequestDTO);
    }

    @PostMapping(value = "/saveAsDraft")
    public LeaveRequest createRequestLeaveAsDraft(@Valid @RequestBody LeaveRequestDTO leaveRequestDTO){
        return  iBusinessLeaveRequest.createRequestAsDraft(leaveRequestDTO);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<LeaveRequest>> findAll(){
        return new ResponseEntity<>(iBusinessLeaveRequest.findRequests(), HttpStatus.OK);
    }

    @GetMapping(value = "/all/ascending")
    public ResponseEntity<List<LeaveRequest>> findAllAsc(){
        return new ResponseEntity<>(iBusinessLeaveRequest.findAscendingRequest(), HttpStatus.OK);
    }

    @GetMapping(value = "/all/descending")
    public ResponseEntity<List<LeaveRequest>> findAllDesc(){
        return new ResponseEntity<>(iBusinessLeaveRequest.findDescendingRequest(), HttpStatus.OK);
    }

    @PutMapping( "/update/{id}")
    public LeaveRequest editRequest(@RequestBody LeaveRequestDTO leaveRequestDTO,@PathVariable("id") String id)
    {
        return iBusinessLeaveRequest.updateRequest(leaveRequestDTO,id);
    }

    @PutMapping("/validate-request/{id}")
    public LeaveRequest validateRequestLeave(@RequestBody LeaveRequestDTO leaveRequestDTO,@PathVariable("id") String id)
    {
        return iBusinessLeaveRequest.validateRequest(leaveRequestDTO,id);
    }

    @PutMapping("/reject-request/{id}")
    public LeaveRequest rejectRequestLeave(@RequestBody LeaveRequestDTO leaveRequestDTO,@PathVariable("id") String id)
    {
        return iBusinessLeaveRequest.rejectRequest(leaveRequestDTO,id);
    }

    @PutMapping("/cancel-request/{id}")
    public LeaveRequest cancelRequestLeave(@RequestBody LeaveRequestDTO leaveRequestDTO,@PathVariable("id") String id)
    {
        return iBusinessLeaveRequest.cancelRequest(leaveRequestDTO,id);
    }

    @PutMapping("/archive-request/{id}")
    public LeaveRequest archiveRequestLeave(@RequestBody LeaveRequestDTO leaveRequestDTO,@PathVariable("id") String id)
    {
        return iBusinessLeaveRequest.archiveRequest(leaveRequestDTO,id);
    }

    @PutMapping("/restore-request/{id}")
    public LeaveRequest restoreRequestLeave(@RequestBody LeaveRequestDTO leaveRequestDTO,@PathVariable("id") String id)
    {
        return iBusinessLeaveRequest.restoreRequest(leaveRequestDTO,id);
    }

    @DeleteMapping("/delete-request/{id}")
    public String deleteRequestLeave(@PathVariable("id") String id)
    {
        return iBusinessLeaveRequest.deleteRequest(id);
    }

    @GetMapping("/get-request/{id}")
    public Optional<LeaveRequest> getRequestLeave(@PathVariable("id") String id)
    {
        return iBusinessLeaveRequest.getRequest(id);
    }

    @GetMapping(value = "/allvalidate")
    public ResponseEntity<List<LeaveRequest>> allValidate(){
        return new ResponseEntity<>(iBusinessLeaveRequest.getAllByRequestStatus(), HttpStatus.OK);
    }

    @GetMapping(value = "/allByEmployee/{id}")
    public ResponseEntity<List<LeaveRequest>> findByEmployee(@PathVariable("id") Employee id){
        return new ResponseEntity<>(iBusinessLeaveRequest.getByEmployee(id), HttpStatus.OK);
    }






}
