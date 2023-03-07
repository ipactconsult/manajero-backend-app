package com.communicationMarketing.main.repository;
import org.springframework.data.mongodb.repository.MongoRepository;



import org.springframework.stereotype.Repository;

import com.communicationMarketing.main.entity.Event;
@Repository
public interface  EventRepository extends MongoRepository<Event,String>  {

}
