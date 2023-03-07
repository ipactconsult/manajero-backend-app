package com.example.litigerecouvrement.controller;

import com.example.litigerecouvrement.dto.DossierDTO;
import com.example.litigerecouvrement.entites.Dossier;

import com.example.litigerecouvrement.ibusniess.DossierIBusiness;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"/dossier"}, produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class DossierController {

    private final ModelMapper modelMapper;

    final DossierIBusiness dosIB;

    public DossierController(ModelMapper modelMapper, DossierIBusiness dosIB) {
        this.modelMapper = modelMapper;
        this.dosIB = dosIB;
    }

    @PostMapping("/add")
    public Dossier createDos(@RequestBody DossierDTO dos) {
        Dossier dossier = modelMapper.map(dos, Dossier.class);

        return dosIB.createDossier(dossier);

    }


    @GetMapping("/all")
    public ResponseEntity<List<Dossier>> findAllDossier() {
        return new ResponseEntity<>(dosIB.findAllDosssier(), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public Dossier editDossier(@PathVariable("id") String id,@RequestBody DossierDTO dossierdto)
    {

        Dossier dossier = modelMapper.map(dossierdto, Dossier.class);

        return dosIB.updateDossier(id,dossier);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteDossier(@PathVariable String id) {
        return dosIB.deleteDossier(id);
    }

    @GetMapping("/findOne")
    public ResponseEntity<Dossier> getDossier(@RequestBody DossierDTO dossierDTO) {
        return dosIB.findByDossier(dossierDTO);
    }

    @GetMapping("/findby/{id}")
    public ResponseEntity<Dossier> getDossierDto(@PathVariable("id") String id) {
        Dossier dossier =dosIB.findByid(id);
        return (dossier!=null)?
                new ResponseEntity<>(dossier,HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
