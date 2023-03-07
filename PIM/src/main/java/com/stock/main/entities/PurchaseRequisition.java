package com.stock.main.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "purchaseRequisition")
@Getter
@Setter
public class PurchaseRequisition {
	
	@Id
	private String purchaseRequisitionId;
	
	private String purchaseRequisitionNumber;
	
	private Material[] material;
	
	private String purchaseRequisitionStatus;
	
	private boolean purchaseRequisitionState;
	
	private Date purchaseRequisitionCreationDate;
        
        private Object addedBy;
	
	public PurchaseRequisition() {
		super();
	}

    /**
     * @return the purchaseRequisitionId
     */
    public String getPurchaseRequisitionId() {
        return purchaseRequisitionId;
    }

    /**
     * @param purchaseRequisitionId the purchaseRequisitionId to set
     */
    public void setPurchaseRequisitionId(String purchaseRequisitionId) {
        this.purchaseRequisitionId = purchaseRequisitionId;
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
     * @return the purchaseRequisitionNumber
     */
    public String getPurchaseRequisitionNumber() {
        return purchaseRequisitionNumber;
    }

    /**
     * @param purchaseRequisitionNumber the purchaseRequisitionNumber to set
     */
    public void setPurchaseRequisitionNumber(String purchaseRequisitionNumber) {
        this.purchaseRequisitionNumber = purchaseRequisitionNumber;
    }

    /**
     * @return the material
     */
    public Material[] getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(Material[] material) {
        this.material = material;
    }

    /**
     * @return the purchaseRequisitionStatus
     */
    public String getPurchaseRequisitionStatus() {
        return purchaseRequisitionStatus;
    }

    /**
     * @param purchaseRequisitionStatus the purchaseRequisitionStatus to set
     */
    public void setPurchaseRequisitionStatus(String purchaseRequisitionStatus) {
        this.purchaseRequisitionStatus = purchaseRequisitionStatus;
    }

    /**
     * @return the purchaseRequisitionState
     */
    public boolean isPurchaseRequisitionState() {
        return purchaseRequisitionState;
    }

    /**
     * @param purchaseRequisitionState the purchaseRequisitionState to set
     */
    public void setPurchaseRequisitionState(boolean purchaseRequisitionState) {
        this.purchaseRequisitionState = purchaseRequisitionState;
    }

    /**
     * @return the purchaseRequisitionCreationDate
     */
    public Date getPurchaseRequisitionCreationDate() {
        return purchaseRequisitionCreationDate;
    }

    /**
     * @param purchaseRequisitionCreationDate the purchaseRequisitionCreationDate to set
     */
    public void setPurchaseRequisitionCreationDate(Date purchaseRequisitionCreationDate) {
        this.purchaseRequisitionCreationDate = purchaseRequisitionCreationDate;
    }
        
        
}
