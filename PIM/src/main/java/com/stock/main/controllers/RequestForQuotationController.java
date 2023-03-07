package com.stock.main.controllers;

import java.util.List;

import javax.mail.MessagingException;

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

import com.stock.main.business.businessimpl.RequestForQuotationBusiness;
import com.stock.main.business.dtos.RequestForQuotationDTO;
import com.stock.main.entities.RequestForQuotation;

@RestController
@RequestMapping("/rfq")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class RequestForQuotationController {
	
	@Autowired
	private RequestForQuotationBusiness rfqBusiness;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping("/all")
	public List<RequestForQuotation> getAllRFQ() {
		return rfqBusiness.getAllRFQ();
	}
	
	@GetMapping("/all/asc")
	public List<RequestForQuotation> getAllRFQASC() {
		return rfqBusiness.getAllRFQASC();
	}
	
	@GetMapping("/all/desc")
	public List<RequestForQuotation> getAllRFQDESC() {
		return rfqBusiness.getAllRFQDESC();
	}
	
	@GetMapping("/show/{rfqId}")
	public RequestForQuotation getOneRFQ(@PathVariable String rfqId) {
		return rfqBusiness.getOneRFQ(rfqId);
	}
	
	@PostMapping("/create")
	public RequestForQuotation addNewRFQ(@RequestBody RequestForQuotationDTO rfqDTO) 
			throws MessagingException {
		RequestForQuotation rfq = convertToEntity(rfqDTO);
		return rfqBusiness.addNewRFQ(rfq);
	}
	
	@PutMapping("/archive/{rfqId}")
	public RequestForQuotation archiveRFQ(@PathVariable String rfqId) {
		return rfqBusiness.archiveRFQ(rfqId);
	}
	
	@PutMapping("/restore/{rfqId}")
	public RequestForQuotation restoreRFQ(@PathVariable String rfqId) {
		return rfqBusiness.restoreRFQ(rfqId);
	}
	
	@DeleteMapping("/delete/{rfqId}")
	public RequestForQuotation deleteRFQ(@PathVariable String rfqId) {
		return rfqBusiness.deleteRFQ(rfqId);
	}
	
	private RequestForQuotation convertToEntity(RequestForQuotationDTO rfqDTO) {
	    return modelMapper.map(rfqDTO, RequestForQuotation.class);
	}

}
