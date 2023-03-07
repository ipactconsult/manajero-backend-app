package com.communicationMarketing.main.business.ibusiness;

import java.util.List;



import org.springframework.http.ResponseEntity;

import com.communicationMarketing.main.business.dtos.GraphicalCharterDTO;
import com.communicationMarketing.main.entity.GraphicalCharter;

public interface IgraphicalCharterBusiness {

    ResponseEntity<GraphicalCharter> addgraphicalCharter (GraphicalCharterDTO graphicalCharterDTO);
    GraphicalCharter updategraphicalCharter (GraphicalCharter g);
    ResponseEntity<String> deletegraphicalCharter (String id);
    List<GraphicalCharter> getAllgraphicalCharters ();
    ResponseEntity<?> getgraphicalChartertByID(String id);
    long countgraphicalCharters();


}
