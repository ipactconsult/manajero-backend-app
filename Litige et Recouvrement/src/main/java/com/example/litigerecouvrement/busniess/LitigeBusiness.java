package com.example.litigerecouvrement.busniess;

import com.example.litigerecouvrement.entites.Litige;
import com.example.litigerecouvrement.ibusniess.LitigeIBusiness;
import com.example.litigerecouvrement.repositories.LitigeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LitigeBusiness implements LitigeIBusiness {
    @Autowired
    private LitigeRepository litRepository;
    @Override
    public Litige createLitige(Litige lit) {
        lit.setArchive("False");

        return litRepository.save(lit);
    }
    @Override
    public List<Litige> findAllLitige() {
        return litRepository.findAll();
    }
    @Override
    public Litige deleteLitige(String idl) {
        Litige existedLitige = litRepository.findById(idl).orElse(null);
        if (existedLitige != null) {
            litRepository.delete(existedLitige);
            return existedLitige;
        } else {
            return null;
        }
    }


    @Override
    public long countLitige() {
        return litRepository.count();
    }
    @Override
    public ResponseEntity<Litige> findByid(String id) {
        Optional<Litige> findbyref = litRepository.findById(id);
        return (
                findbyref.isPresent() ?
                        new ResponseEntity<>(findbyref.get(), HttpStatus.OK)
                        : new ResponseEntity<>( HttpStatus.NOT_FOUND)
        );

    }
    @Override
    public Litige updateLitige(String id, Litige litige) {

      Litige litigeArchived= litRepository.findById(id).orElse(null);
      if (litigeArchived != null) {
          litigeArchived.setTypelitige(litige.getTypelitige());
          litigeArchived.setDescription(litige.getDescription());
          litigeArchived.setStatut(litige.getStatut());
          return litRepository.save(litigeArchived);
      } else {
          return null;
      }


    }

    @Override
    public Litige getLitigeById(String id) {
        return litRepository.findById(id).orElse(null);

    }

}
