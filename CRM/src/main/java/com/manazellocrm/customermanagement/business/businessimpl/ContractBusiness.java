package com.manazellocrm.customermanagement.business.businessimpl;

import com.manazellocrm.customermanagement.business.ibusiness.IContractBusiness;
import com.manazellocrm.customermanagement.entities.Contract;
import com.manazellocrm.customermanagement.repositories.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class ContractBusiness implements IContractBusiness {
    private static final Logger logger = LoggerFactory.getLogger(ContractBusiness.class);
    private final ContractRepository contractRepository;
    private final RestTemplate rest;

    @Override
    public Contract addContract(Contract contract) {

            Date date = new Date();
            Instant instanceNow = date.toInstant();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>(headers);
            Object laws= rest.exchange("https://recovery-dispute.herokuapp.com/lois/allcategories/625ffe7503c0267c21b105a7", HttpMethod.GET,
                    entity, Object.class).getBody();
                contract.setLaws(laws);
                contract.setArchive("False");
                contract.setCreatedAt(instanceNow);
            contractRepository.save(contract);
            String message = "DONE ! Contract added to DATABASE : " + contract;
            logger.info(message);
            return contract;
    }

    @Override
    public Contract addContractCustomized(Contract contract) {

        return contractRepository.save(contract);
    }


    @Override
    public Contract updateContract(Contract contract, String id) {
        Optional<Contract> contractOptional= contractRepository.findById(id);
        Date date= new Date();
       int calculateDuration=contract.getDateFin().getDate() - contract.getDateContract().getDate();
        Instant dateToUpdate= date.toInstant();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        Object laws= rest.exchange("https://recovery-dispute.herokuapp.com/lois/allcategories/625ffe7503c0267c21b105a7", HttpMethod.GET,
                entity, Object.class).getBody();
        contract.setModifiedAt(dateToUpdate);
        contract.setLaws(laws);
        contract.setDuration(calculateDuration);
        return (contractOptional.isPresent() ?
                contractRepository.save(contract)
                : null);
    }

    @Override
    public ResponseEntity<String> deleteContract(String id) {
        if(contractRepository.findById(id).isPresent()){
            contractRepository.deleteById(id);
            return new ResponseEntity<>("Contract deleted Successfully!", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Contract not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }


   @Override
    public List<Contract> getAllContractsNonArchived(String archive) {

        return contractRepository.findContractsByArchive(archive);
    }

   @Override
    public List<Contract> getAllContractsArchived() {

        return contractRepository.findContractsByArchive("True");
    }


    @Override
    public ResponseEntity<Contract> getContractByID(String id) {

        Optional<Contract> contractData = contractRepository.findById(id);
        return contractData.map(contract -> new ResponseEntity<>(contract, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @Override
    public long countContracts() {
        return contractRepository.count();
    }

    @Override
    public List<Contract> findAllContractDESC() {

        return contractRepository.findAll(Sort.by("contractName").descending().and(Sort.by("created_at").descending()));
    }

    @Override
    public List<Contract> findAllContractASC() {

        return contractRepository.findAll(Sort.by("contractName").descending().and(Sort.by("created_at").ascending()));
    }



    @Override
    public Contract archiveContract(Contract contract, String id) {
        Optional<Contract> contractDetails= contractRepository.findById(id);
        Date date= new Date();
        Instant dateToUpdate= date.toInstant();
        contract.setModifiedAt(dateToUpdate);
        contract.setArchive("True");
        return (contractDetails.isPresent() ?
                contractRepository.save(contract)
                : null);
    }

    @Override
    public Contract cancelArchiveContract(Contract contract, String id) {
        Optional<Contract> contractDetails= contractRepository.findById(id);
        Date date= new Date();
        Instant dateToUpdate= date.toInstant();
        contract.setModifiedAt(dateToUpdate);
        contract.setArchive("False");
        return (contractDetails.isPresent() ?
                contractRepository.save(contract)
                : null);
    }


}
