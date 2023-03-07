package com.manazellocrm.customermanagement.controllers;

import com.manazellocrm.customermanagement.business.dtos.DealsDTO;
import com.manazellocrm.customermanagement.business.ibusiness.IDealsBusiness;
import com.manazellocrm.customermanagement.entities.Deals;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = { "/api/deals" }, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DealController {

    private final IDealsBusiness iDealsBusiness;

    public DealController(IDealsBusiness iDealsBusiness){
        this.iDealsBusiness=iDealsBusiness;
    }

    @PostMapping("/add")
    public ResponseEntity<Deals> addDeal (@Valid @RequestBody DealsDTO dealsDTO){
        return iDealsBusiness.addDeal(dealsDTO);
    }

    @GetMapping("/allDeals")
    public List<Deals> getAllDeals (){
        return iDealsBusiness.getAllDeals();
    }

    @PutMapping("/update-deal/{id}")
    public Deals updateDeal(@RequestBody Deals deals, @PathVariable("id") String id){
        return iDealsBusiness.updateDeal(deals,id);
    }

    @GetMapping("/deal-by-id/{id}")
    public ResponseEntity<Deals> getDealByID (@PathVariable("id") String id){
        return iDealsBusiness.getDealByID(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDeal(@PathVariable("id") String id){
        return iDealsBusiness.deleteDeal(id);
    }


    @PutMapping("/archive-deal/{id}")
    public Deals archiveDeal(@RequestBody Deals deals, @PathVariable("id") String id){
        return iDealsBusiness.archiveDeals(deals,id);
    }

    @PutMapping("/cancel-archive-deal/{id}")
    public Deals cancelArchiveDeal(@RequestBody Deals deals, @PathVariable("id") String id){
        return iDealsBusiness.cancelArchiveDeals(deals,id);
    }

    @GetMapping( "/all/descending")
    public ResponseEntity<List<Deals>> listDealsDesc(){
        return new ResponseEntity<>(iDealsBusiness.findAllDealsDESC(), HttpStatus.OK);
    }

    @GetMapping( "/all/ascending")
    public ResponseEntity<List<Deals>> listDealsAsc(){
        return new ResponseEntity<>(iDealsBusiness.findAllDealsASC(), HttpStatus.OK);
    }

   @GetMapping( "/deals-by-archive/{archive}")
    public ResponseEntity<List<Deals>> listDealsByArchive(@PathVariable("archive") String archive){
        return new ResponseEntity<>(iDealsBusiness.findAllDealsByArchive(archive), HttpStatus.OK);
    }

}
