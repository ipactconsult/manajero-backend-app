package com.communicationMarketing.main.Controller;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;




import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communicationMarketing.main.business.dtos.GEDDTO;
import com.communicationMarketing.main.business.ibusiness.*;
import com.communicationMarketing.main.entity.Event;
import com.communicationMarketing.main.entity.GED;


@RequestMapping(path = { "/GED" }, produces = APPLICATION_JSON_VALUE)
@RestController
public class GEDControlleur {
	
	@Autowired
	private  IGEDBusiness IGEDBusiness;

    public GEDControlleur(IGEDBusiness IGEDBusiness){
        this.IGEDBusiness=IGEDBusiness;
    
    }

    @PostMapping(value="/add")
    	    
    public ResponseEntity<GED> addGEd (@Valid @RequestBody GEDDTO GEDDTO ){
    	 
    	
        return IGEDBusiness.addGED(GEDDTO );
    }

    @GetMapping("/allGEDs")
    public ResponseEntity<List<GED>> findAllGEDs(){
        List<GED> rows = IGEDBusiness.getAllGEDs();
        return new ResponseEntity <>(rows, HttpStatus.OK);
    }

    

    @PutMapping("/update-GED")
    public GED updateGED(@RequestBody GED ged){
        return IGEDBusiness.updateGED(ged); 
    }


    @DeleteMapping("/delete/{id}")
    public GED deleteGED(@PathVariable String id){
        return IGEDBusiness.deleteGED(id);
    }

   @GetMapping("/GED-by-id/{id}")
    public ResponseEntity<?> getGEDByID (@PathVariable("id") String id){
        return IGEDBusiness.getGEDByID(id);
    }


    @GetMapping("/count-Events")
    public long countEvents(){
        return IGEDBusiness.countGEDs(); 
    }


    
    @PutMapping("/update/{id}")
	public ResponseEntity<GED> updateProblematic(@PathVariable("id") String  id ,@RequestBody GEDDTO gedDTO){
	
			return IGEDBusiness.updateGED(gedDTO, id);
	}
    
    
    
    @PutMapping("/archive-GED/{id}")
    public GED archiveGED(@RequestBody GED g, @PathVariable("id") String id){
        return IGEDBusiness.cancelArchiveGED(g, id);
    }

    @PutMapping("/cancelArchive-GED/{id}")
    public GED cancelArchiveGED(@RequestBody GED g, @PathVariable("id") String id){
        return IGEDBusiness.archiveGED(g, id);
    }
    
   
    
    
    
}
