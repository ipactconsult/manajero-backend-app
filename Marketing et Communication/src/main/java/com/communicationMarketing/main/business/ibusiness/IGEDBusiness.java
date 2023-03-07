package com.communicationMarketing.main.business.ibusiness;

import java.util.List;



import org.springframework.http.ResponseEntity;
import com.communicationMarketing.main.business.dtos.GEDDTO;
import com.communicationMarketing.main.entity.GED;


public interface IGEDBusiness {
	   ResponseEntity<GED> addGED (GEDDTO g);
	   GED updateGED (GED ged);
	   ResponseEntity<GED> updateGED(GEDDTO GEDDTO, String idGED);
	   GED deleteGED (String id);
	   List<GED> getAllGEDs ();
	   ResponseEntity<?> getGEDByID(String id);
	   long countGEDs();
	   GED cancelArchiveGED(GED g, String id);
	    public GED archiveGED(GED g, String id) ;

}
