
package com.communicationMarketing.main.repository;


import org.springframework.data.mongodb.repository.MongoRepository;


import org.springframework.stereotype.Repository;

import com.communicationMarketing.main.entity.GED;





@Repository
public interface GEDRepos   extends MongoRepository<GED,String>{


}
