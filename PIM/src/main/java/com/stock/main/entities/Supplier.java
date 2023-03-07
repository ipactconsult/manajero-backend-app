package com.stock.main.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "supplier")
@Getter
@Setter
public class Supplier {
	
	@Id
	private String supplierId;
	
	private String supplierFirstName;
	
	private String supplierLastName;
	
	private String supplierEmail;
        
        private Integer supplierPhone;
	
	private String supplierCountry;
	
	private String supplierCompany;
	
	private Date supplierCreationDate;
	
	private boolean supplierState;
        
        private String supplierCurrency;
	
	private String supplierImage;
        
        private Object addedBy;
	
	public Supplier() {
		super();
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
        
        

}
