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

import com.stock.main.business.businessimpl.PropertyBusiness;
import com.stock.main.business.dtos.PropertyDTO;
import com.stock.main.entities.Property;

@RestController
@RequestMapping("/property")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class PropertyController {
	
	@Autowired
	private PropertyBusiness propertyBusiness;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping("/all")
	public List<Property> getAllProperties() {
		return propertyBusiness.getAllProperties();
	}
	
	@GetMapping("/show/{propertyId}")
	public Property getOneProperty(@PathVariable String propertyId) {
		return propertyBusiness.getOneProperty(propertyId);
	}
	
	@PostMapping("/create")
	public Property addNewProperty(@RequestBody PropertyDTO propertyDTO) {
		Property property = convertToEntity(propertyDTO);
		return propertyBusiness.addNewProperty(property);
	}
	
	@PutMapping("/archive/{propertyId}")
	public Property archiveProperty(@PathVariable String propertyId) {
		return propertyBusiness.archiveProperty(propertyId);
	}
	
	private Property convertToEntity(PropertyDTO propertyDTO) {
	    return modelMapper.map(propertyDTO, Property.class);
	}

}
