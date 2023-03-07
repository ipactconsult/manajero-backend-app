package com.manazello.administration.repositories;

import com.manazello.administration.entities.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends MongoRepository<Company,String> {

    Company findCompanyByMatriculate(String matriculate);

}

