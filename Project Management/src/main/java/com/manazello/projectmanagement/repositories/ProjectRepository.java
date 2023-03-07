package com.manazello.projectmanagement.repositories;

import com.manazello.projectmanagement.entities.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends MongoRepository<Project,String> {
    List<Project> findByArchivedNot(boolean archived);
}
