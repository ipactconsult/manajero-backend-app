package com.example.litigerecouvrement.controller;

import com.example.litigerecouvrement.dto.AvocatDTO;
import com.example.litigerecouvrement.entites.Avocat;
import com.example.litigerecouvrement.ibusniess.AvocatIBusiness;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


import java.util.List;

@RestController
@RequestMapping(path= {"/avocat"}, produces= APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class AvocatController {
    private final ModelMapper modelMapper;


    public static final String DIRECTERY =System.getProperty("user.home")+"Downloads/uploads/";
    @Autowired
    final
    AvocatIBusiness avocatIB;

    public AvocatController(ModelMapper modelMapper, AvocatIBusiness avocatIB) {
        this.modelMapper = modelMapper;
        this.avocatIB = avocatIB;
    }




    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Avocat> createAvocat(@RequestBody AvocatDTO avocatDTO){
        Avocat avocat = modelMapper.map(avocatDTO, Avocat.class);


        avocatIB.createAvocat(avocat);
        return new ResponseEntity<>(avocat,HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Avocat> findAllAvocat(){
        return avocatIB.findAllAvocat();
    }

    @PutMapping("/update/{id}")
    public Avocat editAvocat(@RequestBody AvocatDTO av, @PathVariable("id") String id)
    {
        Avocat avocat = modelMapper.map(av, Avocat.class);

        return avocatIB.updateAvocat(avocat,id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteAvocat(@PathVariable String id) {


        return avocatIB.deleteAvocat(id);
    }
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Avocat> getAvocatByid(@PathVariable("id") String id)
    {
        return avocatIB.findByid(id);
    }
    @PutMapping("/archive/{id}")
    public Avocat archiveAvocat(@RequestBody AvocatDTO avocat, @PathVariable("id") String id){
        Avocat avocats = modelMapper.map(avocat, Avocat.class);

        return avocatIB.archiveAvocat(avocats,id);
    }

    @PutMapping("/cancel-archive/{id}")
    public Avocat cancelArchiveAvocat(@RequestBody AvocatDTO avocat, @PathVariable("id") String id){
        Avocat avocats = modelMapper.map(avocat, Avocat.class);

        return avocatIB.cancelArchiveAvocat(avocats,id);
    }
    @GetMapping( "/all/descending")
    public ResponseEntity<List<Avocat>> listAvocatDesc(){
        return new ResponseEntity<>(avocatIB.findAllAvocatDESC(), HttpStatus.OK);
    }
    @GetMapping( "/all/ascending")
    public ResponseEntity<List<Avocat>> listAvocatAsc(){
        return new ResponseEntity<>(avocatIB.findAllAvocatASC(), HttpStatus.OK);
    }

    @GetMapping( "/non-archived/{archive}")
    public ResponseEntity<List<Avocat>> findNonArchivedAvocat(@PathVariable("archive") String archive){
        return new ResponseEntity<>(avocatIB.findNonArchivedAvocat(archive), HttpStatus.OK);
    }


}
