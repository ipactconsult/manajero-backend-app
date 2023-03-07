package com.example.litigerecouvrement.controller;

import com.example.litigerecouvrement.dto.RelanceDTO;
import com.example.litigerecouvrement.dto.RelanceRequestDTO;
import com.example.litigerecouvrement.entites.Invoice;
import com.example.litigerecouvrement.entites.Mail;
import com.example.litigerecouvrement.entites.Relance;
import com.example.litigerecouvrement.ibusniess.RelanceIBusiness;
import org.modelmapper.ModelMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path= {"/relance"}, produces= APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class RelanceContoller {
    private final ModelMapper modelMapper;
    final RestTemplate rest;


    final RelanceIBusiness bcc ;
    public RelanceContoller(ModelMapper modelMapper, RestTemplate rest, RelanceIBusiness bcc){
        this.modelMapper = modelMapper;
        this.rest = rest;

        this.bcc=bcc ;
    }






    @PostMapping("/add")
    public Relance createRelance(@RequestBody RelanceRequestDTO relance){


        Relance re = modelMapper.map(relance, Relance.class);


        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);


        Invoice invoice= rest.exchange("https://accounting-erp.herokuapp.com/invoice/getbyid/"+relance.getInvoice(), HttpMethod.GET,
                entity, Invoice.class).getBody();
        Instant date =invoice.getDueDate();
        System.out.println(date);
        Instant instant =Instant.parse( ""+date.plus(5, ChronoUnit.DAYS));
        System.out.println(instant);
        re.setPremierrelance(instant);


        re.setInvoice(invoice);
        return bcc.createRelance(re);


    }

    @GetMapping("/allrelances/{ar}/{clo}")
    public ResponseEntity<List<Relance>> findAll(@PathVariable String ar,@PathVariable Boolean clo){
        return new ResponseEntity<>(bcc.findAllRelances(ar,clo), HttpStatus.OK);
    }
    @GetMapping("/getemail/{id}")
    public ResponseEntity<List<Mail>> findEmailbyRelance(@PathVariable String id){
        return new ResponseEntity<>(bcc.findEmailbyRelance(id), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public Relance editAction(@PathVariable("id") String id, @RequestBody RelanceDTO relancedto)
    {
        Relance relance = modelMapper.map(relancedto, Relance.class);


        return bcc.updateRelance(id,relance);
    }




    @GetMapping ("/mailings")
    public void relanceMail (){
        bcc.sendMail();
    }


    @DeleteMapping( "/delete/{id}")
    public String deleteRelance(@PathVariable String id) {
        return bcc.deleteRelance(id);
    }

    @GetMapping( "/findbyid/{id}")
    public ResponseEntity<Relance> getRelanceyid(@PathVariable("id") String id)
    {
         Relance relance =bcc.findByid(id);
         return (relance!=null)?
        new ResponseEntity<>(relance,HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




}

