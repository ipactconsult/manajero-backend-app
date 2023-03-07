package com.communicationMarketing.main.Controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;



import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.communicationMarketing.main.business.dtos.PublicationDTO;
import com.communicationMarketing.main.business.ibusiness.IPublicationBusiness;
import com.communicationMarketing.main.entity.Event;
import com.communicationMarketing.main.entity.Publication;

@RequestMapping(path = { "/Publication" }, produces = APPLICATION_JSON_VALUE)
@RestController
public class PublicationController {
	
	IPublicationBusiness IPublicationBusiness;

    public PublicationController(IPublicationBusiness IPublicationBusiness){
        this.IPublicationBusiness=IPublicationBusiness;
    }

    @PostMapping("/add")
    public ResponseEntity<Publication> addPublication (@Valid @RequestBody PublicationDTO publicationDTO){
        return IPublicationBusiness.addPublication(publicationDTO);
    }
    @GetMapping("/allPublications")
    public ResponseEntity<List<Publication>> findAllEvents(){
        List<Publication> rows = IPublicationBusiness.getAllPublications();
        return new ResponseEntity <>(rows, HttpStatus.OK);
    }
    @PutMapping("/update-publication")
    public Publication updatePublication(@RequestBody Publication p){
        return IPublicationBusiness.updatePublication(p);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePublication(@PathVariable("id")  String id){
        return IPublicationBusiness.deletePublication(id);
    }
   @GetMapping("/Publication-by-id/{id}")
    public ResponseEntity<?> getPublicationByID (@PathVariable("id") String id){
        return IPublicationBusiness.getPublicationByID(id);
    }

    @GetMapping("/count-Publications")
    public long countPublications(){
        return IPublicationBusiness.countPublications();
    }

    @GetMapping( "/descending")
    public ResponseEntity<List<Publication>> listPublicationDesc(){
        return new ResponseEntity<>(IPublicationBusiness.findAllPublicationDESC(), HttpStatus.OK);
    }
    @GetMapping( "/ascending")
    public ResponseEntity<List<Publication>> listPublicationAsc(){
        return new ResponseEntity<>(IPublicationBusiness.findAllPublicationASC(), HttpStatus.OK);
    }
    
    
    
    @PutMapping("/archive-Publication/{id}")
    public Publication archivePublication(@RequestBody Publication p, @PathVariable("id") String id){
        return IPublicationBusiness.archivePublication(p, id);
    }

    @PutMapping("/cancelArchive-Publication/{id}")
    public Publication cancelArchivePublication(@RequestBody Publication p, @PathVariable("id") String id){
        return IPublicationBusiness.cancelArchivePublication(p, id);
    }



}
