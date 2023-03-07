package com.stock.main.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.main.business.businessimpl.PurchaseReturnBusiness;
import com.stock.main.business.dtos.PurchaseReturnDTO;
import com.stock.main.entities.PurchaseReturn;

@RestController
@RequestMapping("/purchase-return")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class PurchaseReturnController {
	
	@Autowired
	private PurchaseReturnBusiness purchaseReturnBusiness;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping("/all")
	public List<PurchaseReturn> getAllPurchaseReturns() {
		return purchaseReturnBusiness.getAllPurchaseReturns();
	}
	
	@GetMapping("/all/asc")
	public List<PurchaseReturn> getAllPurchaseReturnsASC() {
		return purchaseReturnBusiness.getAllPurchaseReturnsASC();
	}
	
	@GetMapping("/all/desc")
	public List<PurchaseReturn> getAllPurchaseReturnsDESC() {
		return purchaseReturnBusiness.getAllPurchaseReturnsDESC();
	}
	
	@GetMapping("/show/{purchaseReturnId}")
	public PurchaseReturn getOnePurchaseReturn(@PathVariable String purchaseReturnId) {
		return purchaseReturnBusiness.getOnePurchaseReturn(purchaseReturnId);
	}
	
	@PostMapping("/create")
	public PurchaseReturn addNewPurchaseReturn(
			@RequestBody PurchaseReturnDTO purchaseReturnDTO) {
		PurchaseReturn pr = convertToEntity(purchaseReturnDTO);
		return purchaseReturnBusiness.addNewPurchaseReturn(pr);
	}
	
	@PutMapping("/archive/{purchaseReturnId}")
	public PurchaseReturn archivePurchaseReturn(@PathVariable String purchaseReturnId) {
		return purchaseReturnBusiness.archivePurchaseReturn(purchaseReturnId);
	}
	
	@PutMapping("/restore/{purchaseReturnId}")
	public PurchaseReturn restorePurchaseReturn(@PathVariable String purchaseReturnId) {
		return purchaseReturnBusiness.restorePurchaseReturn(purchaseReturnId);
	}
	
	private PurchaseReturn convertToEntity(PurchaseReturnDTO purchaseReturnDTO) {
	    return modelMapper.map(purchaseReturnDTO, PurchaseReturn.class);
	}

}
