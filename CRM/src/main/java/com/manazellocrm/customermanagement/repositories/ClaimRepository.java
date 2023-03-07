package com.manazellocrm.customermanagement.repositories;

import com.manazellocrm.customermanagement.entities.Claims;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends MongoRepository<Claims,String> {

    List<Claims> findClaimsByArchive(Boolean archive);
    List<Claims> findClaimsByArchiveOrderByClaimTitleAsc(Boolean archive);
    List<Claims> findClaimsByArchiveOrderByClaimTitleDesc(Boolean archive);
    List<Claims> findClaimsByArchiveOrderByCreatedAtDesc(Boolean archive);
    List<Claims> findClaimsByArchiveOrderByCreatedAtAsc(Boolean archive);
}
