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

import com.stock.main.business.businessimpl.WarehouseBusiness;
import com.stock.main.business.dtos.WarehouseDTO;
import com.stock.main.entities.Warehouse;

@RestController
@RequestMapping("/warehouse")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class WarehouseController {
	
	@Autowired
	private WarehouseBusiness warehouseBusiness;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping("/all")
	public List<Warehouse> getAllWarehouses() {
		return warehouseBusiness.getAllWarehouses();
	}
	
	@GetMapping("/all/asc")
	public List<Warehouse> getAllWarehousesASC() {
		return warehouseBusiness.getAllWarehousesASC();
	}
	
	@GetMapping("/all/desc")
	public List<Warehouse> getAllWarehousesDESC() {
		return warehouseBusiness.getAllWarehousesDESC();
	}
	
	@GetMapping("/show/{warehouseId}")
	public Warehouse getOneWarehouse(@PathVariable String warehouseId) {
		return warehouseBusiness.getOneWarehouse(warehouseId);
	}
	
	@PostMapping("/create")
	public Warehouse addNewWarehouse(@RequestBody WarehouseDTO warehouseDTO) {
		Warehouse warehouse = convertToEntity(warehouseDTO);
		return warehouseBusiness.addNewWarehouse(warehouse);
	}
	
	@PutMapping("/edit/{warehouseId}")
	public Warehouse updateWarehouse(@RequestBody WarehouseDTO warehouseDTO,
			@PathVariable String warehouseId) {
		Warehouse warehouse = convertToEntity(warehouseDTO);
		return warehouseBusiness.updateWarehouse(warehouse, warehouseId);
	}
	
	@PutMapping("/archive/{warehouseId}")
	public Warehouse archiveWarehouse(@PathVariable String warehouseId) {
		return warehouseBusiness.archiveWarehouse(warehouseId);
	}
	
	@PutMapping("/restore/{warehouseId}")
	public Warehouse restoreWarehouse(@PathVariable String warehouseId) {
		return warehouseBusiness.restoreWarehouse(warehouseId);
	}
	
	private Warehouse convertToEntity(WarehouseDTO warehouseDTO) {
	    return modelMapper.map(warehouseDTO, Warehouse.class);
	}

}
