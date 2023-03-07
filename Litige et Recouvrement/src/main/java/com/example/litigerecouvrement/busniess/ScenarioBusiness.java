package com.example.litigerecouvrement.busniess;

import com.example.litigerecouvrement.dto.ScenarioDTO;
import com.example.litigerecouvrement.entites.Scenario;
import com.example.litigerecouvrement.ibusniess.ScenarioIBusiness;import com.example.litigerecouvrement.repositories.ScenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScenarioBusiness implements ScenarioIBusiness {
    @Autowired
    private ScenarioRepository screp;

    @Override
    public Scenario createScenario(ScenarioDTO lit) {
        Scenario sc=new Scenario(lit.getId(),
                lit.getNomScenario(),
                lit.getActions()


        );
        return screp.save(sc)  ;  }

    @Override
    public List<Scenario> findAllScenario() {

        return screp.findAll();
    }

    @Override
    public Scenario updateScenario(String id, Scenario scenario) {



        Optional<Scenario> scenarioOptional= screp.findById(id);



            return  scenarioOptional.isPresent()?
                    screp.save(scenario):null;

    }

    @Override
    public ResponseEntity<Scenario> findByid(String id) {
        screp.findById(id);
        return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public String deleteScenario(String idl) {
        screp.deleteById(idl);
        return "Scenario deleted" ;
    }
}
