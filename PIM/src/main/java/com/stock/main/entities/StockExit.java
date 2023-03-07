package com.stock.main.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "stockExit")
@Getter
@Setter
public class StockExit {
	
	@Id
	private String stockExitId;
	
	private String stockExitRef;
	
	private Material material;
	
	private Integer quantityOut;
	
	private boolean stockExitState;
	
	private Date stockExitDate;
	
	public StockExit() {
		super();
	}

    /**
     * @return the stockExitId
     */
    public String getStockExitId() {
        return stockExitId;
    }

    /**
     * @param stockExitId the stockExitId to set
     */
    public void setStockExitId(String stockExitId) {
        this.stockExitId = stockExitId;
    }

    /**
     * @return the stockExitRef
     */
    public String getStockExitRef() {
        return stockExitRef;
    }

    /**
     * @param stockExitRef the stockExitRef to set
     */
    public void setStockExitRef(String stockExitRef) {
        this.stockExitRef = stockExitRef;
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
     * @return the quantityOut
     */
    public Integer getQuantityOut() {
        return quantityOut;
    }

    /**
     * @param quantityOut the quantityOut to set
     */
    public void setQuantityOut(Integer quantityOut) {
        this.quantityOut = quantityOut;
    }

    /**
     * @return the stockExitState
     */
    public boolean isStockExitState() {
        return stockExitState;
    }

    /**
     * @param stockExitState the stockExitState to set
     */
    public void setStockExitState(boolean stockExitState) {
        this.stockExitState = stockExitState;
    }

    /**
     * @return the stockExitDate
     */
    public Date getStockExitDate() {
        return stockExitDate;
    }

    /**
     * @param stockExitDate the stockExitDate to set
     */
    public void setStockExitDate(Date stockExitDate) {
        this.stockExitDate = stockExitDate;
    }
        
        

}
