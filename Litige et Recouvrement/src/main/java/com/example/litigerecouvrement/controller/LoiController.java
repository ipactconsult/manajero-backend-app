package com.example.litigerecouvrement.controller;

import com.example.litigerecouvrement.dto.LoiDTO;
import com.example.litigerecouvrement.entites.CategorieDoc;
import com.example.litigerecouvrement.entites.Loi;
import com.example.litigerecouvrement.ibusniess.LoiIBusiness;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


import java.util.List;

@RestController
@RequestMapping(path= {"/lois"}, produces= APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class LoiController {
    @Autowired
    private LoiIBusiness iloiBusiness;
    private final ModelMapper modelMapper;

    public LoiController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @PostMapping("/add")
    @ResponseBody
    public Loi createLoi(@RequestBody LoiDTO loi){
        Loi lois = modelMapper.map(loi, Loi.class);

        return iloiBusiness.createLoi(lois);

    }
    @GetMapping("/all")
    public ResponseEntity<List<Loi>> findAllLoi(){
        return new ResponseEntity<>(iloiBusiness.getFiles(), HttpStatus.OK);
    }


    @GetMapping("/loi/{loiId}")
    public Loi getLaws(@PathVariable String loiId) {
        return  iloiBusiness.getLoiById(loiId);

    }


    @PutMapping("/update/{id}")
    public Loi editLoi(@PathVariable("id") String id,@RequestBody LoiDTO loidto)
    {
        Loi loi = modelMapper.map(loidto, Loi.class);

        return iloiBusiness.updateLoi(id,loi);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteLoi(@PathVariable String id) {
        return iloiBusiness.deleteLoi(id);
    }

    @GetMapping( "/allcategories/{id}")
    public List<Loi> findLoibyCategory(@PathVariable("id") CategorieDoc categorieDoc){
        return  iloiBusiness.getLoibyCategory(categorieDoc);
    }
    @GetMapping("/findbyid/{id}")
    public Loi getLoiByid(@PathVariable("id") String id)
    {
        return iloiBusiness.getLoiById(id);
    }

}

