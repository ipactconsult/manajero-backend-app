package com.stock.main.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.main.business.businessimpl.PurchaseOrderBusiness;
import com.stock.main.business.dtos.PurchaseOrderDTO;
import com.stock.main.entities.PurchaseOrder;

@RestController
@RequestMapping("/po")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class PurchaseOrderController {
	
	@Autowired
	private PurchaseOrderBusiness poBusiness;
	
	@Autowired
        private ModelMapper modelMapper;
	
	@GetMapping("/all")
	public List<PurchaseOrder> getAllPOs() {
		return poBusiness.getAllPOs();
	}
	
	@GetMapping("/all/asc")
	public List<PurchaseOrder> getAllPOsASCByCode() {
		return poBusiness.getAllPOsASCByCode();
	}
	
	@GetMapping("/all/desc")
	public List<PurchaseOrder> getAllPOsDESCByCode() {
		return poBusiness.getAllPOsDESCByCode();
	}
        
        @GetMapping("/pending-pos")
	public List<PurchaseOrder> getPendingPOs() {
		return poBusiness.getPendingPOs();
	}
	
	@GetMapping("/show/{poId}")
	public PurchaseOrder getOnePO(@PathVariable String poId) {
		return poBusiness.getOnePO(poId);
	}
	
	@PostMapping("/create")
	public PurchaseOrder addNewPO(@RequestBody PurchaseOrderDTO poDTO) {
		PurchaseOrder po = convertToEntity(poDTO);
		return poBusiness.addNewPO(po);
	}
        
        @PutMapping("/send-mail/{poId}")
	public PurchaseOrder sendMail(@PathVariable String poId) {
		return poBusiness.sendMail(poId);
	}
	
	@PutMapping("/receive/{poId}")
	public PurchaseOrder receivePO(@PathVariable String poId) {
		return poBusiness.receivePO(poId);
	}
	
	@PutMapping("/archive/{poId}")
	public PurchaseOrder archivePO(@PathVariable String poId) {
		return poBusiness.archivePO(poId);
	}
        
        @PutMapping("/restore/{poId}")
	public PurchaseOrder restorePO(@PathVariable String poId) {
		return poBusiness.restorePO(poId);
	}
	
	@PutMapping("/receipt-supplier/{poId}")
	public PurchaseOrder changeReceiptSupplier(@PathVariable String poId) {
		return poBusiness.changeReceiptSupplier(poId);
	}
        
        @PutMapping("/approve/{poId}")
	public String approvePO(@PathVariable String poId) {
		return poBusiness.approvePO(poId);
	}
        
        @PutMapping("/reject/{poId}")
	public String rejectPO(@PathVariable String poId) {
		return poBusiness.rejectPO(poId);
	}
	
	@DeleteMapping("/delete/{poId}")
	public PurchaseOrder deletePO(@PathVariable String poId) {
		return poBusiness.deletePO(poId);
	}
	
	private PurchaseOrder convertToEntity(PurchaseOrderDTO poDTO) {
	    return modelMapper.map(poDTO, PurchaseOrder.class);
	}

}
