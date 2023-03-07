package com.stock.main.business.businessimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stock.main.business.ibusiness.IWarehouseBusiness;
import com.stock.main.entities.Warehouse;
import com.stock.main.repositories.WarehouseRepository;

@Service
public class WarehouseBusiness implements IWarehouseBusiness {
	
	@Autowired
	private WarehouseRepository warehouseRepo;
	
        @Override
	public List<Warehouse> getAllWarehouses() {
		List<Warehouse> warehouses = warehouseRepo.findAll(
                        Sort.by(Sort.Direction.DESC, "warehouseCreationDate")
                );
		if (!warehouses.isEmpty()) {
			return warehouses;
		}
		return new ArrayList<>();
	}
	
        @Override
	public List<Warehouse> getAllWarehousesASC() {
		List<Warehouse> warehouses = warehouseRepo.findAll(
				Sort.by(Sort.Direction.ASC, "warehouseLocation"));
		if (!warehouses.isEmpty()) {
			return warehouses;
		}
		return new ArrayList<>();
	}
	
        @Override
	public List<Warehouse> getAllWarehousesDESC() {
		List<Warehouse> warehouses = warehouseRepo.findAll(
				Sort.by(Sort.Direction.DESC, "warehouseLocation"));
		if (!warehouses.isEmpty()) {
			return warehouses;
		}
		return new ArrayList<>();
	}
	
        @Override
	public Warehouse getOneWarehouse(String warehouseId) {
				Warehouse existedWarehouse = warehouseRepo.findById(warehouseId).orElse(null);
				if (existedWarehouse != null) {
					return existedWarehouse;
				}
				return null;
	}
	
        @Override
	public Warehouse addNewWarehouse(Warehouse warehouse) {
			warehouse.setWarehouseCreationDate(new Date());
			warehouse.setWarehouseState(true);
			int existNumber = 0;
			List<Warehouse> warehouses = warehouseRepo.findAll();
                            if (!warehouses.isEmpty()) {
				for (int m = 0; m < warehouses.size(); m++) {
                                    if (warehouses.get(m).getWarehouseLocation().equals(warehouse.getWarehouseLocation())
                                         && warehouses.get(m).getAddedBy().equals(warehouse.getAddedBy())) {
					existNumber = existNumber + 1;
                                    }
				}
                            }
                            if (existNumber == 0) {
				warehouseRepo.save(warehouse);
                                    return warehouse;
                            } else {
                                    return null;
                            }
	}
	
        @Override
	public Warehouse updateWarehouse(Warehouse warehouse, String warehouseId) {
				Warehouse existedWarehouse = warehouseRepo.findById(warehouseId).orElse(null);
				if (existedWarehouse != null) {
					existedWarehouse.setWarehouseLocation(warehouse.getWarehouseLocation());
					existedWarehouse.setWarehouseDesc(warehouse.getWarehouseDesc());
					existedWarehouse.setWarehouseAddress(warehouse.getWarehouseAddress());
					existedWarehouse.setWarehousePostalCode(warehouse.getWarehousePostalCode());
					existedWarehouse.setWarehouseCity(warehouse.getWarehouseCity());
					existedWarehouse.setWarehouseCountry(warehouse.getWarehouseCountry());
					existedWarehouse.setWarehouseState(true);
					existedWarehouse.setWarehousePhone(warehouse.getWarehousePhone());
					int existNumber = 0;
					List<Warehouse> warehouses = warehouseRepo.findAll();
					if (!warehouses.isEmpty()) {
						for (int m = 0; m < warehouses.size(); m++) {
							if (warehouses.get(m).getWarehouseLocation().equals(warehouse.getWarehouseLocation())) {
								existNumber = existNumber + 1;
							}
						}
					}
					if (existNumber == 0) {
						warehouseRepo.save(existedWarehouse);
						return existedWarehouse;
					} else {
						return null;
					}
				} else {
					return null;
				}
	}
	
        @Override
	public Warehouse archiveWarehouse(String warehouseId) {
				Warehouse existedWarehouse = warehouseRepo.findById(warehouseId).orElse(null);
				if (existedWarehouse != null) {
					existedWarehouse.setWarehouseState(false);
					warehouseRepo.save(existedWarehouse);
					return existedWarehouse;
				}
				
			return null;
	}
	
        @Override
	public Warehouse restoreWarehouse(String warehouseId) {
		Warehouse existedWarehouse = warehouseRepo.findById(warehouseId).orElse(null);
		if (existedWarehouse != null) {
			existedWarehouse.setWarehouseState(true);
			warehouseRepo.save(existedWarehouse);
			return existedWarehouse;
		}
		
	return null;
}

}
