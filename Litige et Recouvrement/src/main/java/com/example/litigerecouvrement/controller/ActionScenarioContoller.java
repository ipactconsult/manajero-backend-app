package com.example.litigerecouvrement.controller;

import com.example.litigerecouvrement.dto.ActionScenarioDTO;
import com.example.litigerecouvrement.entites.ActionScenario;
import com.example.litigerecouvrement.ibusniess.ActionScenarioIBusiness;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path= {"/actions"}, produces= APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class ActionScenarioContoller {
    private final ModelMapper modelMapper;

    final
    ActionScenarioIBusiness acc;

    public ActionScenarioContoller(ModelMapper modelMapper, ActionScenarioIBusiness catIB) {
        this.modelMapper = modelMapper;
        this.acc = catIB;
    }

    @PostMapping("/add")
    public ActionScenario createAction(@RequestBody ActionScenarioDTO cate){
        return acc.createActionScenario(cate);

    }
    @GetMapping("/all")
    public ResponseEntity<List<ActionScenario>> findAllAction(){
        return new ResponseEntity<>(acc.findAllActions(), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ActionScenario editAction(@PathVariable("id") String id,@RequestBody ActionScenarioDTO ac)
    {
        ActionScenario actionScenario = modelMapper.map(ac, ActionScenario.class);

        return acc.updateActionScenario(id,actionScenario);

    }

    @DeleteMapping( "/delete/{id}")
    public String deleteLitige(@PathVariable String id) {
        return acc.deleteActionScenario(id);
    }
}
