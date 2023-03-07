package com.communicationMarketing.main.business.businessimpl;



import java.util.List;








import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.communicationMarketing.main.business.dtos.EventDTO;
import com.communicationMarketing.main.business.ibusiness.IEventBusiness;
import com.communicationMarketing.main.entity.Event;
import com.communicationMarketing.main.entity.Parternership;
import com.communicationMarketing.main.repository.EventRepository;


import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

import javax.validation.ConstraintViolationException;

@Service
public class EventBusiness  implements  IEventBusiness{

	
	    private final EventRepository eventRepository;
	    public EventBusiness(EventRepository eventRepository){
	        this.eventRepository=eventRepository;
	    }


	
	
	
	
	
	 @Override
	public ResponseEntity<Event> addEvent(EventDTO eventDTO) throws ConstraintViolationException {
	
		 Event eventToPersist = new Event();
			
			eventToPersist.setId(eventDTO.getId());
			eventToPersist.setTitle(eventDTO.getTitle());
			eventToPersist.setDescription(eventDTO.getDescription());
			eventToPersist.setDate(eventDTO.getDate());
			eventToPersist.setPrix(eventDTO.getPrix());
			eventToPersist.setAdresse(eventDTO.getAdresse());
			eventToPersist.setImage(eventDTO.getImage()) ;
			eventToPersist.setTime(eventDTO.getTime()) ;
			eventToPersist.setCountry(eventDTO.getCountry()) ;
			eventToPersist.setNombre(eventDTO.getNombre()) ;
			eventToPersist.setPersonas(eventDTO.getPersonas()) ;
			eventToPersist.setPartners(eventDTO.getPartners()) ;
			eventToPersist.setArchive(false);
			eventToPersist.setPersonas(eventDTO.getPersonas());
			eventToPersist.setPartners(eventDTO.getPartners());


			eventRepository.save(eventToPersist);
			return ResponseEntity.status(HttpStatus.CREATED).body(eventToPersist);
		}
	

	
	@Transactional
	@Override
	public Event updateEvent(Event event) {
		 Optional<Event> eventOptional= eventRepository.findById(event.getId());
	    
	        return (eventOptional.isPresent() ?
	        		eventRepository.save(event)
	                : null);
}

	@Override
	public ResponseEntity<String> deleteEvent(String id) {
	      if(eventRepository.findById(id).isPresent()){
	    	  eventRepository.deleteById(id);
	            return new ResponseEntity<>("event  deleted Successfully!", HttpStatus.OK);
	        }
	        else{
	            return new ResponseEntity<>("event not found", HttpStatus.NOT_FOUND);
	        }

	}

	@Override
	public List<Event> getAllEvents() {
		   return eventRepository.findAll();
	}

	@Override
	public ResponseEntity<?> getEventByID(String id) {
		 Optional<Event> contractData = eventRepository.findById(id);
	        return contractData.map(contract -> new ResponseEntity<>(contract, HttpStatus.OK)).orElseGet(()
	                -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

	}

	@Override
	public long countEvents() {
		   return eventRepository.count();
	}

	@Override
	public List<Event> findAllEventASC() {
        return eventRepository.findAll(Sort.by("title").ascending());

	}

	@Override
	public List<Event> findAllEventDESC() {
        return eventRepository.findAll(Sort.by("title").descending());

	}
	
	
	
    @Override
    public Event cancelArchiveEvent(Event event, String id) {

       	
    	Event existedEvent = eventRepository.findById(id).orElse(null);
		if (existedEvent != null) {
			existedEvent.setArchive(false);
			eventRepository.save(existedEvent);
			return existedEvent;
		} else {
			return null;
		}

    }
    

    @Override
    public Event archiveEvent(Event event, String id) {
    	Event existedEvent = eventRepository.findById(id).orElse(null);
    		if (existedEvent != null) {
    			existedEvent.setArchive(true);
    			eventRepository.save(existedEvent);
    			return existedEvent;
    		} else {
    			return null;
    		}
	
    }
	

}
