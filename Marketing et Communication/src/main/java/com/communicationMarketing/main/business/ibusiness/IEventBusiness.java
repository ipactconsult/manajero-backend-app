package com.communicationMarketing.main.business.ibusiness;

import com.communicationMarketing.main.business.dtos.EventDTO;


import com.communicationMarketing.main.entity.Event;


import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEventBusiness {

	    ResponseEntity<Event> addEvent (EventDTO eventDTO);
	    Event updateEvent (Event event);
	    ResponseEntity<String> deleteEvent (String id);
	    List<Event> getAllEvents ();
	    ResponseEntity<?> getEventByID(String id);
	    long countEvents();
        List<Event> findAllEventASC();
	    List<Event> findAllEventDESC();
	    Event cancelArchiveEvent(Event event, String id);
	    public Event archiveEvent(Event event, String id) ;

	
}
