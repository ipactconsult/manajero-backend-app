package com.manazellocrm.customermanagement.controllers;

import com.manazellocrm.customermanagement.business.dtos.VisitDTO;
import com.manazellocrm.customermanagement.business.ibusiness.IVisitsBusiness;
import com.manazellocrm.customermanagement.entities.Customer;
import com.manazellocrm.customermanagement.entities.Visit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = { "/api/visits" }, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class VisitController {

    IVisitsBusiness iVisitsBusiness;

    public VisitController(IVisitsBusiness iVisitsBusiness){
        this.iVisitsBusiness=iVisitsBusiness;
    }

    @PostMapping("/add/{idProperty}/{idCustomer}")
    public ResponseEntity<Visit> addVisit (@Valid @RequestBody VisitDTO visitDTO, @PathVariable("idProperty")  String idProperty, @PathVariable("idCustomer") String idCustomer){
        return iVisitsBusiness.addVisit(visitDTO, idProperty, idCustomer);
    }

    @GetMapping("/allVisits")
    public List<Visit> getAllVisits (){
        return iVisitsBusiness.getAllVisits();
    }

    @PutMapping("/update-visit/{idProperty}")
    public Visit updateVisit(@RequestBody Visit visit, @PathVariable("idProperty") String idProperty){
        return iVisitsBusiness.updateVisit(visit, idProperty);
    }

    @GetMapping("/visit-by-id/{id}")
    public ResponseEntity<Visit> getVisitByID (@PathVariable("id") String id){
        return iVisitsBusiness.getVisitByID(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteVisit(@PathVariable("id") String id){
        return iVisitsBusiness.deleteVisit(id);
    }


    @PutMapping("/archive-visit/{id}")
    public Visit archiveVisit(@RequestBody Visit visit, @PathVariable("id") String id){
        return iVisitsBusiness.archiveVisit(visit,id);
    }

    @PutMapping("/cancel-archive-visit/{id}")
    public Visit cancelArchiveVisit(@RequestBody Visit visit, @PathVariable("id") String id){
        return iVisitsBusiness.cancelArchiveVisit(visit,id);
    }

    @GetMapping( "/visits-descending-title/{archive}")
    public ResponseEntity<List<Visit>> listVisitDescTitle(@PathVariable ("archive") String archive){
        return new ResponseEntity<>(iVisitsBusiness.findAllVisitTitleDESC(archive), HttpStatus.OK);
    }

    @GetMapping( "/visits-asc-title/{archive}")
    public ResponseEntity<List<Visit>> listVisitAscTitle(@PathVariable ("archive") String archive){
        return new ResponseEntity<>(iVisitsBusiness.findAllVisitTitleASC(archive), HttpStatus.OK);
    }


    @GetMapping("/visit-by-desc-created/{archive}")
    public List<Visit> findVisitsCreatedDesc ( @PathVariable("archive") String archive){
        return iVisitsBusiness.getVisitsCreatedAtDesc(archive);
    }

    @GetMapping("/visit-by-asc-created/{archive}")
    public List<Visit> findVisitsCreatedAsc ( @PathVariable("archive") String archive){
        return iVisitsBusiness.getVisitsCreatedAtAsc(archive);
    }
    @GetMapping("/visits-non-archived/{archive}")
    public List<Visit> findVisitsNonArchived ( @PathVariable("archive") String archive){
        return iVisitsBusiness.getVisitsNonArchived(archive);
    }
    @GetMapping("/visits-by-customer")
    public List<Visit> findVisitsByCustomers(){
        return iVisitsBusiness.getVisitsByCustomers();
    }

    @GetMapping("/last-visits-by-customer-desc/{archive}/{id}")
    public List<Visit> findVisitsByCustomersDesc( @PathVariable("archive") String archive, @PathVariable("id") Customer id){
        return iVisitsBusiness.findAllLastsVisitTitleDESC(archive, id);
    }
}
