package com.stock.main.entities;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventoryMovement")
public class InventoryMovement {
    
    @Id
    private String imId;
    
    private String imRef;
    
    private Material material;
    
    private Date imCreationDate;
    
    private Boolean imState;
    
    public InventoryMovement() {
        super();
    }

    /**
     * @return the imId
     */
    public String getImId() {
        return imId;
    }

    /**
     * @param imId the imId to set
     */
    public void setImId(String imId) {
        this.imId = imId;
    }

    /**
     * @return the imRef
     */
    public String getImRef() {
        return imRef;
    }

    /**
     * @param imRef the imRef to set
     */
    public void setImRef(String imRef) {
        this.imRef = imRef;
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
     * @return the imCreationDate
     */
    public Date getImCreationDate() {
        return imCreationDate;
    }

    /**
     * @param imCreationDate the imCreationDate to set
     */
    public void setImCreationDate(Date imCreationDate) {
        this.imCreationDate = imCreationDate;
    }

    /**
     * @return the imState
     */
    public Boolean getImState() {
        return imState;
    }

    /**
     * @param imState the imState to set
     */
    public void setImState(Boolean imState) {
        this.imState = imState;
    }
    
    
    
}
