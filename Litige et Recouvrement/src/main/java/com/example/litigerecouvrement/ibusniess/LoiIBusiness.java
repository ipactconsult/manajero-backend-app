package com.example.litigerecouvrement.ibusniess;

import com.example.litigerecouvrement.entites.CategorieDoc;
import com.example.litigerecouvrement.entites.Loi;

import java.util.List;

public interface LoiIBusiness {
    Loi createLoi(Loi loi);
     String deleteLoi(String ida) ;
     Loi getLoiById(String id);
     List<Loi> getFiles();
     Loi updateLoi(String id, Loi categorie) ;
     List<Loi> getLoibyCategory(CategorieDoc categorieDoc);
}
