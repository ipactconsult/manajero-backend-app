package com.manazellocrm.customermanagement.business.ibusiness;

import com.manazellocrm.customermanagement.business.dtos.ClaimsDTO;
import com.manazellocrm.customermanagement.entities.Claims;
import org.springframework.http.ResponseEntity;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface IClaimsBusiness {

    ResponseEntity<Claims> addClaim (ClaimsDTO claimDTO, String idEmployee) throws NoSuchAlgorithmException;
    Claims updateClaim (Claims claims,String idEmployee);
    ResponseEntity<String> deleteClaim (String id);
    List<Claims> getAllClaims ();
    ResponseEntity<Claims> getClaimByID(String id);
    List<Claims> getClaimsNonArchived(Boolean archive);
    Claims cancelArchiveClaim(Claims claims, String id);
    Claims archiveClaim(Claims claims, String id);
    List<Claims> getClaimsCreatedAtDesc(Boolean archive);
    List<Claims> getClaimsCreatedAtAsc(Boolean archive);
    List<Claims> findAllClaimsTitleASC(Boolean archive);
    List<Claims> findAllClaimsTitleDESC(Boolean archive);

}
