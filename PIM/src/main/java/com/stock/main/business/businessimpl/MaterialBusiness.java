package com.stock.main.business.businessimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stock.main.business.ibusiness.IMaterialBusiness;
import com.stock.main.repositories.MaterialRepository;
import com.stock.main.repositories.PurchaseOrderRepository;
import com.stock.main.repositories.WarehouseRepository;
import com.stock.main.entities.Material;
import com.stock.main.entities.PurchaseOrder;
import com.stock.main.entities.Warehouse;
import com.stock.main.entities.Category;
import com.stock.main.entities.Inventory;
import com.stock.main.repositories.InventoryRepository;

@Service
public class MaterialBusiness implements IMaterialBusiness {
	
	@Autowired
	private MaterialRepository materialRepo;
	
	@Autowired
	private PurchaseOrderRepository poRepo;
	
	@Autowired
	private WarehouseRepository warehouseRepo;
        
        @Autowired
	private InventoryRepository invRepo;
        
        String finishedProduct = "Finished Product";
        
        String rawMaterial = "Raw Material";
	
        @Override
	public List<Material> getAllMaterials() {
		List<Material> materials = materialRepo.findAll(
                        Sort.by(Sort.Direction.DESC, "materialCreationDate")
                );
		if (!materials.isEmpty()) {
			return materials;
		}
		return new ArrayList<>();
	}
	
        @Override
	public List<Material> getAllMaterialsASC() {
		List<Material> materials = materialRepo.findAll(
				Sort.by(Sort.Direction.ASC, "materialName"));
		if (!materials.isEmpty()) {
			return materials;
		}
		return new ArrayList<>();
	}
	
        @Override
	public List<Material> getAllMaterialsDESC() {
		List<Material> materials = materialRepo.findAll(
				Sort.by(Sort.Direction.DESC, "materialName"));
		if (!materials.isEmpty()) {
			return materials;
		}
		return new ArrayList<>();
	}
        
        @Override
        public List<Material> getStockedMaterials() {
            List<Material> stockedMaterials = new ArrayList<>();
            List<Material> materials = materialRepo.findAll();
            Material materialToFill = new Material();
            Category categoryToFill = new Category();
            for (int m = 0; m < materials.size(); m++) {
                if ((materials.get(m).getMaterialType().equals(finishedProduct)
                        || materials.get(m).getMaterialType().equals("Raw Material"))
                        && materials.get(m).getQuantityStock() != null
			&& materials.get(m).getQuantityStock() != 0
                        && materials.get(m).getMaterialState()
                        && !materials.get(m).getSellState()) {
                    categoryToFill.setCategoryState(null);
                    categoryToFill.setCategoryName(materials.get(m).getMaterialCategory().getCategoryName());
                    categoryToFill.setCategoryDesc(materials.get(m).getMaterialCategory().getCategoryDesc());
                    materialToFill.setMaterialName(materials.get(m).getMaterialName());
                    materialToFill.setMaterialType(materials.get(m).getMaterialType());
                    materialToFill.setMaterialId(materials.get(m).getMaterialId());
                    materialToFill.setMaterialCategory(categoryToFill);
                    materialToFill.setMaterialPrice(materials.get(m).getMaterialPrice());
                    materialToFill.setQuantityStock(materials.get(m).getQuantityStock());
                    materialToFill.setMaterialState(null);
                    materialToFill.setStockState(null);
                    materialToFill.setSellState(null);
                    materialToFill.setReceiptState(null);
                    stockedMaterials.add(materialToFill);
                }
            }
            return stockedMaterials;
        }
	
        @Override
	public List<Material> getOnlyProducts() {
		List<Material> materials = materialRepo.findAll();
		List<Material> products = new ArrayList<>();
		if (!materials.isEmpty()) {
			for (int m = 0; m < materials.size(); m++) {
				if ((materials.get(m).getMaterialType().equals(finishedProduct)
						&& materials.get(m).getQuantityStock() != null
						&& materials.get(m).getQuantityStock() != 0)
                                        || (materials.get(m).getMaterialType().equals(rawMaterial)
						&& materials.get(m).getQuantityStock() != null
						&& materials.get(m).getQuantityStock() != 0)) {
					products.add(materials.get(m));
				}
			}
			return products;
		}
		return new ArrayList<>();
	}
	
	
	
        @Override
	public Material getOneMaterial(String materialId) {
				Material existedMaterial = materialRepo.findById(materialId).orElse(null);
				if (existedMaterial != null) {
					return existedMaterial;
				} else {
					return null;
				}
	}
	
        @Override
	public Material getOnlyProduct(String materialId) {
		//change method: condition within findAll()
		List<Material> materials = materialRepo.findAll();
		List<Material> products = new ArrayList<>();
		if (!materials.isEmpty()) {
			for (int m = 0; m < materials.size(); m++) {
				if (materials.get(m).getMaterialType().equals(finishedProduct)
						&& materials.get(m).getQuantityStock() != null
						&& materials.get(m).getQuantityStock() != 0) {
					products.add(materials.get(m));
				}
			}
			for (int p = 0; p < products.size(); p++) {
				if (products.get(p).getMaterialId().equals(materialId)) {
					return products.get(p);
				}
			}
		}
		return null;
	}
	
        @Override
	public Material addNewMaterial(Material material) {
			material.setMaterialCreationDate(new Date());
			material.setMaterialDeliveryDate(null);
			material.setMaterialPrice(null);
			material.setMaterialVAT(null);
			material.setMaterialQuantity(null);
			material.setQuantityStock(null);
			material.setQuantityOut(null);
			material.setMaterialState(true);
			material.setSupplier(null);
			material.setWarehouse(null);
			material.setReceiptState(false);
			material.setStockState(false);
			material.setSellingPrice(null);
                        material.setPersonnas(null);
			material.setSellState(false);
                        material.setReplenished(false);
			int existNumber = 0;
			List<Material> materials = materialRepo.findAll();
			if (!materials.isEmpty()) {
				for (int m = 0; m < materials.size(); m++) {
					if (materials.get(m).getMaterialName().equals(material.getMaterialName())
                                            && materials.get(m).getAddedBy().equals(material.getAddedBy())) {
						existNumber = existNumber + 1;
					}
				}
			}
			if (existNumber == 0) {
				materialRepo.save(material);
				return material;
			} else {
				return null;
			}
	}
        
        @Override
        public Material updatePersonnas(Material material, String materialId) {
            Material existedMaterial = materialRepo.findById(materialId).orElse(null);
            if (existedMaterial != null) {
                existedMaterial.setPersonnas(material.getPersonnas());
                materialRepo.save(existedMaterial);
                return existedMaterial;
            }
            return null;
        }
	
        @Override
	public Material updateMaterial(Material material, String materialId) {
			Material existedMaterial = materialRepo.findById(materialId).orElse(null);
			if (existedMaterial != null) {
				existedMaterial.setMaterialCategory(material.getMaterialCategory());
				existedMaterial.setMaterialName(material.getMaterialName());
				existedMaterial.setMaterialType(material.getMaterialType());
				existedMaterial.setMaterialBarcode(material.getMaterialBarcode());
				existedMaterial.setMaterialSKU(existedMaterial.getMaterialSKU());
				existedMaterial.setMaterialCreationDate(existedMaterial.getMaterialCreationDate());
				existedMaterial.setMaterialDeliveryDate(existedMaterial.getMaterialDeliveryDate());
				existedMaterial.setMaterialState(true);
				existedMaterial.setWarehouse(existedMaterial.getWarehouse());
				existedMaterial.setQuantityStock(material.getQuantityStock());
				existedMaterial.setStockAlert(material.getStockAlert());
				existedMaterial.setMaterialPrice(material.getMaterialPrice());
				existedMaterial.setSupplier(material.getSupplier());
				existedMaterial.setSellingPrice(material.getSellingPrice());
				existedMaterial.setSellState(existedMaterial.getSellState());
                                existedMaterial.setReplenished(existedMaterial.getReplenished());
				materialRepo.save(existedMaterial);
				return existedMaterial;
			}
			return null;
	}
        
        @Override
        public Material updateMaterialQuantity(Material material, String materialId) {
            Material existedMaterial = materialRepo.findById(materialId).orElse(null);
            if (existedMaterial != null) {
                existedMaterial.setMaterialQuantity(material.getMaterialQuantity());
                materialRepo.save(existedMaterial);
                return existedMaterial;
            }
            return null;
        }
	
        @Override
	public Material revertMaterial(String materialId) {
		Material existedMaterial = materialRepo.findById(materialId).orElse(null);
		if (existedMaterial != null) {
			existedMaterial.setMaterialPrice(null);
			existedMaterial.setMaterialVAT(null);
			existedMaterial.setMaterialQuantity(null);
			existedMaterial.setMaterialDeliveryDate(null);
			existedMaterial.setSupplier(null);
			materialRepo.save(existedMaterial);
			return existedMaterial;
		}
		return null;
	}
	
        @Override
	public Material receiveMaterial(String materialId, String poId) {
				Material existedMaterial = materialRepo.findById(materialId).orElse(null);
				if (existedMaterial != null) {
					existedMaterial.setReceiptState(true);
					existedMaterial.setMaterialDeliveryDate(new Date());
					PurchaseOrder existedPO = poRepo.findById(poId).orElse(null);
					if (existedPO != null) {
                                            for (Material material : existedPO.getMaterials()) {
                                                if (material.getMaterialId().equals(materialId)) {
                                                    existedMaterial.setMaterialPrice(material.getMaterialPrice());
                                                    existedMaterial.setMaterialVAT(material.getMaterialVAT());
                                                    existedMaterial.setMaterialQuantity(material.getMaterialQuantity());
                                                    existedMaterial.setSupplier(existedPO.getSelectedSupplier());
                                                }
                                            }
					} else {
						return null;
					}
					materialRepo.save(existedMaterial);
					return existedMaterial;
				} else {
					return null;
				}
	}
	
        @Override
	public Material stockMaterial(Material material, String materialId, String warehouseId) {
			if (materialRepo.findById(materialId).isPresent()) {
				Material existedMaterial = materialRepo.findById(materialId).orElse(null);
				if (existedMaterial != null) {
					List <Warehouse> warehouses = warehouseRepo.findAll();
					for (int w = 0; w < warehouses.size(); w++) {
						if (warehouses.get(w).getWarehouseId().equals(warehouseId)) {
							existedMaterial.setWarehouse(warehouses.get(w));
						}
					}
					if (existedMaterial.getQuantityStock() == null) {
						existedMaterial.setQuantityStock(existedMaterial.getMaterialQuantity());
					} else {
						existedMaterial.setQuantityStock(
							existedMaterial.getMaterialQuantity() + existedMaterial.getQuantityStock()
						);
					}
					existedMaterial.setReceiptState(false);
					existedMaterial.setStockState(true);
					existedMaterial.setMaterialQuantity(null);
                                        existedMaterial.setSellState(material.getSellState());
                                        existedMaterial.setSellingPrice(material.getSellingPrice());
					materialRepo.save(existedMaterial);
					return existedMaterial;
				}
				return null;
			}
			return null;
	}
	
        @Override
	public Material stockMaterialW(String materialId) {
		if (materialRepo.findById(materialId).isPresent()) {
			Material existedMaterial = materialRepo.findById(materialId).orElse(null);
			if (existedMaterial != null) {
				if (existedMaterial.getQuantityStock() == null) {
					existedMaterial.setQuantityStock(existedMaterial.getMaterialQuantity());
				} else {
					existedMaterial.setQuantityStock(
						existedMaterial.getMaterialQuantity() + existedMaterial.getQuantityStock()
					);
				}
				existedMaterial.setReceiptState(false);
				existedMaterial.setStockState(true);
				existedMaterial.setMaterialQuantity(null);
				materialRepo.save(existedMaterial);
				return existedMaterial;
			}
			return null;
		}
		return null;
	}
        
        @Override
        public Material transferMaterialToW(Material material, String materialId) {
            if (materialRepo.findById(materialId).isPresent()) {
                Material existedMaterial = materialRepo.findById(materialId).orElse(null);
                if (existedMaterial != null) {
                    existedMaterial.setWarehouse(material.getWarehouse());
                    materialRepo.save(existedMaterial);
                    return existedMaterial;
                }
                return null;
            }
            return null;
        }
	
        @Override
	public Material returnMaterial(String materialId) {
		if (materialRepo.findById(materialId).isPresent()) {
			Material existedMaterial = materialRepo.findById(materialId).orElse(null);
			if (existedMaterial != null) {
				existedMaterial.setReceiptState(false);
				existedMaterial.setStockState(false);
				existedMaterial.setMaterialQuantity(null);
				materialRepo.save(existedMaterial);
				return existedMaterial;
			}
			return null;
		}
		return null;
	}
	
        @Override
	public Material updateMaterialStock(Material material, String materialId) {
		if (materialRepo.findById(materialId).isPresent()) {
			Material existedMaterial = materialRepo.findById(materialId).orElse(null);
			if (existedMaterial != null) {
				existedMaterial.setQuantityStock(
						material.getQuantityStock() - material.getQuantityOut());
				materialRepo.save(existedMaterial);
				return existedMaterial;
			}
			return null;
		}
		return null;
	}
        
        @Override
	public Material fixMaterialStock(String materialId, String inventoryId) {
				Material existedMaterial = materialRepo.findById(materialId).orElse(null);
                                Inventory existedInv = invRepo.findById(inventoryId).orElse(null);
				if (existedMaterial != null && existedInv != null) {
                                    for (Material material : existedInv.getMaterials()) {
                                        if (material.getMaterialId().equals(materialId)) {
                                            existedMaterial.setQuantityStock(material.getQuantityReel());
                                        }
                                    }
					materialRepo.save(existedMaterial);
					return existedMaterial;
				} else {
					return null;
				}
	}
        
        @Override
	public Material replenishMaterial(String materialId) {
				Material existedMaterial = materialRepo.findById(materialId).orElse(null);
				if (existedMaterial != null) {
					existedMaterial.setReplenished(true);
					materialRepo.save(existedMaterial);
					return existedMaterial;
				} else {
					return null;
				}
	}
        
        @Override
	public Material unreplenishMaterial(String materialId) {
				Material existedMaterial = materialRepo.findById(materialId).orElse(null);
				if (existedMaterial != null) {
					existedMaterial.setReplenished(false);
					materialRepo.save(existedMaterial);
					return existedMaterial;
				} else {
					return null;
				}
	}
	
        @Override
	public Material archiveMaterial(String materialId) {
				Material existedMaterial = materialRepo.findById(materialId).orElse(null);
				if (existedMaterial != null) {
					existedMaterial.setMaterialState(false);
					materialRepo.save(existedMaterial);
					return existedMaterial;
				} else {
					return null;
				}
	}
	
        @Override
	public Material restoreMaterial(String materialId) {
		Material existedMaterial = materialRepo.findById(materialId).orElse(null);
		if (existedMaterial != null) {
			existedMaterial.setMaterialState(true);
			materialRepo.save(existedMaterial);
			return existedMaterial;
		} else {
			return null;
		}
}

}
