package com.manazellocrm.customermanagement.repositories;

import com.manazellocrm.customermanagement.entities.Contract;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContractRepository extends MongoRepository<Contract,String> {



    List<Contract> findContractsByArchive(String archive);
}
