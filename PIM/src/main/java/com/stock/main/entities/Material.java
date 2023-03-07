package com.stock.main.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Document(collection = "material")
@Getter
@Setter
public class Material {
	
	@Id
	private String materialId;
	
	private String materialType;
	
	private String materialName;
	
	private String materialSKU;
	
	private Category materialCategory;
	
	private String materialBarcode;
	
	private Integer materialPrice;
	
	private Integer sellingPrice;
	
	private Integer materialVAT;
	
	private Integer materialQuantity;
	
	private Date materialCreationDate;
	
	private Date materialDeliveryDate;
	
	private Boolean materialState;
	
	private Integer quantityStock;
	
	private Integer quantityOut;
        
        private Integer quantityReel;
	
	private Integer stockAlert;
        
        private Integer stockMax;
	
	private Supplier supplier;
	
	private Warehouse warehouse;
	
	private Boolean receiptState;
	
	private Boolean stockState;
	
	private Boolean sellState;
        
        private Boolean replenished;
        
        private Object[] personnas;
        
        private Object addedBy;
	
	public Material() {
		super();
	}

    /**
     * @return the materialId
     */
    public String getMaterialId() {
        return materialId;
    }

    /**
     * @param materialId the materialId to set
     */
    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    /**
     * @return the materialType
     */
    public String getMaterialType() {
        return materialType;
    }

    /**
     * @param materialType the materialType to set
     */
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    /**
     * @return the materialName
     */
    public String getMaterialName() {
        return materialName;
    }

    /**
     * @param materialName the materialName to set
     */
    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    /**
     * @return the materialSKU
     */
    public String getMaterialSKU() {
        return materialSKU;
    }

    /**
     * @param materialSKU the materialSKU to set
     */
    public void setMaterialSKU(String materialSKU) {
        this.materialSKU = materialSKU;
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
     * @return the materialCategory
     */
    public Category getMaterialCategory() {
        return materialCategory;
    }

    /**
     * @param materialCategory the materialCategory to set
     */
    public void setMaterialCategory(Category materialCategory) {
        this.materialCategory = materialCategory;
    }

    /**
     * @return the materialBarcode
     */
    public String getMaterialBarcode() {
        return materialBarcode;
    }

    /**
     * @param materialBarcode the materialBarcode to set
     */
    public void setMaterialBarcode(String materialBarcode) {
        this.materialBarcode = materialBarcode;
    }

    /**
     * @return the materialPrice
     */
    public Integer getMaterialPrice() {
        return materialPrice;
    }

    /**
     * @param materialPrice the materialPrice to set
     */
    public void setMaterialPrice(Integer materialPrice) {
        this.materialPrice = materialPrice;
    }

    /**
     * @return the sellingPrice
     */
    public Integer getSellingPrice() {
        return sellingPrice;
    }

    /**
     * @param sellingPrice the sellingPrice to set
     */
    public void setSellingPrice(Integer sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    /**
     * @return the materialVAT
     */
    public Integer getMaterialVAT() {
        return materialVAT;
    }

    /**
     * @param materialVAT the materialVAT to set
     */
    public void setMaterialVAT(Integer materialVAT) {
        this.materialVAT = materialVAT;
    }

    /**
     * @return the materialQuantity
     */
    public Integer getMaterialQuantity() {
        return materialQuantity;
    }

    /**
     * @param materialQuantity the materialQuantity to set
     */
    public void setMaterialQuantity(Integer materialQuantity) {
        this.materialQuantity = materialQuantity;
    }

    /**
     * @return the materialCreationDate
     */
    public Date getMaterialCreationDate() {
        return materialCreationDate;
    }

    /**
     * @param materialCreationDate the materialCreationDate to set
     */
    public void setMaterialCreationDate(Date materialCreationDate) {
        this.materialCreationDate = materialCreationDate;
    }

    /**
     * @return the materialDeliveryDate
     */
    public Date getMaterialDeliveryDate() {
        return materialDeliveryDate;
    }

    /**
     * @param materialDeliveryDate the materialDeliveryDate to set
     */
    public void setMaterialDeliveryDate(Date materialDeliveryDate) {
        this.materialDeliveryDate = materialDeliveryDate;
    }

    /**
     * @return the materialState
     */
    public Boolean getMaterialState() {
        return materialState;
    }

    /**
     * @param materialState the materialState to set
     */
    public void setMaterialState(Boolean materialState) {
        this.materialState = materialState;
    }

    /**
     * @return the quantityStock
     */
    public Integer getQuantityStock() {
        return quantityStock;
    }

    /**
     * @param quantityStock the quantityStock to set
     */
    public void setQuantityStock(Integer quantityStock) {
        this.quantityStock = quantityStock;
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
     * @return the quantityReel
     */
    public Integer getQuantityReel() {
        return quantityReel;
    }

    /**
     * @param quantityReel the quantityReel to set
     */
    public void setQuantityReel(Integer quantityReel) {
        this.quantityReel = quantityReel;
    }

    /**
     * @return the stockAlert
     */
    public Integer getStockAlert() {
        return stockAlert;
    }

    /**
     * @param stockAlert the stockAlert to set
     */
    public void setStockAlert(Integer stockAlert) {
        this.stockAlert = stockAlert;
    }

    /**
     * @return the stockMax
     */
    public Integer getStockMax() {
        return stockMax;
    }

    /**
     * @param stockMax the stockMax to set
     */
    public void setStockMax(Integer stockMax) {
        this.stockMax = stockMax;
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
     * @return the warehouse
     */
    public Warehouse getWarehouse() {
        return warehouse;
    }

    /**
     * @param warehouse the warehouse to set
     */
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    /**
     * @return the receiptState
     */
    public Boolean getReceiptState() {
        return receiptState;
    }

    /**
     * @param receiptState the receiptState to set
     */
    public void setReceiptState(Boolean receiptState) {
        this.receiptState = receiptState;
    }
    
    /**
     * @return the personnas
     */
    public Object[] getPersonnas() {
        return personnas;
    }

    /**
     * @param personnas the personnas to set
     */
    public void setPersonnas(Object[] personnas) {
        this.personnas = personnas;
    }

    /**
     * @return the stockState
     */
    public Boolean getStockState() {
        return stockState;
    }

    /**
     * @param stockState the stockState to set
     */
    public void setStockState(Boolean stockState) {
        this.stockState = stockState;
    }

    /**
     * @return the sellState
     */
    public Boolean getSellState() {
        return sellState;
    }

    /**
     * @param sellState the sellState to set
     */
    public void setSellState(Boolean sellState) {
        this.sellState = sellState;
    }

    /**
     * @return the replenished
     */
    public Boolean getReplenished() {
        return replenished;
    }

    /**
     * @param replenished the replenished to set
     */
    public void setReplenished(Boolean replenished) {
        this.replenished = replenished;
    }
        
        
}
