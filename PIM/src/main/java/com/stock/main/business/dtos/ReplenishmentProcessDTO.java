package com.stock.main.business.dtos;

import com.stock.main.entities.PurchaseRequisition;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplenishmentProcessDTO {
    
    private String rpId;
    
    private String rpRef;
    
    private PurchaseRequisition pr;
    
    private Integer step;
    
    private Date rpCreation;
    
    public ReplenishmentProcessDTO() {
	super();
    }

    /**
     * @return the rpId
     */
    public String getRpId() {
        return rpId;
    }

    /**
     * @param rpId the rpId to set
     */
    public void setRpId(String rpId) {
        this.rpId = rpId;
    }

    /**
     * @return the rpRef
     */
    public String getRpRef() {
        return rpRef;
    }

    /**
     * @param rpRef the rpRef to set
     */
    public void setRpRef(String rpRef) {
        this.rpRef = rpRef;
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
     * @return the rpCreation
     */
    public Date getRpCreation() {
        return rpCreation;
    }

    /**
     * @param rpCreation the rpCreation to set
     */
    public void setRpCreation(Date rpCreation) {
        this.rpCreation = rpCreation;
    }
    
    
    
}
