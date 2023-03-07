package com.example.litigerecouvrement.ibusniess;

import com.example.litigerecouvrement.dto.CategorieDTO;
import com.example.litigerecouvrement.entites.CategorieDoc;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategorieIBusiness {
    CategorieDoc createCategorie(CategorieDoc cat);
    List<CategorieDoc> findAllCategorieDoc();
    ResponseEntity<CategorieDoc> findByCategorieDoc(CategorieDTO categorieDTO);

    ResponseEntity<CategorieDoc> findByCategorieDoc(CategorieDoc categorieDTO);

    ResponseEntity<CategorieDoc>findByid(String id);

    List<CategorieDoc> findAllCategoryDESC();

    List<CategorieDoc> findAllCategoryASC();

     String deleteCategorie(String ida) ;
    CategorieDoc updateCatgorie(String id,CategorieDoc categorie);

}
