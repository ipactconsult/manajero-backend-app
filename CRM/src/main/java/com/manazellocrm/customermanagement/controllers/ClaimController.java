package com.manazellocrm.customermanagement.controllers;

import com.manazellocrm.customermanagement.business.dtos.ClaimsDTO;
import com.manazellocrm.customermanagement.business.ibusiness.IClaimsBusiness;
import com.manazellocrm.customermanagement.entities.Claims;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = { "/api/claim" }, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClaimController {

  private final IClaimsBusiness iClaimsBusiness;

    public ClaimController(IClaimsBusiness iClaimsBusiness) {
        this.iClaimsBusiness = iClaimsBusiness;
    }

    @PostMapping("/add/{idEmployee}")
    public ResponseEntity<Claims> addClaim (@Valid @RequestBody ClaimsDTO claimsDTO,
                                            @PathVariable("idEmployee") String idEmployee) throws NoSuchAlgorithmException {
        return iClaimsBusiness.addClaim(claimsDTO,idEmployee);
    }


    @PutMapping("/update-claim/{idEmployee}")
    public Claims updateClaim(@RequestBody Claims claims, @PathVariable("idEmployee")String idEmployee){
        return iClaimsBusiness.updateClaim(claims,idEmployee);
    }


    @GetMapping("/claim-by-id/{id}")
    public ResponseEntity<Claims> getClaimByID (@PathVariable("id") String id){
        return iClaimsBusiness.getClaimByID(id);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClaim(@PathVariable("id") String id){
        return iClaimsBusiness.deleteClaim(id);
    }



    @PutMapping("/archive-claim/{id}")
    public Claims archiveClaim(@RequestBody Claims claims, @PathVariable("id") String id){
        return iClaimsBusiness.archiveClaim(claims,id);
    }

    @PutMapping("/cancel-archive-claim/{id}")
    public Claims cancelArchiveClaim(@RequestBody Claims claims, @PathVariable("id") String id){
        return iClaimsBusiness.cancelArchiveClaim(claims,id);
    }

    @GetMapping("/claims-non-archived/{archive}")
    public List<Claims> findClaimsNonArchived (@PathVariable("archive") Boolean archive){
        return iClaimsBusiness.getClaimsNonArchived(archive);
    }

    @GetMapping("/claims")
    public List<Claims> findClaims (){
        return iClaimsBusiness.getAllClaims();
    }


    @GetMapping("/claim-by-desc-created/{archive}")
    public List<Claims> findClaimsCreatedDesc ( @PathVariable("archive") Boolean archive){
        return iClaimsBusiness.getClaimsCreatedAtDesc(archive);
    }

    @GetMapping("/claim-by-asc-created/{archive}")
    public List<Claims> findClaimsCreatedAsc ( @PathVariable("archive") Boolean archive){
        return iClaimsBusiness.getClaimsCreatedAtAsc(archive);
    }

    @GetMapping( "/claims-descending-title/{archive}")
    public ResponseEntity<List<Claims>> listClaimsDescTitle(@PathVariable ("archive") Boolean archive){
        return new ResponseEntity<>(iClaimsBusiness.findAllClaimsTitleDESC(archive), HttpStatus.OK);
    }

    @GetMapping( "/claims-asc-title/{archive}")
    public ResponseEntity<List<Claims>> listClaimsAscTitle(@PathVariable ("archive") Boolean archive){
        return new ResponseEntity<>(iClaimsBusiness.findAllClaimsTitleASC(archive), HttpStatus.OK);
    }

}
