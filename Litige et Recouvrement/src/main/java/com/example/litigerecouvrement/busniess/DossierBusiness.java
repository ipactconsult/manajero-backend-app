package com.example.litigerecouvrement.busniess;

import com.example.litigerecouvrement.dto.DossierDTO;
import com.example.litigerecouvrement.entites.Dossier;

import com.example.litigerecouvrement.ibusniess.DossierIBusiness;
import com.example.litigerecouvrement.repositories.DossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DossierBusiness implements DossierIBusiness {

    @Autowired
    private DossierRepository dossierrepo;

    @Override
    public Dossier createDossier(Dossier dos) {

        return dossierrepo.save(dos);
    }

    @Override
    public List<Dossier> findAllDosssier() {
        return dossierrepo.findAll();

    }
    @Override
    public Dossier updateDossier(String id, Dossier dossier) {

        Optional<Dossier>dossierArchived= dossierrepo.findById(id);


        return   (dossierArchived.isPresent()?
                dossierrepo.save(dossier):null);

    }

    @Override
    public ResponseEntity<Dossier> findByDossier(DossierDTO dossierDTO) {
        Optional<Dossier> findbyobj = dossierrepo.findById(dossierDTO.getId());
        return (
                findbyobj.isPresent() ?
                        new ResponseEntity<>(findbyobj.get(), HttpStatus.OK) :
                        new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }


    @Override
    public Dossier findByid(String id) {
        return dossierrepo.findById(id).orElse(null);

    }

    @Override
    public String deleteDossier(String ida) {
        dossierrepo.deleteById(ida);
        return "Dossier deleted";
    }
}
