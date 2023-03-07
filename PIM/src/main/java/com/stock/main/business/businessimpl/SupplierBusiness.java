package com.stock.main.business.businessimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stock.main.business.ibusiness.ISupplierBusiness;
import com.stock.main.entities.Supplier;
import com.stock.main.repositories.SupplierRepository;

@Service
public class SupplierBusiness implements ISupplierBusiness  {
	
	@Autowired
	private SupplierRepository supplierRepo;
	
        @Override
	public List<Supplier> getAllSuppliers() {
		List<Supplier> suppliers = supplierRepo.findAll(
                        Sort.by(Sort.Direction.DESC, "supplierCreationDate")
                );
		if (!suppliers.isEmpty()) {
			return suppliers;
		}
		return new ArrayList<>();
	}
	
        @Override
	public List<Supplier> getAllSuppliersASC() {
		List<Supplier> suppliers = supplierRepo.findAll(
				Sort.by(Sort.Direction.ASC, "supplierFirstName"));
		if (!suppliers.isEmpty()) {
			return suppliers;
		}
		return new ArrayList<>();
	}
	
        @Override
	public List<Supplier> getAllSuppliersDESC() {
		List<Supplier> suppliers = supplierRepo.findAll(
				Sort.by(Sort.Direction.DESC, "supplierFirstName"));
		if (!suppliers.isEmpty()) {
			return suppliers;
		}
		return new ArrayList<>();
	}
	
        @Override
	public Supplier getOneSupplier(String supplierId) {
				Supplier existedSupplier = supplierRepo.findById(supplierId).orElse(null);
				if (existedSupplier != null) {
					return existedSupplier;
				}
				return null;
	}
	
        @Override
	public Supplier addNewSupplier(Supplier supplier) {
			supplier.setSupplierCreationDate(new Date());
			supplier.setSupplierState(true);
			int existNumber = 0;
			List<Supplier> suppliers = supplierRepo.findAll();
			if (!suppliers.isEmpty()) {
				for (int m = 0; m < suppliers.size(); m++) {
					if (suppliers.get(m).getSupplierEmail().equals(supplier.getSupplierEmail())
                                            && suppliers.get(m).getAddedBy().equals(supplier.getAddedBy())) {
						existNumber = existNumber + 1;
					}
				}
			}
			if (existNumber == 0) {
				supplierRepo.save(supplier);
				return supplier;
			} else {
				return null;
			}
	}
	
        @Override
	public String updateSupplier(Supplier supplier, String supplierId) {
		try {
				Supplier existedSupplier = supplierRepo.findById(supplierId).orElse(null);
				if (existedSupplier != null) {
					existedSupplier.setSupplierFirstName(supplier.getSupplierFirstName());
					existedSupplier.setSupplierLastName(supplier.getSupplierLastName());
					existedSupplier.setSupplierEmail(supplier.getSupplierEmail());
					existedSupplier.setSupplierCountry(supplier.getSupplierCountry());
					existedSupplier.setSupplierState(true);
					existedSupplier.setSupplierCreationDate(existedSupplier.getSupplierCreationDate());
					int existNumber = 0;
					List<Supplier> suppliers = supplierRepo.findAll();
					if (!suppliers.isEmpty()) {
						for (int m = 0; m < suppliers.size(); m++) {
							if (suppliers.get(m).getSupplierEmail().equals(supplier.getSupplierEmail())) {
								existNumber = existNumber + 1;
							}
						}
					}
					if (existNumber == 0) {
						supplierRepo.save(existedSupplier);
						return "Updated Successfully";
					} else {
						return "Supplier Already Exists";
					}
				} else {
					return null;
				}
		} catch (Exception ex) {
			return ex.getMessage();
		}
	}
	
        @Override
	public Supplier archiveSupplier(String supplierId) {
				Supplier existedSupplier = supplierRepo.findById(supplierId).orElse(null);
				if (existedSupplier != null) {
					existedSupplier.setSupplierState(false);
					supplierRepo.save(existedSupplier);
					return existedSupplier;
				} else {
					return null;
				}
	}
	
        @Override
	public Supplier restoreSupplier(String supplierId) {
		Supplier existedSupplier = supplierRepo.findById(supplierId).orElse(null);
		if (existedSupplier != null) {
			existedSupplier.setSupplierState(true);
			supplierRepo.save(existedSupplier);
			return existedSupplier;
		} else {
			return null;
		}
}

}
