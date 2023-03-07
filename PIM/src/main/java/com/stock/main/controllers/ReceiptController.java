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

import com.stock.main.business.businessimpl.ReceiptBusiness;
import com.stock.main.business.dtos.ReceiptDTO;
import com.stock.main.entities.Receipt;

@RestController
@RequestMapping("/receipt")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class ReceiptController {
	
	@Autowired
	private ReceiptBusiness receiptBusiness;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping("/all")
	public List<Receipt> getAllReceipts() {
		return receiptBusiness.getAllReceipts();
	}
	
	@GetMapping("/all/asc")
	public List<Receipt> getAllReceiptsASC() {
		return receiptBusiness.getAllReceiptsASC();
	}
	
	@GetMapping("/all/desc")
	public List<Receipt> getAllReceiptsDESC() {
		return receiptBusiness.getAllReceiptsDESC();
	}
        
        @GetMapping("/{receiptId}")
	public Receipt getOneReceipt(@PathVariable String receiptId) {
		return receiptBusiness.getOneReceipt(receiptId);
	}
	
	@PostMapping("/create/{currentRate}")
	public Receipt addNewReceipt(
			@RequestBody ReceiptDTO receiptDTO,
                        @PathVariable int currentRate) {
		Receipt receipt = convertToEntity(receiptDTO);
		return receiptBusiness.addNewReceipt(receipt, currentRate);
	}
	
	@PutMapping("/archive/{receiptId}")
	public Receipt archiveReceipt(@PathVariable String receiptId) {
		return receiptBusiness.archiveReceipt(receiptId);
	}
	
	@PutMapping("/restore/{receiptId}")
	public Receipt restoreReceipt(@PathVariable String receiptId) {
		return receiptBusiness.restoreReceipt(receiptId);
	}
	
	private Receipt convertToEntity(ReceiptDTO receiptDTO) {
	    return modelMapper.map(receiptDTO, Receipt.class);
	}

}
