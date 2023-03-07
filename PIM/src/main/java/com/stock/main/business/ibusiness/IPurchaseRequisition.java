package com.stock.main.business.ibusiness;

import java.util.List;

import com.stock.main.entities.PurchaseRequisition;

public interface IPurchaseRequisition {
	
	public List<PurchaseRequisition> getAllPR();
	public List<PurchaseRequisition> getAllPRASC();
	public List<PurchaseRequisition> getAllPRDESC();
        public List<PurchaseRequisition> getPendingPRS();
	public PurchaseRequisition getOnePR(String prId);
	public PurchaseRequisition addNewPR(PurchaseRequisition pr);
	public PurchaseRequisition archivePR(String prId);
	public PurchaseRequisition restorePR(String prId);
        public PurchaseRequisition approvePR(String prId);
        public PurchaseRequisition rejectPR(String prId);
	public PurchaseRequisition deletePR(String prId);

}
