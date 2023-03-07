package com.stock.main.controllers;

import com.stock.main.business.businessimpl.InventoryBusiness;
import com.stock.main.business.dtos.InventoryDTO;
import com.stock.main.entities.Inventory;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/inventory")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class InventoryController {
    
        @Autowired
	private InventoryBusiness inventoryBusiness;
	
	@Autowired
        private ModelMapper modelMapper;
        
        @GetMapping("/all")
        public List<Inventory> getAllInventories() {
            return inventoryBusiness.getAllInventories();
        }
        
        @GetMapping("/all/asc")
        public List<Inventory> getAllInventoriesASC() {
            return inventoryBusiness.getAllInventoriesASC();
        }
        
        @GetMapping("/all/desc")
        public List<Inventory> getAllInventoriesDESC() {
            return inventoryBusiness.getAllInventoriesDESC();
        }
        
        @GetMapping("/{inventoryId}")
        public Inventory getOneInventory(@PathVariable String inventoryId) {
            return inventoryBusiness.getOneInventory(inventoryId);
        }
        
        @PostMapping("/create")
        public Inventory createInventory(@RequestBody InventoryDTO inventoryDTO) {
            Inventory inventory = convertToEntity(inventoryDTO);
            return inventoryBusiness.createInventory(inventory);
        }
        
        @PutMapping("/fix-stock/{inventoryId}/{materialId}")
        public Inventory fixInventoryStock(@PathVariable String inventoryId, @PathVariable String materialId) {
            return inventoryBusiness.fixInventoryStock(inventoryId, materialId);
        }
        
        @PutMapping("/fix/{inventoryId}")
        public Inventory fixInventory(@PathVariable String inventoryId) {
            return inventoryBusiness.fixInventory(inventoryId);
        }
        
        @PutMapping("/archive/{inventoryId}")
        public Inventory archiveInventory(@PathVariable String inventoryId) {
            return inventoryBusiness.archiveInventory(inventoryId);
        }
        
        @PutMapping("/restore/{inventoryId}")
        public Inventory restoreInventory(@PathVariable String inventoryId) {
            return inventoryBusiness.restoreInventory(inventoryId);
        }
        
        @DeleteMapping("/delete/{inventoryId}")
        public Inventory deleteInventory(@PathVariable String inventoryId) {
            return inventoryBusiness.deleteInventory(inventoryId);
        }
        
        private Inventory convertToEntity(InventoryDTO inventoryDTO) {
	    return modelMapper.map(inventoryDTO, Inventory.class);
	}
    
}
