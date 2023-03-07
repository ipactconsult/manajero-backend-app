package com.stock.main.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "purchase-return")
@Getter
@Setter
public class PurchaseReturn {
	
	@Id
	private String purchaseReturnId;
	
	private String purchaseReturnRef;
	
	private Material material;
	
	private String reason;
	
	private Date purchaseReturnDate;
	
	private boolean purchaseReturnState;
	
	public PurchaseReturn() {
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
        
        

}
