package com.recruitment.recruitmenthcmmanagement.controllers;

import com.recruitment.recruitmenthcmmanagement.business.ibusiness.IBusinessJobOffer;
import com.recruitment.recruitmenthcmmanagement.entities.JobOffer;

import com.recruitment.recruitmenthcmmanagement.repositories.JobOfferRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = {"jobOffer"})
@CrossOrigin(origins = "http://localhost:4200/")
public class JobOfferController {

     IBusinessJobOffer iBusinessJobOffer;

     final JobOfferRepository jb;
    final RestTemplate rest;

    public JobOfferController(JobOfferRepository jb, RestTemplate rest) {
        this.jb = jb;
        this.rest = rest;
    }


    public static String getBearerTokenHeader() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).
                getRequest().getHeader("Authorization");
    }
    @PostMapping("/create")
    public JobOffer postJob(@RequestBody JobOffer jobOffer)
    {
        /*HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", getBearerTokenHeader());
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String employee= rest.exchange("http://auth-service/api/auth/getuserconnected", HttpMethod.GET, entity, String.class).getBody();
        jobOffer.setEmployee(employee);
        System.out.println("Employee ::"+employee);*/
     //   return jobOfferRepository.save(jobOffer);
        return jb.save(jobOffer);
    }

    @PutMapping("/update/{id}")
    public JobOffer updateJob(@RequestBody JobOffer jobOffer, @PathVariable("id")String id)
    {
        return iBusinessJobOffer.editJob(jobOffer,id);
    }

    @PutMapping("/archive/{id}")
    public JobOffer archiveJob(@RequestBody JobOffer jobOffer, @PathVariable("id")String id)
    {
        return iBusinessJobOffer.archive(jobOffer,id);
    }

    @PutMapping("/restore/{id}")
    public JobOffer restoreJob(@RequestBody JobOffer jobOffer, @PathVariable("id")String id)
    {
        return iBusinessJobOffer.restore(jobOffer,id);
    }

    @GetMapping("/show/{id}")
    public Optional<JobOffer> showJob(@PathVariable("id")String id)
    {
        return iBusinessJobOffer.getJob(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<JobOffer>> allJobs()
    {
        return new ResponseEntity<>(jb.findAll(), HttpStatus.OK);
    }

    @GetMapping("/all/asc")
    public ResponseEntity<List<JobOffer>> allJobsAsc()
    {
        return new ResponseEntity<>(jb.findAll(Sort.by("jobTitle").ascending()), HttpStatus.OK);
    }
    @GetMapping("/all/desc")
    public ResponseEntity<List<JobOffer>> allJobsDesc()
    {
        return new ResponseEntity<>(jb.findAll(Sort.by("jobTitle").descending()), HttpStatus.OK);
    }

    @GetMapping("/all/people_positions/asc")
    public ResponseEntity<List<JobOffer>> allJobsAscPositions()
    {
        return new ResponseEntity<>(jb.findAll(Sort.by("nb_people_positions").ascending()), HttpStatus.OK);
    }

    @GetMapping("/all/people_positions/desc")
    public ResponseEntity<List<JobOffer>> allJobsDescPositions()
    {
        return new ResponseEntity<>(jb.findAll(Sort.by("nb_people_positions").descending()), HttpStatus.OK);
    }
}
