package com.stock.main.business.dtos;

import com.stock.main.entities.Material;
import com.stock.main.entities.PurchaseRequisition;
import com.stock.main.entities.Quotation;
import com.stock.main.entities.RequestForQuotation;
import com.stock.main.entities.Supplier;
import com.stock.main.entities.PurchaseOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseProcessDTO {
    
    private String purchaseProcessId;
    
    private Material[] materials;
    
    private PurchaseRequisition pr;
    
    private RequestForQuotation rfq;
    
    private Quotation[] quotations;
    
    private Supplier supplier;
    
    private PurchaseOrder po;
    
    private Object addedBy;
    
    private Integer step;
    
    private Integer materialsStocked;
    
    public PurchaseProcessDTO() {
	super();
    }

    /**
     * @return the purchaseProcessId
     */
    public String getPurchaseProcessId() {
        return purchaseProcessId;
    }

    /**
     * @param purchaseProcessId the purchaseProcessId to set
     */
    public void setPurchaseProcessId(String purchaseProcessId) {
        this.purchaseProcessId = purchaseProcessId;
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
     * @return the rfq
     */
    public RequestForQuotation getRfq() {
        return rfq;
    }

    /**
     * @param rfq the rfq to set
     */
    public void setRfq(RequestForQuotation rfq) {
        this.rfq = rfq;
    }
    
        /**
     * @return the pr
     */
    public PurchaseRequisition getPr() {
        return pr;
    }

    /**
     * @param pr the pr to set
     */
    public void setPr(PurchaseRequisition pr) {
        this.pr = pr;
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
     * @return the supplier
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
        /**
     * @return the quotations
     */
    public Quotation[] getQuotations() {
        return quotations;
    }

    /**
     * @param quotations the quotations to set
     */
    public void setQuotations(Quotation[] quotations) {
        this.quotations = quotations;
    }

    /**
     * @return the po
     */
    public PurchaseOrder getPo() {
        return po;
    }

    /**
     * @param po the po to set
     */
    public void setPo(PurchaseOrder po) {
        this.po = po;
    }

    /**
     * @return the step
     */
    public Integer getStep() {
        return step;
    }

    /**
     * @param step the step to set
     */
    public void setStep(Integer step) {
        this.step = step;
    }
    
    /**
     * @return the materialsStocked
     */
    public Integer getMaterialsStocked() {
        return materialsStocked;
    }

    /**
     * @param materialsStocked the materialsStocked to set
     */
    public void setMaterialsStocked(Integer materialsStocked) {
        this.materialsStocked = materialsStocked;
    }
    
}
