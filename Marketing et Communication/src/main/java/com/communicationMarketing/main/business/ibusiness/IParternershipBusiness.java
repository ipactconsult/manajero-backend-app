package com.communicationMarketing.main.business.ibusiness;

import java.util.List; 

import org.springframework.http.ResponseEntity;

import com.communicationMarketing.main.business.dtos.ParternershipDTO;
import com.communicationMarketing.main.entity.Parternership;

public interface IParternershipBusiness {
	
	   ResponseEntity<Parternership> addParternership(ParternershipDTO p);
	   Parternership updateParternership (Parternership p);
	   ResponseEntity<Parternership> updateParternership(ParternershipDTO ParternershipDTO, String idParternershipDTO);
	   ResponseEntity<String> deleteParternership (String id);
	   List<Parternership> getAllParternerships ();
	   ResponseEntity<?> getParternershipByID(String id);
	   long countParternerships();
	   List<Parternership> findAllPartnerASC();
	   List<Parternership> findAllPartnerDESC();
	   Parternership cancelArchivePartner(Parternership p, String id) ;
	   Parternership archiveParternership(Parternership p, String id);


}
