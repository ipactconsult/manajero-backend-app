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

import com.stock.main.business.businessimpl.SupplierBusiness;
import com.stock.main.business.dtos.SupplierDTO;
import com.stock.main.entities.Supplier;

@RestController
@RequestMapping("/supplier")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class SupplierController {
	
	@Autowired
	private SupplierBusiness supplierBusiness;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping("/all")
	public List<Supplier> getAllSuppliers() {
		return supplierBusiness.getAllSuppliers();
	}
	
	@GetMapping("/all/asc")
	public List<Supplier> getAllSuppliersASC() {
		return supplierBusiness.getAllSuppliersASC();
	}
	
	@GetMapping("/all/desc")
	public List<Supplier> getAllSuppliersDESC() {
		return supplierBusiness.getAllSuppliersDESC();
	}
	
	@GetMapping("/show/{supplierId}")
	public Supplier getOneSupplier(@PathVariable String supplierId) {
		return supplierBusiness.getOneSupplier(supplierId);
	}
	
	@PostMapping("/create")
	public Supplier addNewSupplier(@RequestBody SupplierDTO supplierDTO) {
		Supplier supplier = convertToEntity(supplierDTO);
		return supplierBusiness.addNewSupplier(supplier);
	}
	
	@PutMapping("/edit/{supplierId}")
	public String updateSupplier(@RequestBody SupplierDTO supplierDTO,
			@PathVariable String supplierId) {
		Supplier supplier = convertToEntity(supplierDTO);
		return supplierBusiness.updateSupplier(supplier, supplierId);
	}
	
	@PutMapping("/archive/{supplierId}")
	public Supplier archiveSupplier(@PathVariable String supplierId) {
		return supplierBusiness.archiveSupplier(supplierId);
	}
	
	@PutMapping("/restore/{supplierId}")
	public Supplier restoreSupplier(@PathVariable String supplierId) {
		return supplierBusiness.restoreSupplier(supplierId);
	}
	
	private Supplier convertToEntity(SupplierDTO supplierDTO) {
	    return modelMapper.map(supplierDTO, Supplier.class);
	}

}
