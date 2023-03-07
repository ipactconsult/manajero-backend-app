package com.manazellocrm.customermanagement.controllers;

import com.manazellocrm.customermanagement.business.ibusiness.ICustomerBusiness;
import com.manazellocrm.customermanagement.entities.Customer;
import com.manazellocrm.customermanagement.business.dtos.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import java.text.ParseException;
import java.util.List;

@RequestMapping(path = { "/api/customer" }, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class CustomerController {

    ICustomerBusiness iCustomerBusiness;
    public CustomerController(ICustomerBusiness iCustomerBusiness){
        this.iCustomerBusiness=iCustomerBusiness;
    }


    @PostMapping("/add/{idEmployee}")
    public ResponseEntity<Customer> addCustomer (@Valid @RequestBody CustomerDTO customerDTO, @PathVariable("idEmployee")  String idEmployee){
        return iCustomerBusiness.addCustomer(customerDTO,idEmployee );
    }

    @GetMapping("/allCustomers")
    public ResponseEntity<List<Customer>> findAllCustomers(){
        List<Customer> rows = iCustomerBusiness.getAllCustomers();
            return new ResponseEntity <>(rows, HttpStatus.OK);
    }

    @PutMapping("/update-customer/{idEmployee}")
    public Customer updateCustomer(@RequestBody Customer customer,@PathVariable("idEmployee") String idEmployee){
        return iCustomerBusiness.updateCustomer(customer,idEmployee);
    }

    @PutMapping("/archive-client/{id}")
    public Customer archiveClient(@RequestBody Customer customer, @PathVariable("id") String id){
        return iCustomerBusiness.archiveClient(customer,id);
    }

    @PutMapping("/cancel-archive-client/{id}")
    public Customer cancelArchiveClient(@RequestBody Customer customer, @PathVariable("id") String id){
        return iCustomerBusiness.cancelArchiveClient(customer,id);
    }


    @PutMapping("/update-customer-as-client/{id}")
    public Customer updateCustomerStatusAsClient(@RequestBody Customer customer, @PathVariable("id") String id){
        return iCustomerBusiness.updateCustomerStatusAsClient(customer,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") String id){
        return iCustomerBusiness.deleteCustomer(id);
    }

    @GetMapping("/customer-by-id/{id}")
    public ResponseEntity<Customer> getCustomerByID (@PathVariable("id") String id){
        return iCustomerBusiness.getCustomerByID(id);
    }

    @GetMapping("/onlyClients")
    public List<Customer> getClients (){
        return iCustomerBusiness.getClients();
    }


    @GetMapping("/count-customers")
    public long countCustomers(){
        return iCustomerBusiness.countCustomers();
    }

    @GetMapping( "/all/descending")
    public ResponseEntity<List<Customer>> listCustomerDesc(){
        return new ResponseEntity<>(iCustomerBusiness.findAllCustomerDESC(), HttpStatus.OK);
    }
    @GetMapping( "/all/ascending")
    public ResponseEntity<List<Customer>> listCustomerAsc(){
        return new ResponseEntity<>(iCustomerBusiness.findAllCustomerASC(), HttpStatus.OK);
    }

    @GetMapping( "/non-archived-customers/{archive}")
    public ResponseEntity<List<Customer>> findNonArchivedCustomers(@PathVariable("archive") String archive){
        return new ResponseEntity<>(iCustomerBusiness.findNonArchivedCustomers(archive), HttpStatus.OK);
    }


    @PutMapping("/update-customer-as-lead/{id}")
    public Customer updateCustomerStatusAsLead(@RequestBody Customer customer, @PathVariable("id") String id){
        return iCustomerBusiness.updateCustomerStatusAsLead(customer,id);
    }

    @GetMapping("/customer-by-status/{status}/{archive}")
    public List<Customer> findProspects (@PathVariable("status") String status,@PathVariable("archive") String archive){
        return iCustomerBusiness.findProspects(status, archive);
    }

    @GetMapping("/customer-by-desc-created/{status}/{archive}")
    public List<Customer> findProspectsCreatedDesc (@PathVariable("status") String status,@PathVariable("archive") String archive){
        return iCustomerBusiness.getProspectsCreatedAtDesc(status,archive);
    }

    @GetMapping("/customer-by-desc-name/{status}/{archive}")
    public List<Customer> findProspectsNameDesc (@PathVariable("status") String status,@PathVariable("archive") String archive){
        return iCustomerBusiness.getProspectsNameDesc(status,archive);
    }
    @GetMapping("/customer-by-asc-name/{status}/{archive}")
    public List<Customer> findProspectsNameAsc (@PathVariable("status") String status,@PathVariable("archive") String archive){
        return iCustomerBusiness.getProspectsNameAsc(status, archive);
    }

    @GetMapping("/customer-by-birth")
    public List<Customer> findCustomerByBirth () throws ParseException {
        return iCustomerBusiness.getCustomersByBirthDate();
    }




}
