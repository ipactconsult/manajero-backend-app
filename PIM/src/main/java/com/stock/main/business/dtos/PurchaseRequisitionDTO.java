package com.stock.main.business.dtos;

import java.util.Date;

import com.stock.main.entities.Material;
import com.stock.main.entities.Supplier;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseRequisitionDTO {
	
	private String purchaseRequisitionId;
	
	private String purchaseRequisitionNumber;
	
	private Material[] material;
	
	private Supplier fixedSupplier;
	
	private String purchaseRequisitionStatus;
	
	private boolean purchaseRequisitionState;
        
        private Object addedBy;
	
	private Date purchaseRequisitionCreationDate;
	
	public PurchaseRequisitionDTO() {
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
     * @return the fixedSupplier
     */
    public Supplier getFixedSupplier() {
        return fixedSupplier;
    }

    /**
     * @param fixedSupplier the fixedSupplier to set
     */
    public void setFixedSupplier(Supplier fixedSupplier) {
        this.fixedSupplier = fixedSupplier;
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
