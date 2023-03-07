package com.stock.main.controllers;

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

import com.stock.main.business.businessimpl.PurchaseRequisitionBusiness;
import com.stock.main.business.dtos.PurchaseRequisitionDTO;
import com.stock.main.entities.PurchaseRequisition;

@RestController
@RequestMapping("/pr")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class PurchaseRequisitionController {
	
	@Autowired
	private PurchaseRequisitionBusiness prBusiness;
	
	@Autowired
        private ModelMapper modelMapper;
	
	@GetMapping("/all")
	public List<PurchaseRequisition> getAllPR() {
		return prBusiness.getAllPR();
	}
	
	@GetMapping("/all/asc")
	public List<PurchaseRequisition> getAllPRASC() {
		return prBusiness.getAllPRASC();
	}
	
	@GetMapping("/all/desc")
	public List<PurchaseRequisition> getAllPRDESC() {
		return prBusiness.getAllPRDESC();
	}
        
        @GetMapping("/pending-prs")
	public List<PurchaseRequisition> getPendingPRS() {
		return prBusiness.getPendingPRS();
	}
	
	@GetMapping("/show/{prId}")
	public PurchaseRequisition getOnePR(@PathVariable String prId) {
		return prBusiness.getOnePR(prId);
	}
	
	@PostMapping("/create")
	public PurchaseRequisition addNewPR(@RequestBody PurchaseRequisitionDTO prDTO) {
		PurchaseRequisition pr = convertToEntity(prDTO);
		return prBusiness.addNewPR(pr);
	}
	
	@PutMapping("/archive/{prId}")
	public PurchaseRequisition archivePR(@PathVariable String prId) {
		return prBusiness.archivePR(prId);
	}
	
	@PutMapping("/restore/{prId}")
	public PurchaseRequisition restorePR(@PathVariable String prId) {
		return prBusiness.restorePR(prId);
	}
        
        @PutMapping("/approve/{prId}")
	public PurchaseRequisition approvePR(@PathVariable String prId) {
		return prBusiness.approvePR(prId);
	}
        
        @PutMapping("/reject/{prId}")
	public PurchaseRequisition rejectPR(@PathVariable String prId) {
		return prBusiness.rejectPR(prId);
	}
	
	@DeleteMapping("/delete/{prId}")
	public PurchaseRequisition deletePR(@PathVariable String prId) {
		return prBusiness.deletePR(prId);
	}
	
	private PurchaseRequisition convertToEntity(PurchaseRequisitionDTO prDTO) {
	    return modelMapper.map(prDTO, PurchaseRequisition.class);
	}

}
