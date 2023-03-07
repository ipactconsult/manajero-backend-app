package com.communicationMarketing.main.repository;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.communicationMarketing.main.entity.Parternership;
import com.communicationMarketing.main.entity.PartnerByCountry;


@Repository

public interface ParternershipRepository   extends MongoRepository<Parternership,String> {

	
	  @Query(value = "SELECT Parternership, " +
	            "COUNT (CASE WHEN country LIKE 'Tunisia' THEN 1 END) AS Tunisia, " +
	            "COUNT (CASE WHEN country  LIKE 'Algeria' then 1 end) AS Algeria " +
	            "from intern group by establishment" )
	    Collection <PartnerByCountry> getPartnerByCpuntry();
	
}
