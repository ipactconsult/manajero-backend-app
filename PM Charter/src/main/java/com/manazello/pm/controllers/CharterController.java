package com.manazello.pm.controllers;

import com.manazello.pm.business.implbusiness.CharterImpl;
import com.manazello.pm.dtos.CharterDTO;
import com.manazello.pm.dtos.CharterResponseDto;
import com.manazello.pm.entities.Charter;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/charter")
@CrossOrigin(origins = "http://localhost:4200")
@EnableCaching
public class CharterController {
    final
    CharterImpl iCharter;

    private final ModelMapper modelMapper;

    public CharterController(CharterImpl iCharter, ModelMapper modelMapper) {
        this.iCharter = iCharter;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/allCharter")
    @Cacheable(value = "Charter")
    public ResponseEntity<List<CharterResponseDto>> getAllCharter() {
        try {
            List<CharterResponseDto> charterList = iCharter.findAllSomeFields();

            if (charterList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(charterList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/findByIdCharter/{id}")
    public ResponseEntity<Charter> findByIdCharter(@PathVariable String id) {
        Charter charter = iCharter.findById(id);
        return (charter != null) ? new ResponseEntity<>(charter, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addCharter")
    @CachePut(value = "Charter")
    public ResponseEntity<Charter> createCharter(@RequestBody CharterDTO changeRequestDTO) {
        Charter charter = modelMapper.map(changeRequestDTO, Charter.class);
        return ((iCharter.add(charter) != null)
                ? new ResponseEntity<>(iCharter.add(charter), HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @PutMapping("/updateCharter")
    public ResponseEntity<Charter> updateCharter(@RequestBody CharterDTO changeRequestDTO) {
        Charter charter = modelMapper.map(changeRequestDTO, Charter.class);
        return ((iCharter.update(charter) != null)
                ? new ResponseEntity<>(iCharter.add(charter), HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }
    @DeleteMapping("/deleteCharter/{id}")
    public ResponseEntity<Charter> deleteCharter(@PathVariable String id) {
        return ((iCharter.delete(id) )
                ? new ResponseEntity<>( HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
