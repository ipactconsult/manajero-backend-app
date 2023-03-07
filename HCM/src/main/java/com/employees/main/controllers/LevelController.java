package com.employees.main.controllers;

import com.employees.main.business.dto.LevelDTO;
import com.employees.main.business.ibusiness.LevelIBusiness;
import com.employees.main.entities.Level;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "/level", produces = APPLICATION_JSON_VALUE)
public class LevelController {

    private final LevelIBusiness levelIB;

    final ModelMapper mapper;

    public LevelController(LevelIBusiness levelIB, ModelMapper mapper) {
        this.levelIB = levelIB;
        this.mapper = mapper;
    }

    @PostMapping(value = "/create")
    public Level createLevel(@Valid @RequestBody LevelDTO levelDTO){
       return levelIB.createLevel(levelDTO);

    }
    @GetMapping(value = "/all")
    public ResponseEntity<List<Level>> findAllLevels(){
        return new ResponseEntity<>(levelIB.findAllLevels(), HttpStatus.OK);
    }
    @DeleteMapping( value = "/delete/{id}")
    public ResponseEntity<String> removeLevel(@PathVariable("id")String id)
    {
        return new ResponseEntity<>(""+levelIB.deleteLevel(id),HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Level> updateLvl(@Valid @RequestBody LevelDTO lvlDTO)
    {
        Level lvl = this.mapper.map(lvlDTO, Level.class);
        return new ResponseEntity<>( levelIB.updateLevel(lvl),HttpStatus.OK);
    }

    @GetMapping(value = "/count")
    public ResponseEntity<Integer> countlvls(){
        return new ResponseEntity<>((int) levelIB.countLevels(), HttpStatus.OK);
    }



}
