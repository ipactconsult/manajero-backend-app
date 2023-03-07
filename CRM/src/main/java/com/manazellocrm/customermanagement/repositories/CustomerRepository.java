package com.manazellocrm.customermanagement.repositories;

import com.manazellocrm.customermanagement.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {

    List<Customer> findCustomerByStatusAndArchive(String status, String archive);
    List<Customer> findCustomerByStatus(String status);


    @Query("{$expr:{$and:[{$eq:[{$dayOfMonth:'$dateOfBirth'}, ?0]}, {$eq:[{$month:'$dateOfBirth'}, ?1]}]}}")
    List<Customer> findByCustomQuery(int day, int month);

    List<Customer> findCustomersByArchive(String archive);

    List<Customer> findCustomersByStatusAndArchiveOrderByCreatedAtDesc(String status, String archive);

    List<Customer> findCustomersByStatusAndArchiveOrderByNameDesc(String status, String archive);
    List<Customer> findCustomersByStatusAndArchiveOrderByNameAsc(String status, String archive);




}
