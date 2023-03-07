package com.manazello.administration.repositories;

import com.manazello.administration.entities.RentalRequest;
import com.manazello.administration.entities.enumeration.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministrationRepository extends MongoRepository<RentalRequest,String> {
    List<RentalRequest> findRentalRequestsByArchived(boolean archived);
    int countAllByStatus(Status status);
    RentalRequest findRentalRequestByMatriculateFiscal(String matriculate);

}
