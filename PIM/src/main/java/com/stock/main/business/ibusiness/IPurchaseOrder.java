package com.stock.main.business.ibusiness;

import java.util.List;

import com.stock.main.entities.PurchaseOrder;

public interface IPurchaseOrder {
	
	public List<PurchaseOrder> getAllPOs();
	public List<PurchaseOrder> getAllPOsASCByCode();
	public List<PurchaseOrder> getAllPOsDESCByCode();
        public List<PurchaseOrder> getPendingPOs();
	public PurchaseOrder getOnePO(String poId);
	public PurchaseOrder addNewPO(PurchaseOrder po);
        public PurchaseOrder sendMail(String poId);
	public PurchaseOrder archivePO(String poId);
        public PurchaseOrder restorePO(String poId);
	public PurchaseOrder receivePO(String poId);
	public PurchaseOrder changeReceiptSupplier(String poId);
        public String approvePO(String poId);
        public String rejectPO(String poId);
	public PurchaseOrder deletePO(String poId);

}
