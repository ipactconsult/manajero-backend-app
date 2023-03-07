package com.stock.main.business.ibusiness;

import java.util.List;

import com.stock.main.entities.Material;

public interface IMaterialBusiness {
	
	public List<Material> getAllMaterials();
	public List<Material> getAllMaterialsASC();
	public List<Material> getAllMaterialsDESC();
        public List<Material> getStockedMaterials();
	public List<Material> getOnlyProducts();
	public Material getOneMaterial(String materialId);
	public Material getOnlyProduct(String materialId);
	public Material addNewMaterial(Material material);
        public Material updatePersonnas(Material material, String materialId);
	public Material updateMaterial(Material material, String materialId);
        public Material updateMaterialQuantity(Material material, String materialId);
	public Material revertMaterial(String materialId);
	public Material receiveMaterial(String materialId, String poId);
	public Material stockMaterial(Material material, String materialId, String warehouseId);
	public Material stockMaterialW(String materialId);
        public Material transferMaterialToW(Material material, String materialId);
	public Material returnMaterial(String materialId);
	public Material updateMaterialStock(Material material, String materialId);
        public Material fixMaterialStock(String materialId, String inventoryId);
        public Material replenishMaterial(String materialId);
        public Material unreplenishMaterial(String materialId);
	public Material archiveMaterial(String materialId);
	public Material restoreMaterial(String materialId);

}
