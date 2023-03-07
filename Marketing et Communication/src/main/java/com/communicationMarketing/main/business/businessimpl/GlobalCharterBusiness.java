package com.communicationMarketing.main.business.businessimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.communicationMarketing.main.business.dtos.GlobalCharterDTO;
import com.communicationMarketing.main.business.ibusiness.IGlobalCharterDTOBusiness;
import com.communicationMarketing.main.entity.GlobalCharter;
import com.communicationMarketing.main.entity.Parternership;
import com.communicationMarketing.main.entity.Persona;
import com.communicationMarketing.main.repository.GlobalCharterRepository;


@Service
public class GlobalCharterBusiness  implements IGlobalCharterDTOBusiness {
	
	
    private final GlobalCharterRepository globalCharterRepository;
    public GlobalCharterBusiness(GlobalCharterRepository globalCharterRepository){
        this.globalCharterRepository=globalCharterRepository;
    }


	@Override
	public ResponseEntity<GlobalCharter> addGlobalCharter(GlobalCharterDTO g) {

		
		GlobalCharter   graphicalCharterToPersist = new GlobalCharter();
		
		graphicalCharterToPersist.setId(g.getId());
		graphicalCharterToPersist.setTitle(g.getTitle());
		graphicalCharterToPersist.setModule(g.getModule());
		graphicalCharterToPersist.setDescription(g.getDescription());
		graphicalCharterToPersist.setFile(g.getFile());
		graphicalCharterToPersist.setLogo(g.getLogo());
		graphicalCharterToPersist.setTypo(g.getTitle());
		graphicalCharterToPersist.setCouleurs(g.getCouleurs());
		graphicalCharterToPersist.setIcon(g.getIcon());
		graphicalCharterToPersist.setArchive(false);
		graphicalCharterToPersist.setTemplate(g.getTemplate());
		graphicalCharterToPersist.setTemplateName(g.getTemplateName());





		globalCharterRepository.save(graphicalCharterToPersist);
		return ResponseEntity.status(HttpStatus.CREATED).body(graphicalCharterToPersist);

		
	}

	@Override
	public GlobalCharter updateGlobalCharter(GlobalCharter g) {
		 Optional<GlobalCharter> gedOptional= globalCharterRepository.findById(g.getId());
		    
	        return (gedOptional.isPresent() ?
	        		globalCharterRepository.save(g)
	                : null);
	}

	@Override
	public ResponseEntity<GlobalCharter> updateGlobalCharter(GlobalCharterDTO GlobalCharterDTO, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> deleteGlobalCharter(String id) {

		 if(globalCharterRepository.findById(id).isPresent()){
			 globalCharterRepository.deleteById(id);
	            return new ResponseEntity<>("Partner   deleted Successfully!", HttpStatus.OK);
	        }
	        else{
	            return new ResponseEntity<>("Partner  not found", HttpStatus.NOT_FOUND);
	        }
		
	}

	@Override
	public List<GlobalCharter> getAllGlobalCharters() {
		   return globalCharterRepository.findAll();

	}

	@Override
	public ResponseEntity<?> getGlobalCharterByID(String id) {
		 Optional<GlobalCharter> partnerdata = globalCharterRepository.findById(id);
	        return partnerdata.map(p -> new ResponseEntity<>(p, HttpStatus.OK)).orElseGet(()
	                -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}

	@Override
	public long countGlobalCharters() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	@Override
	public  GlobalCharter cancelArchiveGlobalCharter(GlobalCharter p, String id)
	{
		GlobalCharter existedGlobalCharter = globalCharterRepository.findById(id).orElse(null);
		if (existedGlobalCharter != null) {
			existedGlobalCharter.setArchive(false);
			globalCharterRepository.save(existedGlobalCharter);
			return existedGlobalCharter;
		} else {
			return null;
		}
	}
	
	@Override   
	    public GlobalCharter archiveGlobalCharter(GlobalCharter p, String id) 
	   {
		GlobalCharter existedGlobalCharter = globalCharterRepository.findById(id).orElse(null);
		if (existedGlobalCharter != null) {
			existedGlobalCharter.setArchive(true);
			globalCharterRepository.save(existedGlobalCharter);
			return existedGlobalCharter;
		} else {
			return null;
		}
	    }
	

}
