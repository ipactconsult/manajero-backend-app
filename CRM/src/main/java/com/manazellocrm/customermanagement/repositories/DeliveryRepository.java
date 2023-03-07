package com.manazellocrm.customermanagement.repositories;

import com.manazellocrm.customermanagement.entities.Delivery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends MongoRepository<Delivery, String> {

    List<Delivery> findDeliveriesByArchiveOrderByCreatedAtAsc(String archive);
    List<Delivery> findDeliveriesByArchiveOrderByCreatedAtDesc(String archive);
    List<Delivery> findDeliveriesByArchive(String archive);


}
