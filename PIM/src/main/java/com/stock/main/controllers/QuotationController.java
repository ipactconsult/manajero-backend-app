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

import com.stock.main.business.businessimpl.QuotationBusiness;
import com.stock.main.business.dtos.QuotationDTO;
import com.stock.main.entities.Quotation;

@RestController
@RequestMapping("/quotation")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class QuotationController {
	
	@Autowired
	private QuotationBusiness quotationBusiness;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping("/all")
	public List<Quotation> getAllQuotations() {
		return quotationBusiness.getAllQuotations();
	}
	
	@GetMapping("/all/asc")
	public List<Quotation> getAllQuotationsASC() {
		return quotationBusiness.getAllQuotationsASC();
	}
	
	@GetMapping("/all/desc")
	public List<Quotation> getAllQuotationsDESC() {
		return quotationBusiness.getAllQuotationsDESC();
	}
	
	@GetMapping("/show/{quotationId}")
	public Quotation getOneQuotation(@PathVariable String quotationId) {
		return quotationBusiness.getOneQuotation(quotationId);
	}
	
	@PostMapping("/create")
	public Quotation addNewQuotation(@RequestBody QuotationDTO quotationDTO) {
		Quotation quotation = convertToEntity(quotationDTO);
		return quotationBusiness.addNewQuotation(quotation);
	}
	
	@PutMapping("/archive/{quotationId}")
	public Quotation archiveQuotation(@PathVariable String quotationId) {
		return quotationBusiness.archiveQuotation(quotationId);
	}
	
	@PutMapping("/restore/{quotationId}")
	public Quotation restoreQuotation(@PathVariable String quotationId) {
		return quotationBusiness.restoreQuotation(quotationId);
	}
	
	@DeleteMapping("/delete/{quotationId}")
	public Quotation deleteQuotation(@PathVariable String quotationId) {
		return quotationBusiness.deleteQuotation(quotationId);
	}
	
	private Quotation convertToEntity(QuotationDTO quotationDTO) {
	    return modelMapper.map(quotationDTO, Quotation.class);
	}

}
