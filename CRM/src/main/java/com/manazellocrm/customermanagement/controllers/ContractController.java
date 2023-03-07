package com.manazellocrm.customermanagement.controllers;

import com.manazellocrm.customermanagement.business.ibusiness.IContractBusiness;
import com.manazellocrm.customermanagement.entities.Contract;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = { "/api/contract" }, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ContractController {

    IContractBusiness iContractBusiness;

    public ContractController(IContractBusiness iContractBusiness){
        this.iContractBusiness=iContractBusiness;
    }

    @PostMapping("/add")
    public ResponseEntity<Contract> addContract (@Valid @RequestBody Contract contractDTO){
        return new ResponseEntity<>(iContractBusiness.addContract(contractDTO),HttpStatus.OK);
    }
  @PostMapping("/create")
    public ResponseEntity<Contract> addContractCustomized (@Valid @RequestBody Contract contractDTO){
        return new ResponseEntity<>(iContractBusiness.addContractCustomized(contractDTO),HttpStatus.OK);
    }

    @GetMapping("/allContracts")
    public ResponseEntity<List<Contract>> findAllContracts(){
        List<Contract> rows = iContractBusiness.getAllContracts();
        return new ResponseEntity <>(rows, HttpStatus.OK);
    }

    @PutMapping("/update-contract/{id}")
    public Contract updateContract(@RequestBody Contract contract, @PathVariable("id")  String id){
        return iContractBusiness.updateContract(contract,id);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContract(@PathVariable("id") String id){
        return iContractBusiness.deleteContract(id);
    }

    @GetMapping("/contract-by-id/{id}")
    public ResponseEntity<Contract> getContractByID (@PathVariable("id") String id){
        return iContractBusiness.getContractByID(id);
    }

    @GetMapping("/count-contracts")
    public long countContracts(){
        return iContractBusiness.countContracts();
    }

    @GetMapping( "/all/descending")
    @Cacheable(value = "Contract")
    public ResponseEntity<List<Contract>> listContractsDesc(){
        return new ResponseEntity<>(iContractBusiness.findAllContractDESC(), HttpStatus.OK);
    }
    @GetMapping( "/all/ascending")
    @Cacheable(value = "Contract")
    public ResponseEntity<List<Contract>> listContractsAsc(){
        return new ResponseEntity<>(iContractBusiness.findAllContractASC(), HttpStatus.OK);
    }

   @GetMapping( "/contracts-non-archived/{archive}")
    public ResponseEntity<List<Contract>> listContractsNonArchived(@PathVariable("archive") String archive){
        return new ResponseEntity<>(iContractBusiness.getAllContractsNonArchived(archive), HttpStatus.OK);
    }


   @GetMapping( "/contracts-archived")
    public ResponseEntity<List<Contract>> listContractsArchived(){
        return new ResponseEntity<>(iContractBusiness.getAllContractsArchived(), HttpStatus.OK);
    }



    @PutMapping("/archive-contract/{id}")
    public Contract archiveContract(@RequestBody Contract contract, @PathVariable("id") String id){
        return iContractBusiness.archiveContract(contract,id);
    }

    @PutMapping("/cancel-archive-contract/{id}")
    public Contract cancelArchiveContract(@RequestBody Contract contract, @PathVariable("id") String id){
        return iContractBusiness.cancelArchiveContract(contract,id);
    }
}
