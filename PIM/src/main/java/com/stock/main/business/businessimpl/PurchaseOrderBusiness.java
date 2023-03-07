package com.stock.main.business.businessimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stock.main.business.ibusiness.IPurchaseOrder;
import com.stock.main.entities.PurchaseOrder;
import com.stock.main.repositories.PurchaseOrderRepository;

@Service
public class PurchaseOrderBusiness implements IPurchaseOrder {
	
	@Autowired
	private PurchaseOrderRepository poRepo;
	
        @Override
	public List<PurchaseOrder> getAllPOs() {
		List<PurchaseOrder> pos = poRepo.findAll(
                    Sort.by(Sort.Direction.DESC, "poCreationDate")    
                );
		if (!pos.isEmpty()) {
			return pos;
		}
		return new ArrayList<>();
	}
	
        @Override
	public List<PurchaseOrder> getAllPOsASCByCode() {
		List<PurchaseOrder> pos = poRepo.findAll(
				Sort.by(Sort.Direction.ASC, "poNumber"));
		if (!pos.isEmpty()) {
			return pos;
		}
		return new ArrayList<>();
	}
	
        @Override
	public List<PurchaseOrder> getAllPOsDESCByCode() {
		List<PurchaseOrder> pos = poRepo.findAll(
				Sort.by(Sort.Direction.DESC, "poNumber"));
		if (!pos.isEmpty()) {
			return pos;
		}
		return new ArrayList<>();
	}
        
        @Override
        public List<PurchaseOrder> getPendingPOs() {
                List<PurchaseOrder> purchaseOrders = poRepo.findAll();
		List<PurchaseOrder> pendingPOS = new ArrayList<>();
		if (!purchaseOrders.isEmpty()) {
			for (int po = 0; po < purchaseOrders.size(); po++) {
				if (purchaseOrders.get(po).getPoStatus().equals("Pending")) {
					pendingPOS.add(purchaseOrders.get(po));
				}
			}
			return pendingPOS;
		}
		return new ArrayList<>();
	}
	
        @Override
	public PurchaseOrder getOnePO(String poId) {
		if (poRepo.findById(poId).isPresent()) {
			PurchaseOrder existedPO = poRepo.findById(poId).orElse(null);
			if (existedPO != null) {
				return existedPO;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
        @Override
	public PurchaseOrder addNewPO(PurchaseOrder po) {
			po.setPoCreationDate(new Date());
			po.setPoState(true);
			po.setPoReceiptState(false);
			po.setReceiptSupplier(false);
			po.setPoStatus("Pending");
                        po.setMailSent(false);
                        po.setReelRD(null);
			poRepo.save(po);
			return po;
	}
        
        @Override
        public PurchaseOrder sendMail(String poId) {
            PurchaseOrder existedPO = poRepo.findById(poId).orElse(null);
				if (existedPO != null) {
					existedPO.setMailSent(true);
					poRepo.save(existedPO);
					return existedPO;
				}
			return null;
        }
	
        @Override
	public PurchaseOrder archivePO(String poId) {
				PurchaseOrder existedPO = poRepo.findById(poId).orElse(null);
				if (existedPO != null) {
					existedPO.setPoState(false);
					poRepo.save(existedPO);
					return existedPO;
				}
			return null;
	}
        
        @Override
	public PurchaseOrder restorePO(String poId) {
				PurchaseOrder existedPO = poRepo.findById(poId).orElse(null);
				if (existedPO != null) {
					existedPO.setPoState(true);
					poRepo.save(existedPO);
					return existedPO;
				}
			return null;
	}
	
        @Override
	public PurchaseOrder receivePO(String poId) {
		PurchaseOrder existedPO = poRepo.findById(poId).orElse(null);
		if (existedPO != null) {
			existedPO.setPoReceiptState(true);
                        existedPO.setReelRD(new Date());
			poRepo.save(existedPO);
			return existedPO;
		}
	return null;
	}
	
        @Override
	public PurchaseOrder changeReceiptSupplier(String poId) {
		PurchaseOrder existedPO = poRepo.findById(poId).orElse(null);
		if (existedPO != null) {
			existedPO.setReceiptSupplier(true);
			poRepo.save(existedPO);
			return existedPO;
		}
	return null;
	}
        
        @Override
	public String approvePO(String poId) {
		PurchaseOrder existedPO = poRepo.findById(poId).orElse(null);
		if (existedPO != null) {
			existedPO.setPoStatus("Approved");
			poRepo.save(existedPO);
			return "Approved";
		}
	return null;
	}
        
        @Override
	public String rejectPO(String poId) {
		PurchaseOrder existedPO = poRepo.findById(poId).orElse(null);
		if (existedPO != null) {
			existedPO.setPoStatus("Rejected");
			poRepo.save(existedPO);
			return "Rejected";
		}
	return null;
	}
	
        @Override
	public PurchaseOrder deletePO(String poId) {
		PurchaseOrder existedPO = poRepo.findById(poId).orElse(null);
		if (existedPO != null) {
			poRepo.delete(existedPO);
			return existedPO;
		} else {
			return null;
		}
	}

}
