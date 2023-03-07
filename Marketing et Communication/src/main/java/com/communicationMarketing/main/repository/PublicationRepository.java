package com.communicationMarketing.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.communicationMarketing.main.entity.Publication;

@Repository

public interface PublicationRepository  extends MongoRepository<Publication, String> {

}
