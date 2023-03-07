package com.stock.main.business.businessimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stock.main.business.ibusiness.IPurchaseRequisition;
import com.stock.main.entities.PurchaseRequisition;
import com.stock.main.repositories.PurchaseRequisitionRepository;

@Service
public class PurchaseRequisitionBusiness implements IPurchaseRequisition {
	
	@Autowired
	private PurchaseRequisitionRepository prRepo;
	
        @Override
	public List<PurchaseRequisition> getAllPR() {
		List<PurchaseRequisition> prs = prRepo.findAll(
                        Sort.by(Sort.Direction.DESC, "purchaseRequisitionCreationDate")
                );
		if (!prs.isEmpty()) {
			return prs;
		}
		return new ArrayList<>();
	}
	
        @Override
	public List<PurchaseRequisition> getAllPRASC() {
		List<PurchaseRequisition> prs = prRepo.findAll(
				Sort.by(Sort.Direction.ASC, "purchaseRequisitionNumber"));
		if (!prs.isEmpty()) {
			return prs;
		}
		return new ArrayList<>();
	}
	
        @Override
	public List<PurchaseRequisition> getAllPRDESC() {
		List<PurchaseRequisition> prs = prRepo.findAll(
				Sort.by(Sort.Direction.DESC, "purchaseRequisitionNumber"));
		if (!prs.isEmpty()) {
			return prs;
		}
		return new ArrayList<>();
	}
        
        @Override
        public List<PurchaseRequisition> getPendingPRS() {
                List<PurchaseRequisition> prs = prRepo.findAll();
		List<PurchaseRequisition> pendingPRS = new ArrayList<>();
		if (!prs.isEmpty()) {
			for (int p = 0; p < prs.size(); p++) {
				if (prs.get(p).getPurchaseRequisitionStatus().equals("Pending")) {
					pendingPRS.add(prs.get(p));
				}
			}
			return pendingPRS;
		}
		return new ArrayList<>();
	}
	
        @Override
	public PurchaseRequisition getOnePR(String prId) {
				PurchaseRequisition existedPR = prRepo.findById(prId).orElse(null);
				if (existedPR != null) {
					return existedPR;
				} else {
					return null;
				}
	}
	
        @Override
	public PurchaseRequisition addNewPR(PurchaseRequisition pr) {
			pr.setPurchaseRequisitionCreationDate(new Date());
			pr.setPurchaseRequisitionState(true);
			pr.setPurchaseRequisitionStatus("Pending");
			prRepo.save(pr);
			return pr;
	}
	
        @Override
	public PurchaseRequisition archivePR(String prId) {
				PurchaseRequisition existedPR = prRepo.findById(prId).orElse(null);
				if (existedPR != null) {
					existedPR.setPurchaseRequisitionState(false);
					prRepo.save(existedPR);
					return existedPR;
				} else {
					return null;
				}
	}
	
        @Override
	public PurchaseRequisition restorePR(String prId) {
		PurchaseRequisition existedPR = prRepo.findById(prId).orElse(null);
		if (existedPR != null) {
			existedPR.setPurchaseRequisitionState(true);
			prRepo.save(existedPR);
			return existedPR;
		} else {
			return null;
		}
	}
        
        @Override
	public PurchaseRequisition approvePR(String prId) {
		PurchaseRequisition existedPR = prRepo.findById(prId).orElse(null);
		if (existedPR != null) {
			existedPR.setPurchaseRequisitionStatus("Approved");
			prRepo.save(existedPR);
			return existedPR;
		} else {
			return null;
		}
	}
        
        @Override
	public PurchaseRequisition rejectPR(String prId) {
		PurchaseRequisition existedPR = prRepo.findById(prId).orElse(null);
		if (existedPR != null) {
			existedPR.setPurchaseRequisitionStatus("Rejected");
			prRepo.save(existedPR);
			return existedPR;
		} else {
			return null;
		}
	}
	
        @Override
	public PurchaseRequisition deletePR(String prId) {
		PurchaseRequisition existedPR = prRepo.findById(prId).orElse(null);
		if (existedPR != null) {
			prRepo.delete(existedPR);
			return existedPR;
		} else {
			return null;
		}
	}

}
