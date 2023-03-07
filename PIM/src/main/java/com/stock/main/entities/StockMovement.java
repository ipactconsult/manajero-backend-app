package com.stock.main.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "stockMovement")
@Getter
@Setter
public class StockMovement {
	
	@Id
	private String smId;
	
	private String smCode;
	
	private String smLabel;
	
	private Date dateSM;
	
	private Integer quantitySM;
	
	private Material material;
	
	private String stateSM;
        
        private Boolean activeState;
	
	public StockMovement() {
		super();
	}

    /**
     * @return the smId
     */
    public String getSmId() {
        return smId;
    }

    /**
     * @param smId the smId to set
     */
    public void setSmId(String smId) {
        this.smId = smId;
    }

    /**
     * @return the smCode
     */
    public String getSmCode() {
        return smCode;
    }

    /**
     * @param smCode the smCode to set
     */
    public void setSmCode(String smCode) {
        this.smCode = smCode;
    }

    /**
     * @return the smLabel
     */
    public String getSmLabel() {
        return smLabel;
    }

    /**
     * @param smLabel the smLabel to set
     */
    public void setSmLabel(String smLabel) {
        this.smLabel = smLabel;
    }

    /**
     * @return the dateSM
     */
    public Date getDateSM() {
        return dateSM;
    }

    /**
     * @param dateSM the dateSM to set
     */
    public void setDateSM(Date dateSM) {
        this.dateSM = dateSM;
    }

    /**
     * @return the quantitySM
     */
    public Integer getQuantitySM() {
        return quantitySM;
    }

    /**
     * @param quantitySM the quantitySM to set
     */
    public void setQuantitySM(Integer quantitySM) {
        this.quantitySM = quantitySM;
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
     * @return the stateSM
     */
    public String getStateSM() {
        return stateSM;
    }

    /**
     * @param stateSM the stateSM to set
     */
    public void setStateSM(String stateSM) {
        this.stateSM = stateSM;
    }
    
    /**
     * @return the activeState
     */
    public Boolean getActiveState() {
        return activeState;
    }

    /**
     * @param activeState the activeState to set
     */
    public void setActiveState(Boolean activeState) {
        this.activeState = activeState;
    }
        
        
}
