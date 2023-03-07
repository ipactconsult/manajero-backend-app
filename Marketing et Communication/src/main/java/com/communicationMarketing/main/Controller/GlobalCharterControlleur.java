package com.communicationMarketing.main.Controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communicationMarketing.main.business.dtos.GlobalCharterDTO;
import com.communicationMarketing.main.business.ibusiness.IGlobalCharterDTOBusiness;
import com.communicationMarketing.main.entity.MailService;
import com.communicationMarketing.main.entity.GlobalCharter;
import com.communicationMarketing.main.entity.Usemail;

@RequestMapping(path = { "/GlobalCharter" }, produces = APPLICATION_JSON_VALUE)
@RestController
public class GlobalCharterControlleur {
	

	
	@Autowired
	private  IGlobalCharterDTOBusiness IGlobalCharterDTOBusiness;
	
	private JavaMailSender javaMailSender;
	@Autowired
	private MailService notificationService;
	@Autowired
	private Usemail user;
	
	/*************************************************/


    public GlobalCharterControlleur(IGlobalCharterDTOBusiness IGlobalCharterDTOBusiness){
        this.IGlobalCharterDTOBusiness=IGlobalCharterDTOBusiness;
    }

    
    @PostMapping("/add")
    public ResponseEntity<GlobalCharter> addGlobalChart (@Valid @RequestBody GlobalCharterDTO GlobalCharterDTO){
    
    /*

        String host = "smtp.gmail.com";

 
    	
    	user.setEmailAddress("nesrinetry@gmail.com");  //Receiver's email address
	
		try {
			notificationService.sendEmail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}*/
    	
	
    	return IGlobalCharterDTOBusiness.addGlobalCharter(GlobalCharterDTO);
    	
    	
    }
    
    
    
    @GetMapping("/all")
    public ResponseEntity<List<GlobalCharter>> findAllGlobalCharters(){
        List<GlobalCharter> rows = IGlobalCharterDTOBusiness.getAllGlobalCharters();
        return new ResponseEntity <>(rows, HttpStatus.OK);
    }

    

    @PutMapping("/update")
    public GlobalCharter updateGlobalCharter(@RequestBody GlobalCharter p){
        return IGlobalCharterDTOBusiness.updateGlobalCharter(p); 
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleterGlobalCharter(@PathVariable("id") String id){
        return IGlobalCharterDTOBusiness.deleteGlobalCharter(id);
    }

    
    @GetMapping("/GlobalCharter-by-id/{id}")
    public ResponseEntity<?> getGlobalCharterByID (@PathVariable("id") String id){
        return IGlobalCharterDTOBusiness.getGlobalCharterByID(id);
    }


    @GetMapping("/count-GlobalCharters")
    public long countGlobalCharters(){
        return IGlobalCharterDTOBusiness.countGlobalCharters();
        
    }
    
    @PutMapping("/archive-GlobalCharter/{id}")
    public GlobalCharter archiveGlobalCharter(@RequestBody GlobalCharter p, @PathVariable("id") String id){
        return IGlobalCharterDTOBusiness.archiveGlobalCharter(p, id);
    }

    @PutMapping("/cancelArchive-GlobalCharter/{id}")
    public GlobalCharter cancelArchiveGlobalCharter(@RequestBody GlobalCharter p, @PathVariable("id") String id){
        return IGlobalCharterDTOBusiness.cancelArchiveGlobalCharter(p, id);
    }




 


}
