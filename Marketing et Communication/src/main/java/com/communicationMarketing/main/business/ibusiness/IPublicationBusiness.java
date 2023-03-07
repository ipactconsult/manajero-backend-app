package com.communicationMarketing.main.business.ibusiness;


import java.util.List;
import org.springframework.http.ResponseEntity;

import com.communicationMarketing.main.business.dtos.EventDTO;
import com.communicationMarketing.main.business.dtos.PublicationDTO;
import com.communicationMarketing.main.entity.Event;
import com.communicationMarketing.main.entity.Publication;

public interface IPublicationBusiness {
	
        ResponseEntity<Publication> addPublication (PublicationDTO PublicationtDTO);
	    Publication updatePublication (Publication p);
	    ResponseEntity<String> deletePublication (String id);
	    List<Publication> getAllPublications ();
	    ResponseEntity<?> getPublicationByID(String id);
	    long countPublications();
		List<Publication> findAllPublicationASC();
		List<Publication> findAllPublicationDESC();
		Publication cancelArchivePublication(Publication p, String id) ;
		Publication archivePublication(Publication p, String id);

	    

}
