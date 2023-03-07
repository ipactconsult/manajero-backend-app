package com.stock.main.business.dtos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarehouseDTO {
	
	private String warehouseId;
	
	private String warehouseCode;
	
	private String warehouseLocation;
	
	private String warehouseDesc;
	
	private String warehouseAddress;
	
	private String warehousePostalCode;
	
	private String warehouseCity;
	
	private String warehouseCountry;
	
	private String warehousePhone;
	
	private Date warehouseCreationDate;
	
	private boolean warehouseState;
        
        private Object addedBy;
	
	public WarehouseDTO() {
		super();
	}

    /**
     * @return the warehouseId
     */
    public String getWarehouseId() {
        return warehouseId;
    }

    /**
     * @param warehouseId the warehouseId to set
     */
    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }
    
    /**
     * @return the addedBy
     */
    public Object getAddedBy() {
        return addedBy;
    }

    /**
     * @param addedBy the addedBy to set
     */
    public void setAddedBy(Object addedBy) {
        this.addedBy = addedBy;
    }

    /**
     * @return the warehouseCode
     */
    public String getWarehouseCode() {
        return warehouseCode;
    }

    /**
     * @param warehouseCode the warehouseCode to set
     */
    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    /**
     * @return the warehouseDesc
     */
    public String getWarehouseDesc() {
        return warehouseDesc;
    }

    /**
     * @param warehouseDesc the warehouseDesc to set
     */
    public void setWarehouseDesc(String warehouseDesc) {
        this.warehouseDesc = warehouseDesc;
    }
    
        /**
     * @return the warehouseLocation
     */
    public String getWarehouseLocation() {
        return warehouseLocation;
    }

    /**
     * @param warehouseLocation the warehouseLocation to set
     */
    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }

    /**
     * @return the warehouseAddress
     */
    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    /**
     * @param warehouseAddress the warehouseAddress to set
     */
    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    /**
     * @return the warehousePostalCode
     */
    public String getWarehousePostalCode() {
        return warehousePostalCode;
    }

    /**
     * @param warehousePostalCode the warehousePostalCode to set
     */
    public void setWarehousePostalCode(String warehousePostalCode) {
        this.warehousePostalCode = warehousePostalCode;
    }
    
        /**
     * @return the warehousePhone
     */
    public String getWarehousePhone() {
        return warehousePhone;
    }

    /**
     * @param warehousePhone the warehousePhone to set
     */
    public void setWarehousePhone(String warehousePhone) {
        this.warehousePhone = warehousePhone;
    }

    /**
     * @return the warehouseCountry
     */
    public String getWarehouseCountry() {
        return warehouseCountry;
    }

    /**
     * @param warehouseCountry the warehouseCountry to set
     */
    public void setWarehouseCountry(String warehouseCountry) {
        this.warehouseCountry = warehouseCountry;
    }
    
        /**
     * @return the warehouseCity
     */
    public String getWarehouseCity() {
        return warehouseCity;
    }

    /**
     * @param warehouseCity the warehouseCity to set
     */
    public void setWarehouseCity(String warehouseCity) {
        this.warehouseCity = warehouseCity;
    }
    
        /**
     * @return the warehouseState
     */
    public boolean isWarehouseState() {
        return warehouseState;
    }

    /**
     * @param warehouseState the warehouseState to set
     */
    public void setWarehouseState(boolean warehouseState) {
        this.warehouseState = warehouseState;
    }

    /**
     * @return the warehouseCreationDate
     */
    public Date getWarehouseCreationDate() {
        return warehouseCreationDate;
    }

    /**
     * @param warehouseCreationDate the warehouseCreationDate to set
     */
    public void setWarehouseCreationDate(Date warehouseCreationDate) {
        this.warehouseCreationDate = warehouseCreationDate;
    }
        
        

}
