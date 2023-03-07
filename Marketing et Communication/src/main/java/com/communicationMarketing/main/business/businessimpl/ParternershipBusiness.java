package com.communicationMarketing.main.business.businessimpl;

import java.util.List;


import java.util.Optional;

import javax.validation.ConstraintViolationException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.communicationMarketing.main.business.dtos.ParternershipDTO;
import com.communicationMarketing.main.business.ibusiness.IParternershipBusiness;
import com.communicationMarketing.main.entity.Parternership;

import com.communicationMarketing.main.repository.ParternershipRepository;
import org.springframework.data.domain.Sort;



@Service
public class ParternershipBusiness  implements  IParternershipBusiness {
	
	    private final ParternershipRepository ParternershipRepository;
	    public ParternershipBusiness(ParternershipRepository ParternershipRepository){
	        this.ParternershipRepository=ParternershipRepository;
	    }
	    
	    
	    
	        
		 @Override
			public ResponseEntity<Parternership> addParternership(ParternershipDTO p) throws ConstraintViolationException {
			
			       Parternership   parternershipToPersist = new Parternership();
					
			       parternershipToPersist.setId(p.getId());
			       parternershipToPersist.setParternershipName(p.getParternershipName());
			       parternershipToPersist.setParternershipLogo(p.getParternershipLogo());
			       parternershipToPersist.setParternershipDomain(p.getParternershipDomain());
			       parternershipToPersist.setParternershipWebSiteLink(p.getParternershipWebSiteLink());
			       parternershipToPersist.setParternershipEmail(p.getParternershipEmail());
			       parternershipToPersist.setParternershipAdresse(p.getParternershipAdresse());
			       parternershipToPersist.setParternershipLinkedin(p.getParternershipLinkedin());
			       parternershipToPersist.setParternershipPhone(p.getParternershipPhone());
                   parternershipToPersist.setDescription(p.getDescription());
                   parternershipToPersist.setCountry(p.getCountry());
                   parternershipToPersist.setArchive(false);
                   ParternershipRepository.save(parternershipToPersist);
					return ResponseEntity.status(HttpStatus.CREATED).body(parternershipToPersist);
				}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	@Transactional
	@Override
	public Parternership updateParternership(Parternership p) {
		 Optional<Parternership> gedOptional= ParternershipRepository.findById(p.getId());
		    
	        return (gedOptional.isPresent() ?
	        		ParternershipRepository.save(p)
	                : null);
		
		
	}

	@Override
	public ResponseEntity<Parternership> updateParternership(ParternershipDTO ParternershipDTODTO,
			String idParternershipDTO) {

		return null;
	}

	@Override
	public ResponseEntity<String> deleteParternership(String id) {
		 if(ParternershipRepository.findById(id).isPresent()){
			 ParternershipRepository.deleteById(id);
	            return new ResponseEntity<>("Partner   deleted Successfully!", HttpStatus.OK);
	        }
	        else{
	            return new ResponseEntity<>("Partner  not found", HttpStatus.NOT_FOUND);
	        }

	}

		
	
	@Override
	public List<Parternership> getAllParternerships() {
		   return ParternershipRepository.findAll();

	}

	@Override
	public ResponseEntity<?> getParternershipByID(String id) {
		 Optional<Parternership> partnerdata = ParternershipRepository.findById(id);
	        return partnerdata.map(p -> new ResponseEntity<>(p, HttpStatus.OK)).orElseGet(()
	                -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}

	@Override
	public long countParternerships() {
		   return ParternershipRepository.count();

	}

	@Override
	public List<Parternership> findAllPartnerASC() {
        return ParternershipRepository.findAll(Sort.by("ParternershipName").ascending());


}

	@Override
	public List<Parternership> findAllPartnerDESC() {
        return ParternershipRepository.findAll(Sort.by("ParternershipName").descending());


	}
	
	
	
    @Override
    public Parternership cancelArchivePartner(Parternership p, String id) {

       	
    	Parternership existedParternership = ParternershipRepository.findById(id).orElse(null);
		if (existedParternership != null) {
			existedParternership.setArchive(false);
			ParternershipRepository.save(existedParternership);
			return existedParternership;
		} else {
			return null;
		}

    }
    

    @Override
    public Parternership archiveParternership(Parternership p, String id) {
	Parternership existedParternership = ParternershipRepository.findById(id).orElse(null);
    		if (existedParternership != null) {
    			existedParternership.setArchive(true);
    			ParternershipRepository.save(existedParternership);
    			return existedParternership;
    		} else {
    			return null;
    		}

    	
    	
    	
    }
    
    
    
    
    
    
    
    
    



	
	

}
