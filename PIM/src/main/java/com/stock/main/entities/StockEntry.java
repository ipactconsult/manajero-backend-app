package com.stock.main.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "stockEntry")
@Getter
@Setter
public class StockEntry {
	
	@Id
	private String stockEntryId;
	
	private String stockEntryRef;
	
	private Material material;
	
	private Integer quantityIn;
	
	private boolean stockEntryState;
	
	private Date stockEntryDate;
	
	public StockEntry() {
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
