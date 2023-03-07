package com.stock.main.controllers;

import com.stock.main.business.businessimpl.InventoryMovementBusiness;
import com.stock.main.business.dtos.InventoryMovementDTO;
import com.stock.main.entities.InventoryMovement;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/im")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class InventoryMovementController {
    
    @Autowired
	private InventoryMovementBusiness imBusiness;
	
	@Autowired
        private ModelMapper modelMapper;
        
        @GetMapping("/all")
        public List<InventoryMovement> getAllIMs() {
            return imBusiness.getAllIMs();
        }
        
        @GetMapping("/all/asc")
        public List<InventoryMovement> getAllIMsASC() {
            return imBusiness.getAllIMsASC();
        }
        
        @GetMapping("/all/desc")
        public List<InventoryMovement> getAllIMsDESC() {
            return imBusiness.getAllIMsDESC();
        }
        
        @GetMapping("/{imId}")
        public InventoryMovement getOneIM(@PathVariable String imId) {
            return imBusiness.getOneIM(imId);
        }
        
        @PostMapping("/create")
        public InventoryMovement createIM(@RequestBody InventoryMovementDTO imDTO) {
            InventoryMovement im = convertToEntity(imDTO);
            return imBusiness.createIM(im);
        }
        
        @PutMapping("/archive/{imId}")
        public InventoryMovement archiveIM(@PathVariable String imId) {
            return imBusiness.archiveIM(imId);
        }
        
        @PutMapping("/restore/{imId}")
        public InventoryMovement restoreIM(@PathVariable String imId) {
            return imBusiness.restoreIM(imId);
        }
        
        @DeleteMapping("/delete/{imId}")
        public InventoryMovement deleteIM(@PathVariable String imId) {
            return imBusiness.deleteIM(imId);
        }
        
        private InventoryMovement convertToEntity(InventoryMovementDTO imDTO) {
	    return modelMapper.map(imDTO, InventoryMovement.class);
	}
    
}
