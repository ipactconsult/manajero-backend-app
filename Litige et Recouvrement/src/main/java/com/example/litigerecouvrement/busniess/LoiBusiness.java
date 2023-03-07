package com.example.litigerecouvrement.busniess;

import com.example.litigerecouvrement.entites.CategorieDoc;
import com.example.litigerecouvrement.entites.Loi;
import com.example.litigerecouvrement.ibusniess.LoiIBusiness;
import com.example.litigerecouvrement.repositories.CategorieRepository;
import com.example.litigerecouvrement.repositories.LoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoiBusiness implements LoiIBusiness {
    @Autowired
    private LoiRepository loiRepository;
    @Autowired
    private CategorieRepository catRepository;










    public Loi getLoiById(String id) {
        return loiRepository.findById(id).orElse(null);

    }

    public List<Loi> getFiles() {
        return loiRepository.findAll();
    }





    @Override
    public Loi createLoi(Loi loi) {
        loi.setArchive("False");

        return loiRepository.save(loi);
    }



    public String deleteLoi(String ida) {
        loiRepository.deleteById(ida);
        return "Loi deleted" ;
    }

    public void findbyCategorie(String loiId, String catId) {
        Optional<CategorieDoc> optionalcat = catRepository.findById(catId);
        Optional<Loi> optionaleloi = loiRepository.findById(loiId);

        if (optionalcat.isPresent() && optionaleloi.isPresent())
        {
            CategorieDoc categorieManagedEntity = optionalcat.get();
            Loi loiManagedEntity = optionaleloi.get();

            loiManagedEntity.setCat(categorieManagedEntity);
            loiRepository.save(loiManagedEntity);
        }
    }





    @Override
    public List<Loi> getLoibyCategory(CategorieDoc categorieDoc) {
        return loiRepository.getLoiByCat(categorieDoc);
    }


    public Loi updateLoi(String id, Loi loi) {


        Optional<Loi> categorieArchived= loiRepository.findById(id);


        return   (categorieArchived.isPresent()?
                loiRepository.save(loi):null);



    }



}
