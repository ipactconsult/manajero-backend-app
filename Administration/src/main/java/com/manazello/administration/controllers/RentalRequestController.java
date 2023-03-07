package com.manazello.administration.controllers;


import com.manazello.administration.business.businesimpl.Iservice;
import com.manazello.administration.dtos.RentalRequestDto;
import com.manazello.administration.entities.RentalRequest;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rentalRequest")
@CrossOrigin(origins = "http://localhost:4200")
public class RentalRequestController {
    final Iservice<RentalRequest> rentalRequestIserviceImpl;
    private final ModelMapper modelMapper;

    public RentalRequestController(Iservice<RentalRequest> rentalRequestIserviceImpl, ModelMapper modelMapper) {
        this.rentalRequestIserviceImpl = rentalRequestIserviceImpl;
        this.modelMapper = modelMapper;
    }


    @PostMapping("/sendRequest")
    public ResponseEntity<RentalRequest> sendRequest(@RequestBody RentalRequestDto rentalRequestDto) {
        RentalRequest rentalRequest = modelMapper.map(rentalRequestDto, RentalRequest.class);
        RentalRequest rentalRequestAdded = rentalRequestIserviceImpl.add(rentalRequest);
        return ((rentalRequestAdded != null)
                ? new ResponseEntity<>(rentalRequestAdded, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping("/AllActiveRentalRequests")
    public ResponseEntity<List<RentalRequest>> getAllActiveRentalRequest() {
        try {

            List<RentalRequest> rentalRequestList = rentalRequestIserviceImpl.findAllActive();

            if (rentalRequestList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(rentalRequestList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/AllArchivedRentalRequests")
    public ResponseEntity<List<RentalRequest>> getAllArchivedRentalRequest() {
        try {

            List<RentalRequest> rentalRequestList = rentalRequestIserviceImpl.findAllArchived();

            if (rentalRequestList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(rentalRequestList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PutMapping("/validation")
    public ResponseEntity<RentalRequest> validation(@RequestBody RentalRequestDto rentalRequestDto) {
        RentalRequest rentalRequest = modelMapper.map(rentalRequestDto, RentalRequest.class);
        RentalRequest rentalRequestUpdated = rentalRequestIserviceImpl.update(rentalRequest);
        return (rentalRequestUpdated != null)
                ? new ResponseEntity<>(rentalRequestUpdated, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("/countrequests_undervalidation")
    public int getAllUnderValidation() {
        return rentalRequestIserviceImpl.countUnderValidation();
    }

    @GetMapping("/countrequests_pending")
    public int getAllPending() {
        return rentalRequestIserviceImpl.countPending();
    }

    @GetMapping("/countrequests_approved")
    public int getAllApproved() {
        return rentalRequestIserviceImpl.countApproved();
    }

    @GetMapping("/countrequests_denied")
    public int getAllDenied() {
        return rentalRequestIserviceImpl.countDenied();
    }
}
