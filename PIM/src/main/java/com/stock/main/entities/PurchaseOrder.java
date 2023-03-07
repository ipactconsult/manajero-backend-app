package com.stock.main.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "purchaseOrder")
@Getter
@Setter
public class PurchaseOrder {

    @Id
    private String poId;

    private String poNumber;

    private Date poCreationDate;

    private Supplier selectedSupplier;

    private Material[] materials;

    private String poStatus;

    private boolean poState;

    private boolean poReceiptState;

    private boolean receiptSupplier;

    private Date receptionDate;
    
    private Date reelRD;
    
    private Boolean mailSent;
    
    private Object addedBy;

    public PurchaseOrder() {
        super();
    }
    
    public Object getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Object addedBy) {
        this.addedBy = addedBy;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
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
     * @return the materials
     */
    public Material[] getMaterials() {
        return materials;
    }

    /**
     * @param materials the materials to set
     */
    public void setMaterials(Material[] materials) {
        this.materials = materials;
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

    public Date getReceptionDate() {
        return receptionDate;
    }
    
    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public String getPoId() {
        return poId;
    }

    public void setPoId(String poId) {
        this.poId = poId;
    }
    
    public Date getReelRD() {
        return reelRD;
    }
    
    public void setReelRD(Date reelRD) {
        this.reelRD = reelRD;
    }

}
