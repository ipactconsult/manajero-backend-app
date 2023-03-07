package com.employees.main.business.businessimpl;

import com.employees.main.business.dto.ContractDTO;
import com.employees.main.business.ibusiness.IContractBusiness;
import com.employees.main.entities.Contract;
import com.employees.main.entities.Employee;
import com.employees.main.repositories.ContractRepository;
import com.employees.main.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContractBusiness implements IContractBusiness {

    private final ContractRepository contractRepository;
    private final EmployeeRepository employeeRepository;

    final ModelMapper mapper;

    public ContractBusiness(ContractRepository contractRepository, EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.contractRepository = contractRepository;
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public Contract createContract(ContractDTO contractDTO) {
        Contract contract = new Contract(
                contractDTO.getId(),
                contractDTO.getContractType(),
                contractDTO.getHiringDate(),
                contractDTO.getEndDate(),
                contractDTO.getNoticePeriod(),
                contractDTO.getStatus(),
                contractDTO.getOfficialSignature(),
                contractDTO.getDurationOfTrialPeriod(),
                contractDTO.getStartTime(),
                contractDTO.getEndDate().getYear() - contractDTO.getOfficialSignature().getYear(),
                contractDTO.getNbOfHoursWorkedPerDay(),
                contractDTO.getNbOfWeeklyWorkingHours(),
                contractDTO.getHourlyWorkRate(),
                contractDTO.getDailyCost(),
                contractDTO.getHourlyDistribution(),
                contractDTO.getCompanyName(),
                contractDTO.getCompanyAddress(),
                contractDTO.getWorkAddress(),
                contractDTO.getJob(),
                contractDTO.getBonusCoef(),
                contractDTO.getGrossHourlyWage(),
                contractDTO.getMinimumMonthlySalary(),
                contractDTO.getGrossAnnualSalary(),
                contractDTO.getOverallMonthlyCost(),
                contractDTO.getEmployee(),
                "No",
                contractDTO.getUser()
        );
        return contractRepository.save(contract);
    }

    @Override
    public Contract assignContractEmployee(ContractDTO contractDTO, String id) {
        Contract c = this.mapper.map(contractDTO, Contract.class);
        Optional<Employee> getEmployee = employeeRepository.findById(id);
        c.setEmployee(getEmployee.get());
        return contractRepository.save(c);
    }

    @Override
    public List<Contract> findAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public List<Contract> findAllContractSortingByHiringDateAsc() {
        return contractRepository.findAll(Sort.by("hiringDate").ascending());
    }

    @Override
    public List<Contract> findAllContractSortingByHiringDateDesc() {
        return contractRepository.findAll(Sort.by("hiringDate").descending());
    }

    @Override
    public List<Contract> findAllContractSortingByEndDateAsc() {
        return contractRepository.findAll(Sort.by("endDate").ascending());
    }

    @Override
    public List<Contract> findAllContractSortingByEndDateDesc() {
        return contractRepository.findAll(Sort.by("endDate").descending());
    }

    @Override
    public List<Contract> findAllContractSortingByOfficialSignatureAsc() {
        return contractRepository.findAll(Sort.by("officialSignature").ascending());
    }

    @Override
    public List<Contract> findAllContractSortingByOfficialSignatureDesc() {
        return contractRepository.findAll(Sort.by("officialSignature").descending());
    }

    @Override
    public List<Contract> findAllContractSortingByGrossAnualSalaryAsc() {
        return contractRepository.findAll(Sort.by("GrossAnnualSalary").ascending());
    }

    @Override
    public List<Contract> findAllContractSortingByGrossAnualSalaryDesc() {
        return contractRepository.findAll(Sort.by("GrossAnnualSalary").descending());
    }

    @Override
    public Contract updateContract(ContractDTO contractDTO, String id) {
        Contract c = this.mapper.map(contractDTO, Contract.class);
        Optional<Contract> editContract = contractRepository.findById(id);
        return (editContract.isPresent()?contractRepository.save(c):null);
    }

    @Override
    public Contract archiveContract(ContractDTO contractDTO, String id) {
        Contract c = this.mapper.map(contractDTO, Contract.class);
        Optional<Contract> archiveContract = contractRepository.findById(id);
        c.setIsArchived("Yes");
        return (archiveContract.isPresent()? contractRepository.save(c): null);
    }

    @Override
    public Contract getContract(String id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Contract restoreContract(ContractDTO contractDTO, String id) {
        Contract c = this.mapper.map(contractDTO, Contract.class);
        Optional<Contract> archiveContract = contractRepository.findById(id);
        c.setIsArchived("No");
        return (archiveContract.isPresent()? contractRepository.save(c): null);
    }

    @Override
    public String deleteContract(String id) {
        contractRepository.deleteById(id);
        return "deleted";
    }
}
