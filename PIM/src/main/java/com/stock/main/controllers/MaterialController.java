package com.stock.main.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.main.business.businessimpl.MaterialBusiness;
import com.stock.main.business.dtos.MaterialDTO;
import com.stock.main.entities.Material;

@RestController
@RequestMapping("/material")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class MaterialController {
	
	@Autowired
	private MaterialBusiness materialBusiness;
	
	@Autowired
        private ModelMapper modelMapper;
	
	@GetMapping("/all")
	public List<Material> getAllMaterials() {
		return materialBusiness.getAllMaterials();
	}
	
	@GetMapping("/all/asc")
	public List<Material> getAllMaterialsASC() {
		return materialBusiness.getAllMaterialsASC();
	}
	
	@GetMapping("/all/desc")
	public List<Material> getAllMaterialsDESC() {
		return materialBusiness.getAllMaterialsDESC();
	}
        
        @GetMapping("/stocked")
	public List<Material> getStockedMaterials() {
		return materialBusiness.getStockedMaterials();
	}
	
	@GetMapping("/finished-products")
	public List<Material> getOnlyProducts() {
		return materialBusiness.getOnlyProducts();
	}
	
	@GetMapping("/show/{materialId}")
	public Material getOneMaterial(@PathVariable String materialId) {
		return materialBusiness.getOneMaterial(materialId);
	}
	
	@GetMapping("/show/finished-product/{materialId}")
	public Material getOnlyProduct(@PathVariable String materialId) {
		return materialBusiness.getOnlyProduct(materialId);
	}
	
	@PostMapping("/create")
	public Material addNewMaterial(@RequestBody MaterialDTO materialDTO) {
		Material material = convertToEntity(materialDTO);
		return materialBusiness.addNewMaterial(material);
	}
        
        @PutMapping("/update-personnas/{materialId}")
	public Material updatePersonnas(@RequestBody MaterialDTO materialDTO,
			@PathVariable String materialId) {
		Material material = convertToEntity(materialDTO);
		return materialBusiness.updatePersonnas(material, materialId);
	}
	
	@PutMapping("/edit/{materialId}")
	public Material updateMaterial(@RequestBody MaterialDTO materialDTO,
			@PathVariable String materialId) {
		Material material = convertToEntity(materialDTO);
		return materialBusiness.updateMaterial(material, materialId);
	}
        
        @PutMapping("/update-quantity/{materialId}")
        public Material updateMaterialQuantity(@RequestBody MaterialDTO materialDTO, 
                @PathVariable String materialId) {
            Material material = convertToEntity(materialDTO);
            return materialBusiness.updateMaterialQuantity(material, materialId);
        }
	
	@PutMapping("/revert/{materialId}")
	public Material revertMaterial(@PathVariable String materialId) {
		return materialBusiness.revertMaterial(materialId);
	}
	
	@PutMapping("/receive/{materialId}/{poId}")
	public Material receiveMaterial(@PathVariable String materialId,
			@PathVariable String poId) {
		return materialBusiness.receiveMaterial(materialId, poId);
	}
	
	@PutMapping("/stock/{materialId}/{warehouseId}")
	public Material stockMaterial(@RequestBody MaterialDTO materialDTO,
                        @PathVariable String materialId,
			@PathVariable String warehouseId) {
                Material material = convertToEntity(materialDTO);        
		return materialBusiness.stockMaterial(material, materialId, warehouseId);
	}
	
	@PutMapping("/stock-w/{materialId}")
	public Material stockMaterialW(
			@PathVariable String materialId) {
		return materialBusiness.stockMaterialW(materialId);
	}
        
        @PutMapping("/transfer/{materialId}")
        public Material transferMaterialToW(@RequestBody MaterialDTO materialDTO, 
                @PathVariable String materialId) {
            Material material = convertToEntity(materialDTO);
            return materialBusiness.transferMaterialToW(material, materialId);
        }
	
	@PutMapping("/return/{materialId}")
	public Material returnMaterial(
			@PathVariable String materialId) {
		return materialBusiness.returnMaterial(materialId);
	}
	
	@PutMapping("/update-stock/{materialId}")
	public Material updateMaterialStock(
			@RequestBody MaterialDTO materialDTO, @PathVariable String materialId) {
		Material material = convertToEntity(materialDTO);
		return materialBusiness.updateMaterialStock(material, materialId);
	}
        
        @PutMapping("/fix-stock/{materialId}/{inventoryId}")
	public Material fixMaterialStock(@PathVariable String materialId, @PathVariable String inventoryId) {
		return materialBusiness.fixMaterialStock(materialId, inventoryId);
	}
        
        @PutMapping("/replenish/{materialId}")
	public Material replenishMaterial(@PathVariable String materialId) {
		return materialBusiness.replenishMaterial(materialId);
	}
        
        @PutMapping("/unreplenish/{materialId}")
	public Material unreplenishMaterial(@PathVariable String materialId) {
		return materialBusiness.unreplenishMaterial(materialId);
	}
	
	@PutMapping("/archive/{materialId}")
	public Material archiveMaterial(@PathVariable String materialId) {
		return materialBusiness.archiveMaterial(materialId);
	}
	
	@PutMapping("/restore/{materialId}")
	public Material restoreMaterial(@PathVariable String materialId) {
		return materialBusiness.restoreMaterial(materialId);
	}
	
	private Material convertToEntity(MaterialDTO materialDTO) {
	    return modelMapper.map(materialDTO, Material.class);
	}

}
