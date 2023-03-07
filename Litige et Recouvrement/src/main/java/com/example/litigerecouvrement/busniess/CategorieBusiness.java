package com.example.litigerecouvrement.busniess;

import com.example.litigerecouvrement.dto.CategorieDTO;
import com.example.litigerecouvrement.entites.CategorieDoc;
import com.example.litigerecouvrement.entites.Litige;
import com.example.litigerecouvrement.ibusniess.CategorieIBusiness;
import com.example.litigerecouvrement.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieBusiness implements CategorieIBusiness {
    @Autowired
    private CategorieRepository catRepository;


@Override
    public CategorieDoc createCategorie(CategorieDoc cat) {
     cat.setArchive("False");

        return catRepository.save(cat);
    }


@Override
    public List<CategorieDoc> findAllCategorieDoc() {

        return catRepository.findAll();
    }

@Override
    public CategorieDoc updateCatgorie(String id, CategorieDoc categorie) {

    CategorieDoc catArchived= catRepository.findById(id).orElse(null);
    if (catArchived != null) {
        catArchived.setDescription(categorie.getDescription());
        return catRepository.save(catArchived);
    } else {
        return null;
    }

    }


    public String deleteCategorie(String ida) {
        catRepository.deleteById(ida);
        return "Categorie deleted" ;
    }


@Override
    public ResponseEntity<CategorieDoc> findByCategorieDoc(CategorieDoc categorieDTO) {
        Optional<CategorieDoc> findbyobj = catRepository.findById(categorieDTO.getId());
        return (
                findbyobj.isPresent() ?
                        new ResponseEntity<>(findbyobj.get(),HttpStatus.OK) :
                        new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );

    }




    public ResponseEntity<CategorieDoc> findByid(String id) {
        Optional<CategorieDoc> findbyref = catRepository.findById(id);
        return (
                findbyref.isPresent() ?
                        new ResponseEntity<>(findbyref.get(), HttpStatus.OK)
                        : new ResponseEntity<>( HttpStatus.NOT_FOUND)
        );

    }

    @Override
    public List<CategorieDoc> findAllCategoryDESC() {
        return catRepository.findAll(Sort.by("categoriename").descending());


    }

    @Override
    public List<CategorieDoc> findAllCategoryASC() {
        return catRepository.findAll(Sort.by("categoriename").ascending());


    }


    public ResponseEntity<CategorieDoc> findByCategorieDoc(CategorieDTO categorieDTO) {
        Optional<CategorieDoc> findbyobj = catRepository.findById(categorieDTO.getId());
        return (
                findbyobj.isPresent() ?
                        new ResponseEntity<>(findbyobj.get(),HttpStatus.OK) :
                        new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }



}
