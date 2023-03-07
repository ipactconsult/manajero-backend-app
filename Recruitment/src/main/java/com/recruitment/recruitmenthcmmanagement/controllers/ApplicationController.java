package com.recruitment.recruitmenthcmmanagement.controllers;

import com.recruitment.recruitmenthcmmanagement.business.dto.*;
import com.recruitment.recruitmenthcmmanagement.business.ibusiness.IBusinessApplication;
import com.recruitment.recruitmenthcmmanagement.csvtomongo.jobs.CsvToMongoJob;
import com.recruitment.recruitmenthcmmanagement.entities.Application;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/application")
@CrossOrigin(origins = "http://localhost:4200/")
public class ApplicationController {

    final IBusinessApplication iBusinessApplication;

    final CsvToMongoJob mongoJob;

    public ApplicationController(IBusinessApplication iBusinessApplication, CsvToMongoJob mongoJob) {
        this.iBusinessApplication = iBusinessApplication;
        this.mongoJob = mongoJob;
    }

    @GetMapping("/list-applications")
    public List<Application> saveApplication() {
         return iBusinessApplication.readAll();
    }

    @GetMapping("/screening-applications")
    public List<Application> screeningApplications() {
        return iBusinessApplication.readAllByScreening();
    }


    @GetMapping("/app/{id}")
    public Optional<Application> application(@PathVariable("id")String id) {
        return iBusinessApplication.getApplication(id);
    }


    @PutMapping("/screen/{id}")
    public Application screen(@RequestBody ApplicationDTO applicationDTO, @PathVariable("id")String id) {
        return iBusinessApplication.screenProfile(applicationDTO,id);
    }

    @PutMapping("/validate/{id}")
    public Application validate(@RequestBody ApplicationDTO applicationDTO, @PathVariable("id")String id) {
        return iBusinessApplication.validateProfile(applicationDTO,id);
    }

    @PutMapping("/reject/{id}")
    public Application reject(@RequestBody ApplicationDTO applicationDTO, @PathVariable("id")String id) {
        return iBusinessApplication.rejectProfile(applicationDTO,id);
    }

}
