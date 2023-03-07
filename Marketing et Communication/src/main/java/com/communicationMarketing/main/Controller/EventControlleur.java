package com.communicationMarketing.main.Controller;

import org.springframework.cache.annotation.CachePut;

import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.communicationMarketing.main.business.dtos.EventDTO;
import com.communicationMarketing.main.business.ibusiness.*;
import com.communicationMarketing.main.entity.Event;
import com.communicationMarketing.main.entity.Parternership;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.modelmapper.ModelMapper;

@RequestMapping(path = { "/Event" }, produces = APPLICATION_JSON_VALUE)
@RestController
public class EventControlleur {
	IEventBusiness IEventBusiness;

	    public EventControlleur(IEventBusiness IEventBusiness){
	        this.IEventBusiness=IEventBusiness;
	    }

	    @PostMapping("/add")
	    @CachePut(value = "Event")


	    public ResponseEntity<Event> addEvent ( @RequestBody EventDTO eventDTO){
	        return IEventBusiness.addEvent(eventDTO);
	    	
	    	/*Event event = modelMapper.map(eventDTO, Event.class);
	           return ((IEventBusiness.addEvent(event) != null)
	                   ? new ResponseEntity<>(IEventBusiness.add(event), HttpStatus.CREATED)
	                   : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));*/
           }
	    @GetMapping("/allEvents")
	    public ResponseEntity<List<Event>> findAllEvents(){
	        List<Event> rows = IEventBusiness.getAllEvents();
	        return new ResponseEntity <>(rows, HttpStatus.OK);
	    }

	    @PutMapping("/update-event")
	    public Event updateevent(@RequestBody Event event){
	        return IEventBusiness.updateEvent(event);
	    }

	    

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteEvent(@PathVariable("id") String id){
	        return IEventBusiness.deleteEvent(id);
	    }

	    @GetMapping("/Event-by-id/{id}")
	    public ResponseEntity<?> getEventByID (@PathVariable("id") String id){
	        return IEventBusiness.getEventByID(id);
	    }

	    
	    @GetMapping("/count-Events")
	    public long countEvents(){
	        return IEventBusiness.countEvents();
	    }
	    
	    
	    
	    
	    @GetMapping( "/descending")
	    public ResponseEntity<List<Event>> listEventDesc(){
	        return new ResponseEntity<>(IEventBusiness.findAllEventDESC(), HttpStatus.OK);
	    }
	    @GetMapping( "/ascending")
	    public ResponseEntity<List<Event>> listEventrAsc(){
	        return new ResponseEntity<>(IEventBusiness.findAllEventASC(), HttpStatus.OK);
	    }
	    
	    
	    @PutMapping("/archive-Event/{id}")
	    public Event archiveEvent(@RequestBody Event e, @PathVariable("id") String id){
	        return IEventBusiness.archiveEvent(e, id);
	    }

	    @PutMapping("/cancelArchive-Event/{id}")
	    public Event cancelArchiveEvent(@RequestBody Event e, @PathVariable("id") String id){
	        return IEventBusiness.cancelArchiveEvent(e, id);
	    }



}
