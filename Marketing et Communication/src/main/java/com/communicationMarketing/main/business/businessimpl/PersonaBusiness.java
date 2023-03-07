package com.communicationMarketing.main.business.businessimpl;


import java.util.List;





import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.communicationMarketing.main.business.dtos.PersonaDTO;
import com.communicationMarketing.main.business.ibusiness.IPersonaBusiness;

import com.communicationMarketing.main.entity.Persona;
import com.communicationMarketing.main.repository.PersonnaRepository;

@Service

public class PersonaBusiness implements  IPersonaBusiness {
	
	    private final PersonnaRepository PersonnaRepository;
	    public PersonaBusiness(PersonnaRepository PersonnaRepository){
	        this.PersonnaRepository=PersonnaRepository;
	    }



		 @Override
			public ResponseEntity<Persona>  addpersona(PersonaDTO p)  throws ConstraintViolationException {
			
			 Persona   personaToPersist = new Persona();
					
				personaToPersist.setId(p.getId());
				
				personaToPersist.setAge(p.getAge());
				personaToPersist.setLocalisation(p.getLocalisation());
				personaToPersist.setMotivation(p.getMotivation());
				personaToPersist.setInterset(p.getInterset());
				personaToPersist.setInterset(p.getInterset());
				personaToPersist.setGender(p.getGender());
				personaToPersist.setJob(p.getJob());
				personaToPersist.setSituation(p.getSituation());
				personaToPersist.setTechnologie(p.getTechnologie());
				personaToPersist.setGoals(p.getGoals());
				personaToPersist.setSoftSkills(p.getSoftSkills());
				personaToPersist.setHardSkills(p.getHardSkills());
				personaToPersist.setDescription(p.getDescription());
				personaToPersist.setTitle(p.getTitle());
				personaToPersist.setNom(p.getNom());
				personaToPersist.setPrenom(p.getPrenom());
				personaToPersist.setEmail(p.getEmail());
				personaToPersist.setImage(p.getImage());
				personaToPersist.setArchive(false);
				personaToPersist.setDateofBirth(p.getDateofBirth());
				personaToPersist.setFrustrations(p.getFrustrations());
				personaToPersist.setPersonality(p.getPersonality());
				personaToPersist.setPhone(p.getPhone());
				personaToPersist.setLanguages(p.getLanguages());
				personaToPersist.setNumberOfChildren(p.getNumberOfChildren());
				personaToPersist.setAdresse(p.getAdresse());
				personaToPersist.setBio(p.getBio());
				personaToPersist.setNationality(p.getNationality());



				PersonnaRepository.save(personaToPersist);
					return ResponseEntity.status(HttpStatus.CREATED).body(personaToPersist);
				}
	    

	@Override
	public Persona updatepersona(Persona p) {
		
		 Optional<Persona> personaOptional= PersonnaRepository.findById(p.getId());
		 
		
	        return (personaOptional.isPresent() ?
	        		PersonnaRepository.save(p)
	                : null);
		
	}

	@Override
	public ResponseEntity<Persona> updatepersona(PersonaDTO personaDTO, String id) {
		return null;
	}

	@Override
	public ResponseEntity<String> deletepersona(String id) {
		   if(PersonnaRepository.findById(id).isPresent()){
			   PersonnaRepository.deleteById(id);
		            return new ResponseEntity<>("Persona  deleted Successfully!", HttpStatus.OK);
		        }
		        else{
		            return new ResponseEntity<>("Persona  not found", HttpStatus.NOT_FOUND);
		        }

	}

	@Override
	public List<Persona> getAllpersonas() {
		   return PersonnaRepository.findAll();
	}

	@Override
	public ResponseEntity<?> getpersonaByID(String id) {
		 Optional<Persona> gedData = PersonnaRepository.findById(id);
	        return gedData.map(g -> new ResponseEntity<>(g, HttpStatus.OK)).orElseGet(()
	                -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));	}

	@Override
	public long countpersonas() {
		   return PersonnaRepository.count();	}
	
	
	@Override
	public  Persona cancelArchivePersona(Persona p, String id)
	{
		Persona existedPersona = PersonnaRepository.findById(id).orElse(null);
		if (existedPersona != null) {
			existedPersona.setArchive(false);
			PersonnaRepository.save(existedPersona);
			return existedPersona;
		} else {
			return null;
		}
	}
	
	@Override   
	    public Persona archivePersona(Persona p, String id) 
	   {
		Persona existedPersona = PersonnaRepository.findById(id).orElse(null);
		if (existedPersona != null) {
			existedPersona.setArchive(true);
			PersonnaRepository.save(existedPersona);
			return existedPersona;
		} else {
			return null;
		}
	    }
	
	
	
	@Override
	public   List<Persona> findAllPersonaNomASC()
	{
        return PersonnaRepository.findAll(Sort.by("nom").ascending());

		
	}
	@Override
	public   List<Persona> findAllPersonaNomDESC()
	{
        return PersonnaRepository.findAll(Sort.by("nom").descending());
	
	}
	@Override
	public    List<Persona> findAllPersonaPrenomASC()
	{
        return PersonnaRepository.findAll(Sort.by("prenom").ascending());

		
	}
	@Override
	public     List<Persona> findAllPersonaPrenomDESC()
	{
        return PersonnaRepository.findAll(Sort.by("prenom").ascending());

		
	}

}

