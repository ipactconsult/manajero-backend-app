package com.stock.main.business.businessimpl;

import com.stock.main.business.ibusiness.IInventoryBusiness;
import com.stock.main.repositories.InventoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stock.main.entities.Inventory;
import com.stock.main.entities.Material;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.data.domain.Sort;

@Service
public class InventoryBusiness implements IInventoryBusiness {

    @Autowired
    private InventoryRepository inventoryRepo;

    @Override
    public List<Inventory> getAllInventories() {
        List<Inventory> inventories = inventoryRepo.findAll(
             Sort.by(Sort.Direction.DESC, "inventoryCreationDate")   
        );
        if (!inventories.isEmpty()) {
            return inventories;
        }
        return new ArrayList<>();
    }

    @Override
    public List<Inventory> getAllInventoriesASC() {
        List<Inventory> inventories = inventoryRepo.findAll(
                Sort.by(Sort.Direction.ASC, "inventoryRef")
        );
        if (!inventories.isEmpty()) {
            return inventories;
        }
        return new ArrayList<>();
    }

    @Override
    public List<Inventory> getAllInventoriesDESC() {
        List<Inventory> inventories = inventoryRepo.findAll(
                Sort.by(Sort.Direction.DESC, "inventoryRef")
        );
        if (!inventories.isEmpty()) {
            return inventories;
        }
        return new ArrayList<>();
    }

    @Override
    public Inventory getOneInventory(String inventoryId) {
        Inventory existedInv = inventoryRepo.findById(inventoryId).orElse(null);
        if (existedInv != null) {
            return existedInv;
        } else {
            return null;
        }
    }

    @Override
    public Inventory createInventory(Inventory inventory) {
        inventory.setInventoryCreationDate(new Date());
        inventory.setInventoryState(true);
        inventoryRepo.save(inventory);
        return inventory;
    }

    @Override
    public Inventory fixInventoryStock(String inventoryId, String materialId) {
        Inventory existedInv = inventoryRepo.findById(inventoryId).orElse(null);
        if (existedInv != null) {
            for (Material material : existedInv.getMaterials()) {
                if (material.getMaterialId().equals(materialId)) {
                    material.setQuantityStock(material.getQuantityReel());
                }
            }
            inventoryRepo.save(existedInv);
            return existedInv;
        } else {
            return null;
        }
    }
    
    @Override
    public Inventory fixInventory(String inventoryId) {
        Inventory existedInv = inventoryRepo.findById(inventoryId).orElse(null);
        if (existedInv != null) {
            existedInv.setInventoryFixed(true);
            inventoryRepo.save(existedInv);
            return existedInv;
        } else {
            return null;
        }
    }

    @Override
    public Inventory archiveInventory(String inventoryId) {
        Inventory existedInv = inventoryRepo.findById(inventoryId).orElse(null);
        if (existedInv != null) {
            existedInv.setInventoryState(false);
            inventoryRepo.save(existedInv);
            return existedInv;
        } else {
            return null;
        }
    }

    @Override
    public Inventory restoreInventory(String inventoryId) {
        Inventory existedInv = inventoryRepo.findById(inventoryId).orElse(null);
        if (existedInv != null) {
            existedInv.setInventoryState(true);
            inventoryRepo.save(existedInv);
            return existedInv;
        } else {
            return null;
        }
    }

    @Override
    public Inventory deleteInventory(String inventoryId) {
        Inventory existedInv = inventoryRepo.findById(inventoryId).orElse(null);
        if (existedInv != null) {
            inventoryRepo.delete(existedInv);
            return existedInv;
        } else {
            return null;
        }
    }

}
