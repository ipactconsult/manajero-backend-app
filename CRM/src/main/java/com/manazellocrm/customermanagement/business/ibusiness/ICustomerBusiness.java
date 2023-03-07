package com.manazellocrm.customermanagement.business.ibusiness;

import com.manazellocrm.customermanagement.entities.Customer;
import com.manazellocrm.customermanagement.business.dtos.CustomerDTO;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ICustomerBusiness {

// -------------------------------- CLIENTS MANAGEMENT --------------------------------

    ResponseEntity<Customer> addCustomer (@Valid CustomerDTO customerDTO,  String idEmployee);

    Customer updateCustomer (Customer customer, String idEmployee);
    Customer updateCustomerStatusAsClient (Customer customer, String id);

    Customer archiveClient(Customer customer, String id);
    Customer cancelArchiveClient(Customer customer, String id);

    ResponseEntity<String> deleteCustomer (String id);

    List<Customer> getAllCustomers ();
    ResponseEntity<Customer> getCustomerByID(String id);

    long countCustomers();
    List<Customer> findAllCustomerD();
    List<Customer> findAllCustomerASC();
    List<Customer> findAllCustomerDESC();

    List<Customer> findNonArchivedCustomers(String archive);
    List<Customer> getClients();

    // ------------------------------- PROSPECTS MANAGEMENT -------------------------------

    Customer updateCustomerStatusAsLead (Customer customer, String id);

    List<Customer> findProspects(String status,String archive);

    List<Customer> getProspectsCreatedAtDesc(String status, String archive);


    List<Customer> getProspectsNameDesc(String status, String archive);
    List<Customer> getProspectsNameAsc(String status, String archive);


    List<Customer> getCustomersByBirthDate() throws ParseException;



}
