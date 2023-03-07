package com.stock.main.business.businessimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.main.business.ibusiness.IPropertyBusiness;
import com.stock.main.entities.Property;
import com.stock.main.repositories.PropertyRepository;

@Service
public class PropertyBusiness implements IPropertyBusiness {
	
	@Autowired
	private PropertyRepository propertyRepo;
	
	public List<Property> getAllProperties() {
		List<Property> properties = propertyRepo.findAll();
		if (!properties.isEmpty()) {
			return properties;
		}
		return new ArrayList<>();
	}
	
	public Property getOneProperty(String propertyId) {
			if (propertyRepo.findById(propertyId).isPresent()) {
				Property existedProperty = propertyRepo.findById(propertyId).orElse(null);
				if (existedProperty != null) {
					return existedProperty;
				} else {
					return null;
				}
			} else {
				return null;
			}
	}
	
	public Property addNewProperty(Property property) {
			property.setPropertyCreationDate(new Date());
			property.setPropertyState(true);
			int existNumber = 0;
			List<Property> properties = propertyRepo.findAll();
			if (!properties.isEmpty()) {
				for (int m = 0; m < properties.size(); m++) {
					if (properties.get(m).getPropertyName().equals(property.getPropertyName())) {
						existNumber = existNumber + 1;
					}
				}
			}
			if (existNumber == 0) {
				propertyRepo.save(property);
				return property;
			} else {
				return null;
			}
	}
	
	public Property archiveProperty(String propertyId) {
			if (propertyRepo.findById(propertyId).isPresent()) {
				Property existedProperty = propertyRepo.findById(propertyId).orElse(null);
				if (existedProperty != null) {
					existedProperty.setPropertyState(false);
					propertyRepo.save(existedProperty);
					return existedProperty;
				} else {
					return null;
				}
			} else {
				return null;
			}
	}

}
