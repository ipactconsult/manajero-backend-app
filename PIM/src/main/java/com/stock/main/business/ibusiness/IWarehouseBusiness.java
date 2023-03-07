package com.stock.main.business.ibusiness;

import java.util.List;

import com.stock.main.entities.Warehouse;

public interface IWarehouseBusiness {
	
	public List<Warehouse> getAllWarehouses();
	public List<Warehouse> getAllWarehousesASC();
	public List<Warehouse> getAllWarehousesDESC();
	public Warehouse getOneWarehouse(String warehouseId);
	public Warehouse addNewWarehouse(Warehouse warehouse);
	public Warehouse updateWarehouse(Warehouse warehouse, String warehouseId);
	public Warehouse archiveWarehouse(String warehouseId);
	public Warehouse restoreWarehouse(String warehouseId);

}
