package com.manazellocrm.customermanagement.business.businessimpl;

import com.manazellocrm.customermanagement.business.dtos.CustomerDTO;
import com.manazellocrm.customermanagement.business.ibusiness.ICustomerBusiness;
import com.manazellocrm.customermanagement.entities.Customer;
import com.manazellocrm.customermanagement.repositories.CustomerRepository;
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
public class CustomerBusiness implements ICustomerBusiness {



   private static final Logger logger = LoggerFactory.getLogger(CustomerBusiness.class);
    private final CustomerRepository customerRepository;
    private final RestTemplate rest;



    @Override
    public ResponseEntity<Customer> addCustomer(CustomerDTO customerDTO, String idEmployee) {
  try {

    Date date = new Date();
    Instant instanceNow = date.toInstant();
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
      HttpEntity<String> entity = new HttpEntity<>(headers);
      Object employee= rest.exchange("https://employees-hcm-manazello.herokuapp.com/employee/findbyid/"+idEmployee, HttpMethod.GET,
              entity, Object.class).getBody();
       Customer customerToPersist = new Customer();
        customerToPersist.setName(customerDTO.getName());
        customerToPersist.setMatriculateFiscal(customerDTO.getMatriculateFiscal());
        customerToPersist.setImage(customerDTO.getImage());
        customerToPersist.setStatus(customerDTO.getStatus());
        customerToPersist.setModifiedAt(instanceNow);
        customerToPersist.setSecondPhone(customerDTO.getSecondPhone());
        customerToPersist.setContactType(customerDTO.getContactType());
        customerToPersist.setGender(customerDTO.getGender());
        customerToPersist.setOtherGender(customerDTO.getOtherGender());
        customerToPersist.setDateOfBirth(customerDTO.getDateOfBirth());
        customerToPersist.setTitle(customerDTO.getTitle());
        customerToPersist.setDescription(customerDTO.getDescription());
        customerToPersist.setCountry(customerDTO.getCountry());
        customerToPersist.setCity(customerDTO.getCity());
        customerToPersist.setPostalCode(customerDTO.getPostalCode());
        customerToPersist.setWorkEmail(customerDTO.getWorkEmail());
        customerToPersist.setSecondEmail(customerDTO.getSecondEmail());
        customerToPersist.setWorkWebsite(customerDTO.getWorkWebsite());
        customerToPersist.setPhone(customerDTO.getPhone());
        customerToPersist.setLinkedinUrl(customerDTO.getLinkedinUrl());
      assert employee != null;
      customerToPersist.setAssignee(employee);
        customerToPersist.setActive(customerDTO.isActive());
        customerToPersist.setCreatedAt(instanceNow);
        customerToPersist.setUser(customerDTO.getUser());
        customerToPersist.setAddress(customerDTO.getAddress());
        customerToPersist.setArchive("False");
    customerRepository.save(customerToPersist);
      String message = "Customer added to DATABASE : " + customerToPersist;
      logger.info(message);
    return ResponseEntity.status(HttpStatus.CREATED).body(customerToPersist);}
  catch (Exception e){
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
 }
    }


    @Override
    @Transactional
    public Customer updateCustomer(Customer customer, String idEmployee) {
        Optional<Customer> customerOptional= customerRepository.findById(customer.getId());
       Date date= new Date();
       Instant dateToUpdate= date.toInstant();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        Object employee= rest.exchange("https://employees-hcm-manazello.herokuapp.com/employee/findbyid/"+idEmployee, HttpMethod.GET,
                entity, Object.class).getBody();
       customer.setModifiedAt(dateToUpdate);
        assert employee != null;
       customer.setAssignee(employee);
        return (customerOptional.isPresent() ?
                customerRepository.save(customer)
                : null);
    }


    @Override
    public Customer updateCustomerStatusAsClient(Customer customer, String id) {
        Optional<Customer> customerOptional= customerRepository.findById(id);
        Date date= new Date();
        Instant dateToUpdate= date.toInstant();
        customer.setModifiedAt(dateToUpdate);
        customer.setStatus("Client");
        return (customerOptional.isPresent() ?
                customerRepository.save(customer)
                : null);
    }

    @Override
    public Customer cancelArchiveClient(Customer customer, String id) {
        Optional<Customer> customerDeArchive= customerRepository.findById(id);
        Date date= new Date();
        Instant dateToUpdate= date.toInstant();
        customer.setModifiedAt(dateToUpdate);
        customer.setArchive("False");
        return (customerDeArchive.isPresent() ?
                customerRepository.save(customer)
                : null);
    }

    @Override
    public Customer archiveClient(Customer customer, String id) {
        Optional<Customer> customerDetails= customerRepository.findById(id);
        Date date= new Date();
        Instant dateToUpdate= date.toInstant();
        customer.setModifiedAt(dateToUpdate);
        customer.setArchive("True");
        return (customerDetails.isPresent() ?
                customerRepository.save(customer)
                : null);
    }

    @Override
    public ResponseEntity<String> deleteCustomer(String id) {
       if(customerRepository.findById(id).isPresent()){
            customerRepository.deleteById(id);
            return new ResponseEntity<>("Customer deleted Successfully!!",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    @Override
    public List<Customer> findNonArchivedCustomers(String archive) {
        return customerRepository.findCustomersByArchive(archive);
    }

    @Override
    public List<Customer> getClients() {
        return customerRepository.findCustomerByStatus("Client");
    }

    @Override
    public ResponseEntity<Customer> getCustomerByID(String id) {
        Optional<Customer> customerData = customerRepository.findById(id);
        return customerData.map(customer -> new ResponseEntity<>(customer, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }


    public long countCustomers (){
        return customerRepository.count();
    }

    @Override
    public List<Customer> findAllCustomerASC() {
        return customerRepository.findAll(Sort.by("name").ascending().and(Sort.by("created_at").descending()));
    }


    @Override
    public List<Customer> findAllCustomerDESC() {
        return customerRepository.findAll(Sort.by("name").descending().and(Sort.by("created_at").descending()));
    }

    @Override
    public List<Customer> findAllCustomerD() {

        List<Customer> customers= new ArrayList<>();
        List<Customer> clients= customerRepository.findCustomerByStatus("Client");
        List<Customer> leads= customerRepository.findCustomerByStatus("Lead");
        customers.addAll(new ArrayList(Arrays.asList(clients,leads)));
        return customers;
    }


    @Override
    public Customer updateCustomerStatusAsLead(Customer customer, String id) {
        Optional<Customer> customerOptional= customerRepository.findById(id);
        Date date= new Date();
        Instant dateToUpdate= date.toInstant();
        customer.setModifiedAt(dateToUpdate);
        customer.setStatus("Lead");
        return (customerOptional.isPresent() ?
                customerRepository.save(customer)
                : null);
    }

    @Override
    public List<Customer> findProspects(String status,String archive) {
        return customerRepository.findCustomerByStatusAndArchive(status, archive);
    }

    @Override
    public List<Customer> getProspectsCreatedAtDesc(String status, String archive) {
        return customerRepository.findCustomersByStatusAndArchiveOrderByCreatedAtDesc(status, archive);
    }

    @Override
    public List<Customer> getProspectsNameDesc(String status, String archive) {
        return customerRepository.findCustomersByStatusAndArchiveOrderByNameDesc(status, archive);
    }

    @Override
    public List<Customer> getProspectsNameAsc(String status,String archive) {
        return customerRepository.findCustomersByStatusAndArchiveOrderByNameAsc(status, archive);
    }

    @Override
    public List<Customer> getCustomersByBirthDate() {

        Date date = new Date();

        return customerRepository.findByCustomQuery(date.getDay()+3,date.getMonth()+1);
    }


}

