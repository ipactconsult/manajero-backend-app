package com.employees.main.controllers;

import com.employees.main.business.dto.ReleaseDTO;
import com.employees.main.business.ibusiness.IReleaseBusiness;
import com.employees.main.entities.Employee;
import com.employees.main.entities.Release;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "/release", produces = APPLICATION_JSON_VALUE)
public class ReleaseController {

    private final IReleaseBusiness iReleaseBusiness;



    public ReleaseController(IReleaseBusiness iReleaseBusiness) {
        this.iReleaseBusiness = iReleaseBusiness;
    }

    @PostMapping(value = "/create/{id}",consumes = "application/json")
    public Release insertRelease(@RequestBody ReleaseDTO releaseDTO, @PathVariable("id")String id){

        return iReleaseBusiness.createRelease(releaseDTO,id);
    }

    @PostMapping(value = "/add/draft/{id}",consumes = "application/json")
    public Release insertDraftRelease(@RequestBody ReleaseDTO releaseDTO, @PathVariable("id")String id){

        return iReleaseBusiness.createDraftRelease(releaseDTO,id);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Release>> findAll(){
        return new ResponseEntity<>(iReleaseBusiness.findReleases(), HttpStatus.OK);
    }

    @GetMapping(value = "/all/asc")
    public ResponseEntity<List<Release>> findAllASC(){
        return new ResponseEntity<>(iReleaseBusiness.sortAscReleases(), HttpStatus.OK);
    }

    @GetMapping(value = "/all/desc")
    public ResponseEntity<List<Release>> findAllDesc(){
        return new ResponseEntity<>(iReleaseBusiness.sortDescReleases(), HttpStatus.OK);
    }

    @GetMapping(value = "/all/draft")
    public ResponseEntity<List<Release>> findAllDrafts(){
        return new ResponseEntity<>(iReleaseBusiness.findDraftReleases("Draft"), HttpStatus.OK);
    }

    @PutMapping( "/update/{id}")
    public Release editRelease(@RequestBody ReleaseDTO releaseDTO,@PathVariable("id") String id)
    {
        return iReleaseBusiness.updateRelease(releaseDTO,id);
    }

    @PutMapping("/validate-release/{id}")
    public Release validateReleasetLeave(@RequestBody ReleaseDTO releaseDTO,@PathVariable("id") String id)
    {
        return iReleaseBusiness.validateRelease(releaseDTO,id);
    }

    @PutMapping("/reject-release/{id}")
    public Release rejectReleaseLeave(@RequestBody ReleaseDTO releaseDTO,@PathVariable("id") String id)
    {
        return iReleaseBusiness.rejectRelease(releaseDTO,id);
    }

    @PutMapping("/cancel-release/{id}")
    public Release cancelReleaseLeave(@RequestBody ReleaseDTO releaseDTO,@PathVariable("id") String id)
    {
        return iReleaseBusiness.cancelRelease(releaseDTO,id);
    }

    @PutMapping("/archive-release/{id}")
    public Release archiveReleaseLeave(@RequestBody ReleaseDTO releaseDTO,@PathVariable("id") String id)
    {
        return iReleaseBusiness.archiveRelease(releaseDTO,id);
    }

    @PutMapping("/restore-release/{id}")
    public Release restoreReleaseLeave(@RequestBody ReleaseDTO releaseDTO,@PathVariable("id") String id)
    {
        return iReleaseBusiness.restoreRelease(releaseDTO,id);
    }

    @DeleteMapping("/delete-release/{id}")
    public String deleteReleaseLeave(@PathVariable("id") String id)
    {
        return iReleaseBusiness.deleteRelease(id);
    }

    @GetMapping("/get-release/{id}")
    public Optional<Release> getReleaseLeave(@PathVariable("id") String id)
    {
        return iReleaseBusiness.getRelease(id);
    }

    @GetMapping(value = "/allvalidate")
    public ResponseEntity<List<Release>> allValidate(){
        return new ResponseEntity<>(iReleaseBusiness.getAllByReleaseStatus(), HttpStatus.OK);
    }

    @GetMapping(value = "/allByEmployee/{id}")
    public ResponseEntity<List<Release>> allByEmployee(@PathVariable("id")Employee id){
        return new ResponseEntity<>(iReleaseBusiness.getAllByEmployee(id), HttpStatus.OK);
    }



}
