package com.example.litigerecouvrement.busniess;

import com.example.litigerecouvrement.dto.ActionScenarioDTO;
import com.example.litigerecouvrement.entites.ActionScenario;
import com.example.litigerecouvrement.ibusniess.ActionScenarioIBusiness;
import com.example.litigerecouvrement.repositories.ActionScenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionScenarioBusiness implements ActionScenarioIBusiness {
    @Autowired
    private ActionScenarioRepository actionrep;
    @Override
    public ActionScenario createActionScenario(ActionScenarioDTO lit) {
        ActionScenario sc=new ActionScenario(lit.getId(),
                lit.getActionename(),
                lit.getNbrjr(),
                lit.getTypeaction(),
                lit.getSce()


        );
        return actionrep.save(sc)  ;
    }

    @Override
    public List<ActionScenario> findAllActions() {
      return actionrep.findAll();
    }

    @Override
    public ActionScenario updateActionScenario(String id, ActionScenario scenario) {
        Optional<ActionScenario> existedScenario = actionrep.findById(id);

        return (existedScenario.isPresent()?
                actionrep.save(scenario):null);
    }

    @Override
    public ResponseEntity<ActionScenario> findByid(String id) {
        actionrep.findById(id);
        return new ResponseEntity<>( actionrep.findById(id).get(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public String deleteActionScenario(String idl) {
        actionrep.deleteById(idl);
        return "Scenario deleted" ;
    }
}
