package com.stock.main.business.dtos;

import java.util.Date;

import com.stock.main.entities.Material;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockEntryDTO {
	
	private String stockEntryId;
	
	private String stockEntryRef;
	
	private Material material;
	
	private Integer quantityIn;
	
	private boolean stockEntryState;
	
	private Date stockEntryDate;
	
	public StockEntryDTO() {
		super();
	}

    /**
     * @return the stockEntryId
     */
    public String getStockEntryId() {
        return stockEntryId;
    }

    /**
     * @param stockEntryId the stockEntryId to set
     */
    public void setStockEntryId(String stockEntryId) {
        this.stockEntryId = stockEntryId;
    }

    /**
     * @return the stockEntryRef
     */
    public String getStockEntryRef() {
        return stockEntryRef;
    }

    /**
     * @param stockEntryRef the stockEntryRef to set
     */
    public void setStockEntryRef(String stockEntryRef) {
        this.stockEntryRef = stockEntryRef;
    }

    /**
     * @return the quantityIn
     */
    public Integer getQuantityIn() {
        return quantityIn;
    }

    /**
     * @param quantityIn the quantityIn to set
     */
    public void setQuantityIn(Integer quantityIn) {
        this.quantityIn = quantityIn;
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
     * @return the stockEntryState
     */
    public boolean isStockEntryState() {
        return stockEntryState;
    }

    /**
     * @param stockEntryState the stockEntryState to set
     */
    public void setStockEntryState(boolean stockEntryState) {
        this.stockEntryState = stockEntryState;
    }

    /**
     * @return the stockEntryDate
     */
    public Date getStockEntryDate() {
        return stockEntryDate;
    }

    /**
     * @param stockEntryDate the stockEntryDate to set
     */
    public void setStockEntryDate(Date stockEntryDate) {
        this.stockEntryDate = stockEntryDate;
    }
        
        

}
