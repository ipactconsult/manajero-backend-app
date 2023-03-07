package com.stock.main.business.businessimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stock.main.business.ibusiness.IPurchaseReturn;
import com.stock.main.entities.PurchaseReturn;
import com.stock.main.repositories.PurchaseReturnRepository;

@Service
public class PurchaseReturnBusiness implements IPurchaseReturn {
	
	@Autowired
	private PurchaseReturnRepository purchaseReturnRepo;
	
	public List<PurchaseReturn> getAllPurchaseReturns() {
		List<PurchaseReturn> purchaseReturns = purchaseReturnRepo.findAll(
                        Sort.by(Sort.Direction.DESC, "purchaseReturnDate")
                );
		if (!purchaseReturns.isEmpty()) {
			return purchaseReturns;
		}
		return new ArrayList<>();
	}
	
	public List<PurchaseReturn> getAllPurchaseReturnsASC() {
		List<PurchaseReturn> purchaseReturns = purchaseReturnRepo.findAll(
				Sort.by(Sort.Direction.ASC, "purchaseReturnRef"));
		if (!purchaseReturns.isEmpty()) {
			return purchaseReturns;
		}
		return new ArrayList<>();
	}
	
	public List<PurchaseReturn> getAllPurchaseReturnsDESC() {
		List<PurchaseReturn> purchaseReturns = purchaseReturnRepo.findAll(
				Sort.by(Sort.Direction.DESC, "purchaseReturnRef"));
		if (!purchaseReturns.isEmpty()) {
			return purchaseReturns;
		}
		return new ArrayList<>();
	}
	
	public PurchaseReturn getOnePurchaseReturn(String purchaseReturnId) {
		PurchaseReturn existedPurchaseReturn = purchaseReturnRepo.findById(purchaseReturnId)
				.orElse(null);
		if (existedPurchaseReturn != null) {
			return existedPurchaseReturn;
		} else {
			return null;
		}
	}
	
	public PurchaseReturn addNewPurchaseReturn(PurchaseReturn purchaseReturn) {
		purchaseReturn.setPurchaseReturnDate(new Date());
		purchaseReturn.setPurchaseReturnState(true);
		purchaseReturnRepo.save(purchaseReturn);
		return purchaseReturn;
	}
	
	public PurchaseReturn archivePurchaseReturn(String purchaseReturnId) {
		PurchaseReturn existedPurchaseReturn = purchaseReturnRepo.findById(purchaseReturnId)
				.orElse(null);
		if (existedPurchaseReturn != null) {
			existedPurchaseReturn.setPurchaseReturnState(false);
			purchaseReturnRepo.save(existedPurchaseReturn);
			return existedPurchaseReturn;
		} else {
			return null;
		}
	}
	
	public PurchaseReturn restorePurchaseReturn(String purchaseReturnId) {
		PurchaseReturn existedPurchaseReturn = purchaseReturnRepo.findById(purchaseReturnId)
				.orElse(null);
		if (existedPurchaseReturn != null) {
			existedPurchaseReturn.setPurchaseReturnState(true);
			purchaseReturnRepo.save(existedPurchaseReturn);
			return existedPurchaseReturn;
		} else {
			return null;
		}
	}

}
