package com.manazello.projectmanagement.repositories;

import com.manazello.projectmanagement.entities.Requirement;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequirementRpository extends MongoRepository<Requirement,String> {
    List<Requirement> findByArchivedNotAndProject(boolean archived, ObjectId id);

}
