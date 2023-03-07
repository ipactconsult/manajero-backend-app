package com.stock.main.business.dtos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierDTO {
	
	private String supplierId;
	
	private String supplierFirstName;
	
	private String supplierLastName;
	
	private String supplierEmail;
        
        private Date supplierCreationDate;
	
	private String supplierCountry;
        
        private String supplierImage;
	
	private boolean supplierState;
        
        private Integer supplierPhone;
        
        private String supplierCurrency;
        
        private String supplierCompany;
        
        private Object addedBy;
	
	public SupplierDTO() {
		super();
	}

    /**
     * @return the supplierFirstName
     */
    public String getSupplierFirstName() {
        return supplierFirstName;
    }

    /**
     * @param supplierFirstName the supplierFirstName to set
     */
    public void setSupplierFirstName(String supplierFirstName) {
        this.supplierFirstName = supplierFirstName;
    }
    
        /**
     * @return the supplierId
     */
    public String getSupplierId() {
        return supplierId;
    }

    /**
     * @param supplierId the supplierId to set
     */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
    
        /**
     * @return the supplierEmail
     */
    public String getSupplierEmail() {
        return supplierEmail;
    }

    /**
     * @param supplierEmail the supplierEmail to set
     */
    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }
    
    /**
     * @return the supplierPhone
     */
    public Integer getSupplierPhone() {
        return supplierPhone;
    }

    /**
     * @param supplierPhone the supplierPhone to set
     */
    public void setSupplierPhone(Integer supplierPhone) {
        this.supplierPhone = supplierPhone;
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
     * @return the supplierLastName
     */
    public String getSupplierLastName() {
        return supplierLastName;
    }

    /**
     * @param supplierLastName the supplierLastName to set
     */
    public void setSupplierLastName(String supplierLastName) {
        this.supplierLastName = supplierLastName;
    }
    
        /**
     * @return the supplierCountry
     */
    public String getSupplierCountry() {
        return supplierCountry;
    }

    /**
     * @param supplierCountry the supplierCountry to set
     */
    public void setSupplierCountry(String supplierCountry) {
        this.supplierCountry = supplierCountry;
    }

    /**
     * @return the supplierState
     */
    public boolean isSupplierState() {
        return supplierState;
    }

    /**
     * @param supplierState the supplierState to set
     */
    public void setSupplierState(boolean supplierState) {
        this.supplierState = supplierState;
    }

    /**
     * @return the supplierCurrency
     */
    public String getSupplierCurrency() {
        return supplierCurrency;
    }

    /**
     * @param supplierCurrency the supplierCurrency to set
     */
    public void setSupplierCurrency(String supplierCurrency) {
        this.supplierCurrency = supplierCurrency;
    }
    
        /**
     * @return the supplierImage
     */
    public String getSupplierImage() {
        return supplierImage;
    }

    /**
     * @param supplierImage the supplierImage to set
     */
    public void setSupplierImage(String supplierImage) {
        this.supplierImage = supplierImage;
    }
    
        /**
     * @return the supplierCompany
     */
    public String getSupplierCompany() {
        return supplierCompany;
    }

    /**
     * @param supplierCompany the supplierCompany to set
     */
    public void setSupplierCompany(String supplierCompany) {
        this.supplierCompany = supplierCompany;
    }
    
        /**
     * @return the supplierCreationDate
     */
    public Date getSupplierCreationDate() {
        return supplierCreationDate;
    }

    /**
     * @param supplierCreationDate the supplierCreationDate to set
     */
    public void setSupplierCreationDate(Date supplierCreationDate) {
        this.supplierCreationDate = supplierCreationDate;
    }
        
        

}
