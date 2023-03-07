package com.stock.main.business.ibusiness;

import java.util.List;

import com.stock.main.entities.Supplier;

public interface ISupplierBusiness {
	
	public List<Supplier> getAllSuppliers();
	public List<Supplier> getAllSuppliersASC();
	public List<Supplier> getAllSuppliersDESC();
	public Supplier getOneSupplier(String supplierId);
	public Supplier addNewSupplier(Supplier supplier);
	public String updateSupplier(Supplier supplier, String supplierId);
	public Supplier archiveSupplier(String supplierId);
	public Supplier restoreSupplier(String supplierId);

}
