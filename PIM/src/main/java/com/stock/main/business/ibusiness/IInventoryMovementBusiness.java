package com.stock.main.business.ibusiness;

import com.stock.main.entities.InventoryMovement;
import java.util.List;

public interface IInventoryMovementBusiness {
    
    public List<InventoryMovement> getAllIMs();
    public List<InventoryMovement> getAllIMsASC();
    public List<InventoryMovement> getAllIMsDESC();
    public InventoryMovement getOneIM(String imId);
    public InventoryMovement createIM(InventoryMovement im);
    public InventoryMovement archiveIM(String imId);
    public InventoryMovement restoreIM(String imId);
    public InventoryMovement deleteIM(String imId);
    
}
