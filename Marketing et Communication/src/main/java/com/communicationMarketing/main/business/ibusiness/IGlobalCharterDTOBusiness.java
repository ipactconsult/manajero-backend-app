package com.communicationMarketing.main.business.ibusiness;

import java.util.List;


import org.springframework.http.ResponseEntity;

import com.communicationMarketing.main.business.dtos.GlobalCharterDTO;
import com.communicationMarketing.main.entity.GlobalCharter;

public interface IGlobalCharterDTOBusiness {
	   ResponseEntity<GlobalCharter> addGlobalCharter (GlobalCharterDTO g);
	   GlobalCharter updateGlobalCharter (GlobalCharter g);
	   ResponseEntity<GlobalCharter> updateGlobalCharter(GlobalCharterDTO GlobalCharterDTO, String id);
	   ResponseEntity<String> deleteGlobalCharter (String id);
	   List<GlobalCharter> getAllGlobalCharters ();
	   ResponseEntity<?> getGlobalCharterByID(String id);
	   long countGlobalCharters();
	   GlobalCharter cancelArchiveGlobalCharter(GlobalCharter g, String id);
	    public GlobalCharter archiveGlobalCharter(GlobalCharter g, String id) ;  
}
