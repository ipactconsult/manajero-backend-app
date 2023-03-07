package com.example.litigerecouvrement.ibusniess;

import com.example.litigerecouvrement.dto.ActionScenarioDTO;
import com.example.litigerecouvrement.entites.ActionScenario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ActionScenarioIBusiness {
    ActionScenario createActionScenario(ActionScenarioDTO lit);
    List<ActionScenario> findAllActions();
     ActionScenario updateActionScenario(String id, ActionScenario scenario) ;
     ResponseEntity<ActionScenario> findByid(String id) ;
     String deleteActionScenario(String idl) ;
}
