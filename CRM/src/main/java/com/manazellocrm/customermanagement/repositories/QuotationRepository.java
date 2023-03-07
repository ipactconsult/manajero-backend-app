package com.manazellocrm.customermanagement.repositories;

import com.manazellocrm.customermanagement.entities.Quotation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuotationRepository extends MongoRepository<Quotation,String> {


    List<Quotation> findQuotationsByArchive(String archive);
    List<Quotation> findQuotationsByStatus(String status);

}
