package com.stock.main.business.dtos;

import java.util.Date;

import com.stock.main.entities.PurchaseOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceiptDTO {
	
	private String receiptId;
	
	private String receiptRef;
	
	private String notes;
	
	private Date receiptCreationDate;
	
	private Date receptionDate;
	
	private boolean receiptState;
	
	private PurchaseOrder purchaseOrder;
        
        public ReceiptDTO() {
            super();
        }

    /**
     * @return the receiptId
     */
    public String getReceiptId() {
        return receiptId;
    }

    /**
     * @param receiptId the receiptId to set
     */
    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }

    /**
     * @return the receiptRef
     */
    public String getReceiptRef() {
        return receiptRef;
    }

    /**
     * @param receiptRef the receiptRef to set
     */
    public void setReceiptRef(String receiptRef) {
        this.receiptRef = receiptRef;
    }

    /**
     * @return the receiptCreationDate
     */
    public Date getReceiptCreationDate() {
        return receiptCreationDate;
    }

    /**
     * @param receiptCreationDate the receiptCreationDate to set
     */
    public void setReceiptCreationDate(Date receiptCreationDate) {
        this.receiptCreationDate = receiptCreationDate;
    }
    
        /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return the receiptState
     */
    public boolean isReceiptState() {
        return receiptState;
    }

    /**
     * @param receiptState the receiptState to set
     */
    public void setReceiptState(boolean receiptState) {
        this.receiptState = receiptState;
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

    /**
     * @return the purchaseOrder
     */
    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    /**
     * @param purchaseOrder the purchaseOrder to set
     */
    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
        
        

}
