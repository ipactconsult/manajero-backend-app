package com.stock.main.business.dtos;

import java.util.Date;

import com.stock.main.entities.Material;
import com.stock.main.entities.Supplier;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseOrderDTO {
	
	private String poId;
	
	private String poNumber;
	
	private Supplier selectedSupplier;
	
	private Material[] materials;
	
	private String poStatus;
	
	private boolean poState;
        
        private boolean receiptSupplier;
	
	private boolean poReceiptState;
        
        private Object addedBy;
        
        private Date reelRD;
	
	private Date receptionDate;
        
        private Date poCreationDate;
        
        private Boolean mailSent;
	
	public PurchaseOrderDTO() {
		super();
	}
        
    public Date getReelRD() {
        return reelRD;
    }
    
    public void setReelRD(Date reelRD) {
        this.reelRD = reelRD;
    }

    /**
     * @return the poCreationDate
     */
    public Date getPoCreationDate() {
        return poCreationDate;
    }

    /**
     * @param poCreationDate the poCreationDate to set
     */
    public void setPoCreationDate(Date poCreationDate) {
        this.poCreationDate = poCreationDate;
    }
    
        /**
     * @return the poId
     */
    public String getPoId() {
        return poId;
    }

    /**
     * @param poId the poId to set
     */
    public void setPoId(String poId) {
        this.poId = poId;
    }

    /**
     * @return the materials
     */
    public Material[] getMaterials() {
        return materials;
    }
    
    /**
     * @return the mailSent
     */
    public Boolean isMailSent() {
        return mailSent;
    }

    /**
     * @param mailSent the mailSent to set
     */
    public void setMailSent(Boolean mailSent) {
        this.mailSent = mailSent;
    }

    /**
     * @param materials the materials to set
     */
    public void setMaterials(Material[] materials) {
        this.materials = materials;
    }
    
    public Object getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Object addedBy) {
        this.addedBy = addedBy;
    }
    
            /**
     * @return the poNumber
     */
    public String getPoNumber() {
        return poNumber;
    }

    /**
     * @param poNumber the poNumber to set
     */
    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }
    
        /**
     * @return the selectedSupplier
     */
    public Supplier getSelectedSupplier() {
        return selectedSupplier;
    }

    /**
     * @param selectedSupplier the selectedSupplier to set
     */
    public void setSelectedSupplier(Supplier selectedSupplier) {
        this.selectedSupplier = selectedSupplier;
    }

    /**
     * @return the poState
     */
    public boolean isPoState() {
        return poState;
    }

    /**
     * @param poState the poState to set
     */
    public void setPoState(boolean poState) {
        this.poState = poState;
    }
    
        /**
     * @return the poStatus
     */
    public String getPoStatus() {
        return poStatus;
    }

    /**
     * @param poStatus the poStatus to set
     */
    public void setPoStatus(String poStatus) {
        this.poStatus = poStatus;
    }

    /**
     * @return the poReceiptState
     */
    public boolean isPoReceiptState() {
        return poReceiptState;
    }

    /**
     * @param poReceiptState the poReceiptState to set
     */
    public void setPoReceiptState(boolean poReceiptState) {
        this.poReceiptState = poReceiptState;
    }

    /**
     * @return the receiptSupplier
     */
    public boolean isReceiptSupplier() {
        return receiptSupplier;
    }

    /**
     * @param receiptSupplier the receiptSupplier to set
     */
    public void setReceiptSupplier(boolean receiptSupplier) {
        this.receiptSupplier = receiptSupplier;
    }

    /**
     * @return the receptionDate
     */
    public Date getReceptionDate() {
        return receptionDate;
    }

    /**
     * @param receptionDate the receptionDate to set
     */
    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }
        
        
}
