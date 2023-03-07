package com.example.litigerecouvrement.ibusniess;


import com.example.litigerecouvrement.dto.ScenarioDTO;
import com.example.litigerecouvrement.entites.Scenario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ScenarioIBusiness {

    Scenario createScenario(ScenarioDTO lit);
    List<Scenario> findAllScenario();
    Scenario updateScenario(String id,Scenario scenario) ;
    public ResponseEntity<Scenario> findByid(String id) ;
    public String deleteScenario(String idl) ;
}
