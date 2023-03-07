package com.stock.main.business.ibusiness;

import java.util.List;

import com.stock.main.entities.PurchaseReturn;

public interface IPurchaseReturn {
	
	public List<PurchaseReturn> getAllPurchaseReturns();
	public List<PurchaseReturn> getAllPurchaseReturnsASC();
	public List<PurchaseReturn> getAllPurchaseReturnsDESC();
	public PurchaseReturn getOnePurchaseReturn(String purchaseReturnId);
	public PurchaseReturn addNewPurchaseReturn(PurchaseReturn purchaseReturn);
	public PurchaseReturn archivePurchaseReturn(String purchaseReturnId);
	public PurchaseReturn restorePurchaseReturn(String purchaseReturnId);

}
