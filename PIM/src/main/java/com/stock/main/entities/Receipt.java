package com.stock.main.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "receipt")
@Getter
@Setter
public class Receipt {
	
	@Id
	private String receiptId;
	
	private String receiptRef;
	
	private String notes;
	
	private Date receiptCreationDate;
	
	private boolean receiptState;
	
	private PurchaseOrder purchaseOrder;
        
        private int receiptRate;
        
        public Receipt() {
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

    /**
     * @return the receiptRate
     */
    public int getReceiptRate() {
        return receiptRate;
    }

    /**
     * @param receiptRate the receiptRate to set
     */
    public void setReceiptRate(int receiptRate) {
        this.receiptRate = receiptRate;
    }
        
        

}
