package com.manazello.projectmanagement.repositories;

import com.manazello.projectmanagement.entities.ChangeRequest;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChangeRequestRepository extends MongoRepository<ChangeRequest,String> {
    List<ChangeRequest> findByArchivedNot(boolean archived);
    List<ChangeRequest> findByArchivedNotAndProject(boolean archived, ObjectId id);
    List<ChangeRequest> findChangeRequestByRequestorEmailAndProject(String email, ObjectId id);
}
