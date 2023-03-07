package com.recruitment.recruitmenthcmmanagement.repositories;
import com.recruitment.recruitmenthcmmanagement.entities.JobsCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsCategoryRepository extends MongoRepository<JobsCategory,String> {
}
