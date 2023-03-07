package com.stock.main.entities;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventory")
@Getter
@Setter
public class Inventory {
    
    @Id
    private String inventoryId;
    
    private String inventoryRef;
    
    private Material[] materials;
    
    private Date inventoryCreationDate;
    
    private Date inventoryDate;
    
    private Boolean inventoryState;
    
    private Boolean inventoryFixed;
    
    private Integer counting;
    
    private Object addedBy;
    
    public Inventory() {
        super();
    }

    /**
     * @return the inventoryId
     */
    public String getInventoryId() {
        return inventoryId;
    }

    /**
     * @param inventoryId the inventoryId to set
     */
    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
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
     * @return the inventoryRef
     */
    public String getInventoryRef() {
        return inventoryRef;
    }

    /**
     * @param inventoryRef the inventoryRef to set
     */
    public void setInventoryRef(String inventoryRef) {
        this.inventoryRef = inventoryRef;
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
     * @return the inventoryDate
     */
    public Date getInventoryDate() {
        return inventoryDate;
    }

    /**
     * @param inventoryDate the inventoryDate to set
     */
    public void setInventoryDate(Date inventoryDate) {
        this.inventoryDate = inventoryDate;
    }
    
    /**
     * @return the inventoryCreationDate
     */
    public Date getInventoryCreationDate() {
        return inventoryCreationDate;
    }

    /**
     * @param inventoryCreationDate the inventoryCreationDate to set
     */
    public void setInventoryCreationDate(Date inventoryCreationDate) {
        this.inventoryCreationDate = inventoryCreationDate;
    }

    /**
     * @return the inventoryState
     */
    public Boolean getInventoryState() {
        return inventoryState;
    }

    /**
     * @param inventoryState the inventoryState to set
     */
    public void setInventoryState(Boolean inventoryState) {
        this.inventoryState = inventoryState;
    }
    
    /**
     * @return the inventoryFixed
     */
    public Boolean getInventoryFixed() {
        return inventoryFixed;
    }

    /**
     * @param inventoryFixed the inventoryFixed to set
     */
    public void setInventoryFixed(Boolean inventoryFixed) {
        this.inventoryFixed = inventoryFixed;
    }

    /**
     * @return the counting
     */
    public Integer getCounting() {
        return counting;
    }

    /**
     * @param counting the counting to set
     */
    public void setCounting(Integer counting) {
        this.counting = counting;
    }
    
    
    
}
