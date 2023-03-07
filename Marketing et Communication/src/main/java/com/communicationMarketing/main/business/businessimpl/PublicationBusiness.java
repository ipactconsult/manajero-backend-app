package com.communicationMarketing.main.business.businessimpl;

import java.util.List;




import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.communicationMarketing.main.business.dtos.EventDTO;
import com.communicationMarketing.main.business.dtos.PublicationDTO;
import com.communicationMarketing.main.business.ibusiness.IPublicationBusiness;
import com.communicationMarketing.main.entity.Event;
import com.communicationMarketing.main.entity.Publication;
import com.communicationMarketing.main.repository.PublicationRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class PublicationBusiness  implements  IPublicationBusiness{
	
	    private final PublicationRepository publicationRepository;
	    public PublicationBusiness(PublicationRepository publicationRepository){
	        this.publicationRepository=publicationRepository;
	    }


	    private static final Logger logger = LoggerFactory.getLogger(PublicationBusiness.class);



		 
		 
		 
			 
		 
		 @Override
			public ResponseEntity<Publication> addPublication(PublicationDTO publicationDTO) throws ConstraintViolationException {
			
			 Publication   publicationToPersist = new Publication();
					
			 publicationToPersist.setId(publicationDTO.getId());
			 publicationToPersist.setTitle(publicationDTO.getTitle());
			 publicationToPersist.setDescription(publicationDTO.getDescription());
			 publicationToPersist.setHastag(publicationDTO.getHastag());
			 publicationToPersist.setContent(publicationDTO.getContent());
			 publicationToPersist.setBriefingType(publicationDTO.getBriefingType());
			 publicationToPersist.setTags(publicationDTO.getTags());
			 publicationToPersist.setSocialMedia(publicationDTO.getSocialMedia());
			 publicationToPersist.setDateDebut(publicationDTO.getDateDebut());
			 publicationToPersist.setDateFin(publicationDTO.getDateFin());
			 publicationToPersist.setType(publicationDTO.getType());
			 publicationToPersist.setPersonas(publicationDTO.getPersonas());
			 publicationToPersist.setGraphicalCharter(publicationDTO.getGraphicalCharter());
			 publicationToPersist.setArchive(false);

		
				


			 publicationRepository.save(publicationToPersist);
					return ResponseEntity.status(HttpStatus.CREATED).body(publicationToPersist);
				}
			
		 
		 

	
	@Transactional
	@Override
	public Publication updatePublication(Publication p) {
		 Optional<Publication> publicationOptional= publicationRepository.findById(p.getId());
		    
	        return (publicationOptional.isPresent() ?
	        		publicationRepository.save(p)
	                : null);
	}

	@Override
	public ResponseEntity<String> deletePublication(String id) {
		 if(publicationRepository.findById(id).isPresent()){
			 publicationRepository.deleteById(id);
	            return new ResponseEntity<>("Publication  deleted Successfully!", HttpStatus.OK);
	        }
	        else{
	            return new ResponseEntity<>("Publication not found", HttpStatus.NOT_FOUND);
	        }
	}

	@Override
	public List<Publication> getAllPublications() {
		
		   return publicationRepository.findAll();

	}

	@Override
	public ResponseEntity<?> getPublicationByID(String id) {
		 Optional<Publication> publicationData = publicationRepository.findById(id);
	        return publicationData.map(p -> new ResponseEntity<>(p, HttpStatus.OK)).orElseGet(()
	                -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));


		
	}

	@Override
	public long countPublications() {
		   return publicationRepository.count();

	}




	@Override
	public List<Publication> findAllPublicationASC() {
        return publicationRepository.findAll(Sort.by("title").ascending());

	}




	@Override
	public List<Publication> findAllPublicationDESC() {
        return publicationRepository.findAll(Sort.by("title").descending());

		
	}
	
	
	
	@Override
	public Publication cancelArchivePublication(Publication p, String id)
	{

       	
    	Publication existedPublication = publicationRepository.findById(id).orElse(null);
		if (existedPublication != null) {
			existedPublication.setArchive(false);
			publicationRepository.save(existedPublication);
			return existedPublication;
		} else {
			return null;
		}
		
		
	}
	
	@Override
	public	Publication archivePublication(Publication p, String id)
	{
		
		Publication existedPublication = publicationRepository.findById(id).orElse(null);
		if (existedPublication != null) {
			existedPublication.setArchive(true);
			publicationRepository.save(existedPublication);
			return existedPublication;
		} else {
			return null;
		}
		
		
	}


}
