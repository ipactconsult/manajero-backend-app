package com.communicationMarketing.main.business.ibusiness;

import java.util.List;




import org.springframework.http.ResponseEntity;

import com.communicationMarketing.main.business.dtos.PersonaDTO;
import com.communicationMarketing.main.entity.Event;
import com.communicationMarketing.main.entity.Parternership;
import com.communicationMarketing.main.entity.Persona;

public interface IPersonaBusiness {
	   ResponseEntity<Persona> addpersona (PersonaDTO p);
	   Persona updatepersona (Persona p);
	   ResponseEntity<Persona> updatepersona(PersonaDTO personaDTO, String id);
	   ResponseEntity<String> deletepersona (String id);
	   List<Persona> getAllpersonas ();
	   ResponseEntity<?> getpersonaByID(String id);
	   long countpersonas();
	   Persona cancelArchivePersona(Persona p, String id);
	    public Persona archivePersona(Persona p, String id) ;  
	    List<Persona> findAllPersonaNomASC();
        List<Persona> findAllPersonaNomDESC();
        List<Persona> findAllPersonaPrenomASC();
        List<Persona> findAllPersonaPrenomDESC();

}
