package com.recruitment.recruitmenthcmmanagement.repositories;

import com.recruitment.recruitmenthcmmanagement.business.dto.ApplicationFirstName;
import com.recruitment.recruitmenthcmmanagement.business.dto.ApplicationGender;
import com.recruitment.recruitmenthcmmanagement.business.dto.ApplicationLastName;
import com.recruitment.recruitmenthcmmanagement.business.dto.ApplicationStatus;
import com.recruitment.recruitmenthcmmanagement.entities.Application;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends MongoRepository<Application,String> {

    List<Application> findAllByStatus(String status);
}
