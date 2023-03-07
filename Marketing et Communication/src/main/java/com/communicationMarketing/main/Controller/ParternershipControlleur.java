package com.communicationMarketing.main.Controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;



import java.util.List;
import java.util.Properties;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communicationMarketing.main.business.dtos.ParternershipDTO;
import com.communicationMarketing.main.business.ibusiness.IParternershipBusiness;
import com.communicationMarketing.main.entity.MailService;
import com.communicationMarketing.main.entity.Parternership;
import com.communicationMarketing.main.entity.Usemail;




@RequestMapping(path = { "/Parternership" }, produces = APPLICATION_JSON_VALUE)
@RestController
public class ParternershipControlleur {
	
	
	@Autowired
	private  IParternershipBusiness IParternershipBusiness;
	
	private JavaMailSender javaMailSender;
	@Autowired
	private MailService notificationService;
	@Autowired
	private Usemail user;
	
	/*************************************************/


    public ParternershipControlleur(IParternershipBusiness IParternershipBusiness){
        this.IParternershipBusiness=IParternershipBusiness;
    }

    
    @PostMapping("/add")
    public ResponseEntity<Parternership> addParternership (@Valid @RequestBody ParternershipDTO ParternershipDTO){
    
    /*

        String host = "smtp.gmail.com";

 
    	
    	user.setEmailAddress("nesrinetry@gmail.com");  //Receiver's email address
	
		try {
			notificationService.sendEmail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}*/
    	
	
    	return IParternershipBusiness.addParternership(ParternershipDTO);
    	
    	
    }
    
    
    
    @GetMapping("/allParternerships")
    public ResponseEntity<List<Parternership>> findAllParternerships(){
        List<Parternership> rows = IParternershipBusiness.getAllParternerships();
        return new ResponseEntity <>(rows, HttpStatus.OK);
    }

    

    @PutMapping("/update-Parternership")
    public Parternership updateParternership(@RequestBody Parternership p){
        return IParternershipBusiness.updateParternership(p); 
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteParternership(@PathVariable("id") String id){
        return IParternershipBusiness.deleteParternership(id);
    }

    
    @GetMapping("/idParternership-by-id/{id}")
    public ResponseEntity<?> getidParternershipByID (@PathVariable("id") String id){
        return IParternershipBusiness.getParternershipByID(id);
    }


    @GetMapping("/count-Parternerships")
    public long countEvents(){
        return IParternershipBusiness.countParternerships();
    }

    
    @GetMapping( "/descending")
    public ResponseEntity<List<Parternership>> listPartnerDesc(){
        return new ResponseEntity<>(IParternershipBusiness.findAllPartnerDESC(), HttpStatus.OK);
    }
    @GetMapping( "/ascending")
    public ResponseEntity<List<Parternership>> listPartnerrAsc(){
        return new ResponseEntity<>(IParternershipBusiness.findAllPartnerASC(), HttpStatus.OK);
    }


    @PutMapping("/archive-partner/{id}")
    public Parternership archiveClient(@RequestBody Parternership p, @PathVariable("id") String id){
        return IParternershipBusiness.archiveParternership(p, id);
    }

    @PutMapping("/cancelArchive-partner/{id}")
    public Parternership cancelArchiveClient(@RequestBody Parternership p, @PathVariable("id") String id){
        return IParternershipBusiness.cancelArchivePartner(p, id);
    }




}
