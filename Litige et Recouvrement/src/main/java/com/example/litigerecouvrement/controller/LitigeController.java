package com.example.litigerecouvrement.controller;

import com.example.litigerecouvrement.dto.LitigeDTO;
import com.example.litigerecouvrement.entites.Litige;
import com.example.litigerecouvrement.ibusniess.LitigeIBusiness;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

@RestController
@RequestMapping(path= {"/litige"}, produces= APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class LitigeController {
    private final ModelMapper modelMapper;



    final
    LitigeIBusiness litigeBus;

    public LitigeController(ModelMapper modelMapper, LitigeIBusiness litigeBus) {
        this.modelMapper = modelMapper;
        this.litigeBus = litigeBus;
    }

    @PostMapping("/add")
    public Litige createCat(@RequestBody LitigeDTO lit){
        Litige litige = modelMapper.map(lit, Litige.class);

        return litigeBus.createLitige(litige);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Litige>> findAllCategorie(){
        return new ResponseEntity<>(litigeBus.findAllLitige(), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public Litige editLitige(@PathVariable("id") String id,@RequestBody LitigeDTO litigedto)
    {
        Litige litige = modelMapper.map(litigedto, Litige.class);

        return litigeBus.updateLitige(id,litige);
    }


    @DeleteMapping("/delete/{id}")
    public Litige deleteLitige(@PathVariable String id) {
        return litigeBus.deleteLitige(id);
    }
    @GetMapping("/findbyid/{id}")
    public Litige getLitigeByid(@PathVariable("id") String id)
    {
        return litigeBus.getLitigeById(id);
    }
}

