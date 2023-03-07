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

import com.communicationMarketing.main.business.dtos.PersonaDTO;
import com.communicationMarketing.main.business.ibusiness.IPersonaBusiness;
import com.communicationMarketing.main.entity.Event;
import com.communicationMarketing.main.entity.Parternership;
import com.communicationMarketing.main.entity.Persona;

@RequestMapping(path = { "/Persona" }, produces = APPLICATION_JSON_VALUE)
@RestController
public class PersonaControlleur {
	
	

	@Autowired
	private  IPersonaBusiness IPersonaBusiness;

    public PersonaControlleur(IPersonaBusiness IPersonaBusiness){
        this.IPersonaBusiness=IPersonaBusiness;
    }

    @PostMapping("/add")
    public ResponseEntity<Persona> addPersona (@Valid @RequestBody PersonaDTO personaDTO){
        return IPersonaBusiness.addpersona(personaDTO);
    }
    
    
    
    @GetMapping("/allPersonas")
    public ResponseEntity<List<Persona>> findAllPersonas(){
        List<Persona> rows = IPersonaBusiness.getAllpersonas();
        return new ResponseEntity <>(rows, HttpStatus.OK);
    }

    

    @PutMapping("/update-Persona")
    public Persona updatePersona(@RequestBody Persona p){
        return IPersonaBusiness.updatepersona(p); 
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePersona(@PathVariable("id") String id){
        return IPersonaBusiness.deletepersona(id);
    }

    
    @GetMapping("/Persona-by-id/{id}")
    public ResponseEntity<?> getPersonaByID (@PathVariable("id") String id){
        return IPersonaBusiness.getpersonaByID(id);
    }


    @GetMapping("/count-Persona")
    public long countEvents(){
        return IPersonaBusiness.countpersonas();
    }
    
    
    @PutMapping("/archive-Persona/{id}")
    public Persona archivePersona(@RequestBody Persona p, @PathVariable("id") String id){
        return IPersonaBusiness.archivePersona(p, id);
    }

    @PutMapping("/cancelArchive-Persona/{id}")
    public Persona cancelArchivePersona(@RequestBody Persona p, @PathVariable("id") String id){
        return IPersonaBusiness.cancelArchivePersona(p, id);
    }

    @GetMapping( "/descending")
    public ResponseEntity<List<Persona>> listPersonaDesc(){
        return new ResponseEntity<>(IPersonaBusiness.findAllPersonaNomDESC(), HttpStatus.OK);
    }
    @GetMapping( "/ascending")
    public ResponseEntity<List<Persona>> listPersonaAsc(){
        return new ResponseEntity<>(IPersonaBusiness.findAllPersonaNomASC(), HttpStatus.OK);
    }
   
    @GetMapping( "/descendingPrenom")
    public ResponseEntity<List<Persona>> listPersonaPrenomDesc(){
        return new ResponseEntity<>(IPersonaBusiness.findAllPersonaPrenomDESC(), HttpStatus.OK);
    }
    @GetMapping( "/ascendingPrenom")
    public ResponseEntity<List<Persona>> listPersonaPrenomAsc(){
        return new ResponseEntity<>(IPersonaBusiness.findAllPersonaPrenomASC(), HttpStatus.OK);
    }


}
