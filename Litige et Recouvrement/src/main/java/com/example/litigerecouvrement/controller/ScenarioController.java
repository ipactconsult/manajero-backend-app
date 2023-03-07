package com.example.litigerecouvrement.controller;

import com.example.litigerecouvrement.dto.ScenarioDTO;
import com.example.litigerecouvrement.entites.Scenario;
import com.example.litigerecouvrement.ibusniess.ScenarioIBusiness;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path= {"/scenario"}, produces= APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class ScenarioController {
    private final ModelMapper modelMapper;

    final
    ScenarioIBusiness bcc;

    public ScenarioController(ModelMapper modelMapper, ScenarioIBusiness catIB) {
        this.modelMapper = modelMapper;
        this.bcc = catIB;
    }

    @PostMapping("/add")
    public Scenario createScenario(@RequestBody ScenarioDTO cate){
        return bcc.createScenario(cate);

    }
    @GetMapping("/all")
    public ResponseEntity<List<Scenario>> findAllAction(){
        return new ResponseEntity<>(bcc.findAllScenario(), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public Scenario editAction(@PathVariable("id") String id,@RequestBody ScenarioDTO sce)
    {
        Scenario scenario = modelMapper.map(sce, Scenario.class);

        return bcc.updateScenario(id,scenario);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteScenario(@PathVariable String id) {
        return bcc.deleteScenario(id);
    }
}
