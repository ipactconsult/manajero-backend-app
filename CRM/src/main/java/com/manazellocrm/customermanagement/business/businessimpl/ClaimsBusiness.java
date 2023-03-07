package com.manazellocrm.customermanagement.business.businessimpl;

import com.manazellocrm.customermanagement.business.dtos.ClaimsDTO;
import com.manazellocrm.customermanagement.business.ibusiness.IClaimsBusiness;
import com.manazellocrm.customermanagement.entities.Claims;
import com.manazellocrm.customermanagement.repositories.ClaimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.*;


@RequiredArgsConstructor
@Service
public class ClaimsBusiness implements IClaimsBusiness {

   private final ClaimRepository claimRepository;
   private final RestTemplate rest;


    @Override
    public ResponseEntity<Claims> addClaim(ClaimsDTO claimDTO, String idEmployee) throws NoSuchAlgorithmException {
        Date date = new Date();
        Instant instanceNow = date.toInstant();
        HttpHeaders headers = new HttpHeaders();
        Random r = SecureRandom.getInstanceStrong();

        int randomInt = r.nextInt((100 - 50 + 1) + 50);

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        Object employee= rest.exchange("https://employees-hcm-manazello.herokuapp.com/employee/findbyid/"+idEmployee, HttpMethod.GET,
                entity, Object.class).getBody();
        Claims claims= new Claims();
        claims.setClaimTitle(claimDTO.getClaimTitle());
        claims.setClaimCode("#"+randomInt);
        claims.setClaimDate(claimDTO.getClaimDate());
        claims.setClaimType(claimDTO.getClaimType());
        claims.setUrgencyType(claimDTO.getUrgencyType());
        claims.setDescriptionClaim(claimDTO.getDescriptionClaim());
        claims.setCustomer(claimDTO.getCustomer());
        claims.setOtherInfos(claimDTO.getOtherInfos());
        claims.setResponseClaim(claimDTO.getResponseClaim());
        claims.setClaimMotif(claimDTO.getClaimMotif());
        claims.setClosingDate(claimDTO.getClosingDate());
        claims.setEvaluationClaim(claimDTO.getEvaluationClaim());
        claims.setStatus("Pending");
        claims.setArchive(false);
        claims.setUser(claimDTO.getUser());
        claims.setCreatedAt(instanceNow);
        claims.setEmployee(employee);
        claimRepository.save(claims);
        return ResponseEntity.status(HttpStatus.CREATED).body(claims); }

    @Override
    @Transactional
    public Claims updateClaim(Claims claims,String idEmployee) {
        Optional<Claims> claimOptional= claimRepository.findById(claims.getId());
        Date date= new Date();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        Object employee= rest.exchange("https://employees-hcm-manazello.herokuapp.com/employee/findbyid/"+idEmployee, HttpMethod.GET,
                entity, Object.class).getBody();
        Instant dateToUpdate= date.toInstant();
        claims.setEmployee(employee);
        claims.setModifiedAt(dateToUpdate);
        return (claimOptional.isPresent() ?
                claimRepository.save(claims)
                : null);
    }

    @Override
    public ResponseEntity<String> deleteClaim(String id) {
        if(claimRepository.findById(id).isPresent()){
            claimRepository.deleteById(id);
            return new ResponseEntity<>("Claim deleted Successfully!", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Claim not found", HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public Claims archiveClaim(Claims claims, String id) {
        Optional<Claims> claimsDetails= claimRepository.findById(id);
        Date date= new Date();
        Instant dateToUpdate= date.toInstant();
        claims.setModifiedAt(dateToUpdate);
        claims.setArchive(true);
        return (claimsDetails.isPresent() ?
                claimRepository.save(claims)
                : null);
    }

    @Override
    public Claims cancelArchiveClaim(Claims claims, String id) {
        Optional<Claims> claimsDetails= claimRepository.findById(id);
        Date date= new Date();
        Instant dateToUpdate= date.toInstant();
        claims.setModifiedAt(dateToUpdate);
        claims.setArchive(false);
        return (claimsDetails.isPresent() ?
                claimRepository.save(claims)
                : null);
    }

    @Override
    public List<Claims> getAllClaims() {
        return claimRepository.findAll();
    }

    @Override
    public ResponseEntity<Claims> getClaimByID(String id) {
        Optional<Claims> claimData = claimRepository.findById(id);
        return claimData.map(contract -> new ResponseEntity<>(contract, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

    }
    @Override
    public  List<Claims> getClaimsNonArchived(Boolean archive) {
        return claimRepository.findClaimsByArchive(archive);
    }



    @Override
    public List<Claims> getClaimsCreatedAtDesc(Boolean archive) {
        return claimRepository.findClaimsByArchiveOrderByCreatedAtDesc(archive);
    }

    @Override
    public List<Claims> getClaimsCreatedAtAsc(Boolean archive) {
        return claimRepository.findClaimsByArchiveOrderByCreatedAtAsc(archive);
    }

    @Override
    public List<Claims> findAllClaimsTitleASC(Boolean archive) {
        return claimRepository.findClaimsByArchiveOrderByClaimTitleAsc(archive);
    }


    @Override
    public List<Claims> findAllClaimsTitleDESC(Boolean archive) {
        return claimRepository.findClaimsByArchiveOrderByClaimTitleDesc(archive);
    }


}
