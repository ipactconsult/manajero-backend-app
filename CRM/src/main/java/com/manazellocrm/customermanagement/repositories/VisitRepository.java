package com.manazellocrm.customermanagement.repositories;

import com.manazellocrm.customermanagement.entities.Customer;
import com.manazellocrm.customermanagement.entities.Visit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends MongoRepository<Visit,String> {

    @Query(value ="{customer: ?0}", count=true)      //SQL Equivalent : select count(*) from visits where customer=?
    Integer getVisitCountByCustomer(String id);

    List<Visit> findVisitsByArchiveOrderByCreatedAtDesc(String archive);
    List<Visit> findVisitsByArchiveOrderByCreatedAtAsc(String archive);

    List<Visit> findVisitsByArchive(String archive);

    List<Visit> findVisitsByArchiveOrderByTitleDesc(String archive);
    List<Visit> findVisitsByArchiveOrderByTitleAsc(String archive);

    List<Visit> findVisitsByArchiveAndCustomerOrderByDateVisitDesc(String archive, Customer customer);
    List<Visit> findVisitsByCustomerOrderByCreatedAt();
}
