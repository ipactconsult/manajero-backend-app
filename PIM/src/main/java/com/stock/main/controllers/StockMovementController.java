package com.stock.main.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.main.business.businessimpl.StockMovementBusiness;
import com.stock.main.business.dtos.StockMovementDTO;
import com.stock.main.entities.StockMovement;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/sm")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class StockMovementController {
	
	@Autowired
	private StockMovementBusiness smBusiness;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping("/all")
	public List<StockMovement> getAllSMs() {
		return smBusiness.getAllSMs();
	}
	
	@GetMapping("/all/asc")
	public List<StockMovement> getAllSMsASCByCode() {
		return smBusiness.getAllSMsASCByCode();
	}
	
	@GetMapping("/all/desc")
	public List<StockMovement> getAllSMsDESCByCode() {
		return smBusiness.getAllSMsDESCByCode();
	}
	
	@GetMapping("/show/{smId}")
	public StockMovement getOneSM(@PathVariable String smId) {
		return smBusiness.getOneSM(smId);
	}
	
	@PostMapping("/create/{materialId}")
	public StockMovement addNewSM(@RequestBody StockMovementDTO smDTO, 
			@PathVariable String materialId) {
		StockMovement sm = convertToEntity(smDTO);
		return smBusiness.addNewSM(sm, materialId);
	}
        
        @PutMapping("/archive/{smId}")
	public StockMovement archiveSM(@PathVariable String smId) {
		return smBusiness.archiveSM(smId);
	}
        
        @PutMapping("/restore/{smId}")
	public StockMovement restoreSM(@PathVariable String smId) {
		return smBusiness.restoreSM(smId);
	}
	
	private StockMovement convertToEntity(StockMovementDTO smDTO) {
	    return modelMapper.map(smDTO, StockMovement.class);
	}

}
