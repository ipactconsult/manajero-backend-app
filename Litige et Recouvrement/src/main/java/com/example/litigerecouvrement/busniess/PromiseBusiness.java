package com.example.litigerecouvrement.busniess;


import com.example.litigerecouvrement.entites.Promise;
import com.example.litigerecouvrement.ibusniess.PromiseIBusiness;
import com.example.litigerecouvrement.repositories.PromiseRepository;
import com.example.litigerecouvrement.repositories.RelanceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PromiseBusiness implements PromiseIBusiness{
    private final PromiseRepository promiseRepository;
    private final RelanceRepository relancerep;

    public	PromiseBusiness(PromiseRepository promiseRepository, RelanceRepository relancerep){
        this.promiseRepository=promiseRepository;
        this.relancerep = relancerep;
    }

@Override
    public Promise createPromise(Promise promise) {

        return promiseRepository.save(promise);
    }


    @Override
    public ResponseEntity<Promise> findByid(String id) {
        Optional<Promise> findbyref = promiseRepository.findById(id);
        return (
                findbyref.isPresent() ?
                        new ResponseEntity<>(findbyref.get(), HttpStatus.OK)
                        : new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );

    }

@Override
    public List<Promise> findAllPromise() {
        return promiseRepository.findAll();
    }


@Override
    public String deletePromise(String ida) {
        promiseRepository.deleteById(ida);
        return "Promise deleted";

    }


@Override
    public long countPromise() {
        return promiseRepository.count();		}

    @Override
    public Promise getPromiseRelance(String id) {



return null ;

    }


    @Override
    public Promise updatePromise(Promise promise, String id) {
        Optional<Promise> promiseOptional= promiseRepository.findById(id);

        return   (promiseOptional.isPresent()?
                promiseRepository.save(promise):null);


    }







}