package com.example.litigerecouvrement.busniess;

import com.example.litigerecouvrement.entites.Avocat;
import com.example.litigerecouvrement.ibusniess.AvocatIBusiness;
import com.example.litigerecouvrement.repositories.AvocatReposiotry;
import org.springframework.data.domain.Sort;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AvocatBusiness implements AvocatIBusiness {
    private final AvocatReposiotry avocatRepository;
    public	AvocatBusiness(AvocatReposiotry avocatRepository){
        this.avocatRepository=avocatRepository;
    }


    public Avocat createAvocat(Avocat avocat) {
        avocat.setArchive("False");
    return avocatRepository.save(avocat);
    }


    @Override
    public ResponseEntity<Avocat> findByid(String id) {
        Optional<Avocat> findbyref = avocatRepository.findById(id);
        return (
                findbyref.isPresent() ?
                        new ResponseEntity<>(findbyref.get(), HttpStatus.OK)
                        : new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );

    }




    public List<Avocat> findAllAvocat() {
        return avocatRepository.findAll();
    }



    public String deleteAvocat(String ida) {
        avocatRepository.deleteById(ida);
        return "Avocat deleted";

    }



    public long countAvocat() {
        return avocatRepository.count();		}



    @Override
    public List<Avocat> findAllAvocatASC() {
        return avocatRepository.findAll(Sort.by("specialite").ascending());

    }

    @Override
    public List<Avocat> findAllAvocatDESC() {

        return avocatRepository.findAll(Sort.by("specialite").descending());
    }

    @Override
    public Avocat archiveAvocat(Avocat avocat, String id) {
        Optional<Avocat> avocatDetails= avocatRepository.findById(id);
        Date date= new Date();
        Instant dateToUpdate= date.toInstant();
        avocat.setModifiedAt(dateToUpdate);
        avocat.setArchive("True");
        return (avocatDetails.isPresent() ?
                avocatRepository.save(avocat)
                : null);
    }

    @Override
    public Avocat cancelArchiveAvocat(Avocat avocat, String id) {
        Optional<Avocat> avocatArchived= avocatRepository.findById(id);
        Date date= new Date();
        Instant dateToUpdate= date.toInstant();
        avocat.setModifiedAt(dateToUpdate);
        avocat.setArchive("False");
        return (avocatArchived.isPresent() ?
                avocatRepository.save(avocat)
                : null);
    }

    @Override
    public List<Avocat> findNonArchivedAvocat(String archive) {
        return avocatRepository.findAvocatsByArchive(archive);

    }




    @Override
    public ResponseEntity<List<Avocat>> findAvocatBySpecialite() {
        return null;
    }


    public Avocat updateAvocat(Avocat avocat, String id) {
     Optional<Avocat> avocatOptional= avocatRepository.findById(id);
     Date date= new Date();
     Instant dateToUpdate= date.toInstant();
     avocat.setModifiedAt(dateToUpdate);

     return   (avocatOptional.isPresent()?
             avocatRepository.save(avocat):null);


    }







}
