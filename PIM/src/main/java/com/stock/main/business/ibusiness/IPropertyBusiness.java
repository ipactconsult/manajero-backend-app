package com.stock.main.business.ibusiness;

import java.util.List;

import com.stock.main.entities.Property;

public interface IPropertyBusiness {
	
	public List<Property> getAllProperties();
	public Property getOneProperty(String propertyId);
	public Property addNewProperty(Property property);
	public Property archiveProperty(String propertyId);

}
