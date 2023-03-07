package com.employees.main.controllers;


import com.employees.main.business.dto.MckenzieDTO;
import com.employees.main.business.ibusiness.MckenzieIBusiness;
import com.employees.main.entities.Mckenzie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "/mckenzie", produces = APPLICATION_JSON_VALUE)
public class MckenzieController {

    private final MckenzieIBusiness iBusiness;

    public MckenzieController(MckenzieIBusiness iBusiness) {
        this.iBusiness = iBusiness;
    }

    @PostMapping(value = "/create",consumes = "application/json")
    public ResponseEntity<Mckenzie> insert(@RequestBody MckenzieDTO mckenzieDTO){
        return new ResponseEntity<>(iBusiness.add(mckenzieDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Mckenzie>> findAllContracts(){
        return new ResponseEntity<>(iBusiness.visualize(), HttpStatus.OK);
    }
}
