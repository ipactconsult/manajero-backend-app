package com.stock.main.business.dtos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {
	
	private String propertyId;
	
	private String propertyReference;
	
	private String propertyName;
	
	private Integer propertyPrice;
	
	private String propertyCurrency;
	
	private String propertySurface;
	
	private String saleOrRental;
	
	private Integer propertyPieces;
	
	private Integer propertyRooms;
	
	private String propertyCity;
	
	private String propertyCountry;
	
	private Integer propertyTax;
	
	private String[] otherPropFeatures;
	
	private Date propertyCreationDate;
	
	private boolean propertyState;
	
	public PropertyDTO() {
		super();
	}

    /**
     * @return the propertyId
     */
    public String getPropertyId() {
        return propertyId;
    }

    /**
     * @param propertyId the propertyId to set
     */
    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    /**
     * @return the propertyName
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * @param propertyName the propertyName to set
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
    
        /**
     * @return the propertyReference
     */
    public String getPropertyReference() {
        return propertyReference;
    }

    /**
     * @param propertyReference the propertyReference to set
     */
    public void setPropertyReference(String propertyReference) {
        this.propertyReference = propertyReference;
    }

    /**
     * @return the propertyCurrency
     */
    public String getPropertyCurrency() {
        return propertyCurrency;
    }

    /**
     * @param propertyCurrency the propertyCurrency to set
     */
    public void setPropertyCurrency(String propertyCurrency) {
        this.propertyCurrency = propertyCurrency;
    }
    
        /**
     * @return the propertyPrice
     */
    public Integer getPropertyPrice() {
        return propertyPrice;
    }

    /**
     * @param propertyPrice the propertyPrice to set
     */
    public void setPropertyPrice(Integer propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    /**
     * @return the saleOrRental
     */
    public String getSaleOrRental() {
        return saleOrRental;
    }

    /**
     * @param saleOrRental the saleOrRental to set
     */
    public void setSaleOrRental(String saleOrRental) {
        this.saleOrRental = saleOrRental;
    }
    
        /**
     * @return the propertySurface
     */
    public String getPropertySurface() {
        return propertySurface;
    }

    /**
     * @param propertySurface the propertySurface to set
     */
    public void setPropertySurface(String propertySurface) {
        this.propertySurface = propertySurface;
    }

    /**
     * @return the propertyRooms
     */
    public Integer getPropertyRooms() {
        return propertyRooms;
    }

    /**
     * @param propertyRooms the propertyRooms to set
     */
    public void setPropertyRooms(Integer propertyRooms) {
        this.propertyRooms = propertyRooms;
    }
    
        /**
     * @return the propertyPieces
     */
    public Integer getPropertyPieces() {
        return propertyPieces;
    }

    /**
     * @param propertyPieces the propertyPieces to set
     */
    public void setPropertyPieces(Integer propertyPieces) {
        this.propertyPieces = propertyPieces;
    }

    /**
     * @return the propertyCountry
     */
    public String getPropertyCountry() {
        return propertyCountry;
    }

    /**
     * @param propertyCountry the propertyCountry to set
     */
    public void setPropertyCountry(String propertyCountry) {
        this.propertyCountry = propertyCountry;
    }
    
        /**
     * @return the propertyCity
     */
    public String getPropertyCity() {
        return propertyCity;
    }

    /**
     * @param propertyCity the propertyCity to set
     */
    public void setPropertyCity(String propertyCity) {
        this.propertyCity = propertyCity;
    }

    /**
     * @return the otherPropFeatures
     */
    public String[] getOtherPropFeatures() {
        return otherPropFeatures;
    }

    /**
     * @param otherPropFeatures the otherPropFeatures to set
     */
    public void setOtherPropFeatures(String[] otherPropFeatures) {
        this.otherPropFeatures = otherPropFeatures;
    }
    
        /**
     * @return the propertyTax
     */
    public Integer getPropertyTax() {
        return propertyTax;
    }

    /**
     * @param propertyTax the propertyTax to set
     */
    public void setPropertyTax(Integer propertyTax) {
        this.propertyTax = propertyTax;
    }

    /**
     * @return the propertyState
     */
    public boolean isPropertyState() {
        return propertyState;
    }

    /**
     * @param propertyState the propertyState to set
     */
    public void setPropertyState(boolean propertyState) {
        this.propertyState = propertyState;
    }
    
        /**
     * @return the propertyCreationDate
     */
    public Date getPropertyCreationDate() {
        return propertyCreationDate;
    }

    /**
     * @param propertyCreationDate the propertyCreationDate to set
     */
    public void setPropertyCreationDate(Date propertyCreationDate) {
        this.propertyCreationDate = propertyCreationDate;
    }
        
        

}
