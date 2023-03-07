package com.manazellocrm.customermanagement.repositories;

import com.manazellocrm.customermanagement.entities.Deals;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DealsRepository extends MongoRepository<Deals,String> {



    List<Deals> findDealsByDealDateIsGreaterThanAndDealStatus(Date dealDate, String dealStatus);
    List<Deals> findDealsByArchive(String archive);
}
