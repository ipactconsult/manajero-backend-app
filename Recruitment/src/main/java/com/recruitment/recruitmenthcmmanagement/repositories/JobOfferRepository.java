package com.recruitment.recruitmenthcmmanagement.repositories;

import com.recruitment.recruitmenthcmmanagement.entities.JobOffer;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface JobOfferRepository extends MongoRepository<JobOffer,String> {
}
