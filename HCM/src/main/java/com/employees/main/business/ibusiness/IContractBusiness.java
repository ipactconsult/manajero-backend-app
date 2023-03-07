package com.employees.main.business.ibusiness;

import com.employees.main.business.dto.ContractDTO;
import com.employees.main.entities.Contract;

import java.util.List;

public interface IContractBusiness {

    Contract createContract(ContractDTO contractDTO);
    Contract assignContractEmployee(ContractDTO contractDTO, String id);
    List<Contract> findAllContracts();
    List<Contract> findAllContractSortingByHiringDateAsc();
    List<Contract> findAllContractSortingByHiringDateDesc();
    List<Contract> findAllContractSortingByEndDateAsc();
    List<Contract> findAllContractSortingByEndDateDesc();

    List<Contract> findAllContractSortingByOfficialSignatureAsc();
    List<Contract> findAllContractSortingByOfficialSignatureDesc();
    List<Contract> findAllContractSortingByGrossAnualSalaryAsc();
    List<Contract> findAllContractSortingByGrossAnualSalaryDesc();
    Contract updateContract(ContractDTO contractDTO, String id);
    Contract archiveContract(ContractDTO contractDTO, String id);
    Contract getContract(String id);
    Contract restoreContract(ContractDTO contractDTO,String id);
    String deleteContract(String id);
}
