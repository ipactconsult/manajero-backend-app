package com.communicationMarketing.main.business.businessimpl;



import java.util.List;





import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.communicationMarketing.main.business.dtos.GraphicalCharterDTO;
import com.communicationMarketing.main.business.ibusiness.IgraphicalCharterBusiness;
import com.communicationMarketing.main.entity.GraphicalCharter;
import com.communicationMarketing.main.repository.GraphicalCharterRepository;

@Service
public class GraphicalCharterBusiness implements IgraphicalCharterBusiness {

	
	    private final GraphicalCharterRepository graphicalCharterRepository;
	    public GraphicalCharterBusiness(GraphicalCharterRepository graphicalCharterRepository){
	        this.graphicalCharterRepository=graphicalCharterRepository;
	    }
	
	
	
	@Override
	public ResponseEntity<GraphicalCharter> addgraphicalCharter(GraphicalCharterDTO graphicalCharterDTO)  throws ConstraintViolationException {
		GraphicalCharter   graphicalCharterToPersist = new GraphicalCharter();
		
		graphicalCharterToPersist.setId(graphicalCharterDTO.getId());
		graphicalCharterToPersist.setColor(graphicalCharterDTO.getColor());
		graphicalCharterToPersist.setTexType(graphicalCharterDTO.getTexType());
		graphicalCharterToPersist.setDescription(graphicalCharterDTO.getDescription());
		graphicalCharterToPersist.setReference(graphicalCharterDTO.getReference());
		graphicalCharterToPersist.setFormaText(graphicalCharterDTO.getFormaText());
		graphicalCharterToPersist.setTitle(graphicalCharterDTO.getTitle());



		graphicalCharterRepository.save(graphicalCharterToPersist);
		return ResponseEntity.status(HttpStatus.CREATED).body(graphicalCharterToPersist);

		
		
		
	}
	@Transactional
	@Override
	public GraphicalCharter updategraphicalCharter(GraphicalCharter g) {
		 Optional<GraphicalCharter> graphicalCharterOptional= graphicalCharterRepository.findById(g.getId());
		    
	        return (graphicalCharterOptional.isPresent() ?
	        		graphicalCharterRepository.save(g)
	                : null);
	}

	@Override
	public ResponseEntity<String> deletegraphicalCharter(String id) {

	      if(graphicalCharterRepository.findById(id).isPresent()){
	    	  graphicalCharterRepository.deleteById(id);
	            return new ResponseEntity<>("graphical Charter  deleted Successfully!", HttpStatus.OK);
	        }
	        else{
	            return new ResponseEntity<>("graphical Charter not found", HttpStatus.NOT_FOUND);
	        }
	}

	@Override
	public List<GraphicalCharter> getAllgraphicalCharters() {
		   return graphicalCharterRepository.findAll();

	}

	@Override
	public ResponseEntity<?> getgraphicalChartertByID(String id) {
		 Optional<GraphicalCharter> graphicalCharterData = graphicalCharterRepository.findById(id);
	        return graphicalCharterData.map(contract -> new ResponseEntity<>(contract, HttpStatus.OK)).orElseGet(()
	                -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

		
		
	}

	@Override
	public long countgraphicalCharters() {

		   return graphicalCharterRepository.count();

	}

}
