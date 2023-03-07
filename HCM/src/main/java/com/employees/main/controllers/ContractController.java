package com.employees.main.controllers;

import com.employees.main.business.dto.ContractDTO;
import com.employees.main.business.ibusiness.IContractBusiness;
import com.employees.main.entities.Contract;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "/contract", produces = APPLICATION_JSON_VALUE)
public class ContractController {

    private final IContractBusiness contractIB;

    public ContractController(IContractBusiness contractIB) {
        this.contractIB = contractIB;
    }

    @PostMapping(value = "/create",consumes = "application/json")
    public ResponseEntity<Contract> insertContract(@RequestBody ContractDTO contractDTO){
        return new ResponseEntity<>(contractIB.createContract(contractDTO), HttpStatus.OK);
    }

    @PostMapping(value = "/assign/{id}")
    public ResponseEntity<Contract> assignContractToEmployee(@RequestBody ContractDTO contractDTO, @PathVariable("id")String id){
        return new ResponseEntity<>(contractIB.assignContractEmployee(contractDTO,id), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Contract>> findAllContracts(){
        return new ResponseEntity<>(contractIB.findAllContracts(), HttpStatus.OK);
    }

    @GetMapping(value = "/all/sorting/hiringDate/asc")
    public ResponseEntity<List<Contract>> findAllSortingAscByHiringDate(){
        return new ResponseEntity<>(contractIB.findAllContractSortingByHiringDateAsc(), HttpStatus.OK);
    }

    @GetMapping(value = "/all/sorting/hiringDate/desc")
    public ResponseEntity<List<Contract>> findAllSortingDescByHiringDate(){
        return new ResponseEntity<>(contractIB.findAllContractSortingByHiringDateDesc(), HttpStatus.OK);
    }

    @GetMapping(value = "/all/sorting/endDate/asc")
    public ResponseEntity<List<Contract>> findAllSortingAscByEndDate(){
        return new ResponseEntity<>(contractIB.findAllContractSortingByEndDateAsc(), HttpStatus.OK);
    }

    @GetMapping(value = "/all/sorting/endDate/desc")
    public ResponseEntity<List<Contract>> findAllSortingDescByEndDate(){
        return new ResponseEntity<>(contractIB.findAllContractSortingByEndDateDesc(), HttpStatus.OK);
    }

    @GetMapping(value = "/all/sorting/officialSignature/asc")
    public ResponseEntity<List<Contract>> findAllSortingAscByOfficialSignature(){
        return new ResponseEntity<>(contractIB.findAllContractSortingByOfficialSignatureAsc(), HttpStatus.OK);
    }

    @GetMapping(value = "/all/sorting/officialSignature/desc")
    public ResponseEntity<List<Contract>> findAllSortingDescByOfficialSignature(){
        return new ResponseEntity<>(contractIB.findAllContractSortingByOfficialSignatureDesc(), HttpStatus.OK);
    }

    @GetMapping(value = "/all/sorting/grossAnualSalary/asc")
    public ResponseEntity<List<Contract>> findAllSortingAscByGrossAnnualSalary(){
        return new ResponseEntity<>(contractIB.findAllContractSortingByGrossAnualSalaryAsc(), HttpStatus.OK);
    }

    @GetMapping(value = "/all/sorting/grossAnualSalary/desc")
    public ResponseEntity<List<Contract>> findAllSortingDescByGrossAnnualSalary(){
        return new ResponseEntity<>(contractIB.findAllContractSortingByGrossAnualSalaryDesc(), HttpStatus.OK);
    }

    @PutMapping( "/update/{id}")
    public Contract editContract(@RequestBody ContractDTO contractDTO,@PathVariable("id") String id)
    {
        return contractIB.updateContract(contractDTO,id);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Contract> getDepartmentById(@PathVariable("id") String id)
    {
        return new ResponseEntity<>(contractIB.getContract(id),HttpStatus.OK);
    }

    @PutMapping( "/update-is-archived/{id}")
    public Contract editIsArchived(@RequestBody ContractDTO contractDTO, @PathVariable("id") String id)
    {
        return contractIB.archiveContract(contractDTO,id);
    }

    @PutMapping( "/update-is-restore/{id}")
    public Contract editRestoreArchive(@RequestBody ContractDTO contractDTO, @PathVariable("id") String id)
    {
        return contractIB.restoreContract(contractDTO,id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteContract(@PathVariable("id") String id)
    {
        return new ResponseEntity<>(contractIB.deleteContract(id),HttpStatus.OK);
    }





}
