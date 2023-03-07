package com.stock.main.business.ibusiness;

import com.stock.main.entities.Inventory;
import java.util.List;

public interface IInventoryBusiness {
    
    public List<Inventory> getAllInventories();
    public List<Inventory> getAllInventoriesASC();
    public List<Inventory> getAllInventoriesDESC();
    public Inventory getOneInventory(String inventoryId);
    public Inventory createInventory(Inventory inventory);
    public Inventory fixInventoryStock(String inventoryId, String materialId);
    public Inventory fixInventory(String inventoryId);
    public Inventory archiveInventory(String inventoryId);
    public Inventory restoreInventory(String inventoryId);
    public Inventory deleteInventory(String inventoryId);
    
}
