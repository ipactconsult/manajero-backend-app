package com.manazellocrm.customermanagement.business.ibusiness;

import com.manazellocrm.customermanagement.entities.Contract;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IContractBusiness {

    Contract addContract (Contract contract);
    Contract addContractCustomized (Contract contract);
    Contract updateContract (Contract contract, String id);
    ResponseEntity<String> deleteContract (String id);
    List<Contract> getAllContracts ();
    ResponseEntity<Contract> getContractByID(String id);
    long countContracts();
    List<Contract> findAllContractDESC();
    List<Contract> findAllContractASC();
    Contract archiveContract(Contract contract, String id);
    Contract cancelArchiveContract(Contract contract, String id);
    List<Contract> getAllContractsArchived();
    List<Contract> getAllContractsNonArchived(String archive);

}
