package com.stock.main.business.dtos;

import java.util.Date;

import com.stock.main.entities.Material;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseReturnDTO {
	
	private String purchaseReturnId;
	
	private String purchaseReturnRef;
	
	private Material material;
	
	private String reason;
	
	private Date purchaseReturnDate;
	
	private boolean purchaseReturnState;
	
	public PurchaseReturnDTO() {
		super();
	}

    /**
     * @return the purchaseReturnId
     */
    public String getPurchaseReturnId() {
        return purchaseReturnId;
    }

    /**
     * @param purchaseReturnId the purchaseReturnId to set
     */
    public void setPurchaseReturnId(String purchaseReturnId) {
        this.purchaseReturnId = purchaseReturnId;
    }

    /**
     * @return the purchaseReturnRef
     */
    public String getPurchaseReturnRef() {
        return purchaseReturnRef;
    }

    /**
     * @param purchaseReturnRef the purchaseReturnRef to set
     */
    public void setPurchaseReturnRef(String purchaseReturnRef) {
        this.purchaseReturnRef = purchaseReturnRef;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }
    
        /**
     * @return the material
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * @return the purchaseReturnState
     */
    public boolean isPurchaseReturnState() {
        return purchaseReturnState;
    }

    /**
     * @param purchaseReturnState the purchaseReturnState to set
     */
    public void setPurchaseReturnState(boolean purchaseReturnState) {
        this.purchaseReturnState = purchaseReturnState;
    }
    
        /**
     * @return the purchaseReturnDate
     */
    public Date getPurchaseReturnDate() {
        return purchaseReturnDate;
    }

    /**
     * @param purchaseReturnDate the purchaseReturnDate to set
     */
    public void setPurchaseReturnDate(Date purchaseReturnDate) {
        this.purchaseReturnDate = purchaseReturnDate;
    }
        
        

}
