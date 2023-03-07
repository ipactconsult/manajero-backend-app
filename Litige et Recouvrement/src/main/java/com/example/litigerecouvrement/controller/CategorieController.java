package com.example.litigerecouvrement.controller;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


import com.example.litigerecouvrement.dto.CategorieDTO;
import com.example.litigerecouvrement.entites.CategorieDoc;
import com.example.litigerecouvrement.ibusniess.CategorieIBusiness;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= {"/categorie"}, produces= APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class CategorieController {
    private final ModelMapper modelMapper;

    final
    CategorieIBusiness catIB;

    public CategorieController(ModelMapper modelMapper, CategorieIBusiness catIB) {
        this.modelMapper = modelMapper;
        this.catIB = catIB;
    }

    @PostMapping("/add")
    public CategorieDoc createCat(@RequestBody CategorieDTO cate){
        CategorieDoc categorie = modelMapper.map(cate, CategorieDoc.class);

        return catIB.createCategorie(categorie);

    }

    @GetMapping( "/all/descending")
    public ResponseEntity<List<CategorieDoc>> listCategorieDesc(){
        return new ResponseEntity<>(catIB.findAllCategoryDESC(), HttpStatus.OK);
    }
    @GetMapping( "/all/ascending")
    public ResponseEntity<List<CategorieDoc>> listCategorieAsc(){
        return new ResponseEntity<>(catIB.findAllCategoryASC(), HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<CategorieDoc>> findAllCategorie(){
        return new ResponseEntity<>(catIB.findAllCategorieDoc(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public CategorieDoc editCategorie(@PathVariable("id") String id,@RequestBody CategorieDTO categoriedto)
    {

        CategorieDoc categorie = modelMapper.map(categoriedto, CategorieDoc.class);

        return catIB.updateCatgorie(id,categorie);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable String id) {
        return catIB.deleteCategorie(id);
    }
    @GetMapping("/findOne")
    public ResponseEntity<CategorieDoc> getCategorie(@RequestBody CategorieDTO categorieDTO)
    {
        return catIB.findByCategorieDoc(categorieDTO);
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<CategorieDoc> getCategorieByid(@PathVariable("id") String id)
    {
        return catIB.findByid(id);
    }


}
