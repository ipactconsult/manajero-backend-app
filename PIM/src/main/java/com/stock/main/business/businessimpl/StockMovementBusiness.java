package com.stock.main.business.businessimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stock.main.business.ibusiness.IStockMovement;
import com.stock.main.entities.Material;
import com.stock.main.entities.StockMovement;
import com.stock.main.repositories.MaterialRepository;
import com.stock.main.repositories.StockMovementRepository;

@Service
public class StockMovementBusiness implements IStockMovement {
	
	@Autowired
	private StockMovementRepository smRepo;
	
	@Autowired
	private MaterialRepository materialRepo;
	
        @Override
	public List<StockMovement> getAllSMs() {
		List<StockMovement> sms = smRepo.findAll(
                        Sort.by(Sort.Direction.DESC, "dateSM")
                );
		if (!sms.isEmpty()) {
			return sms;
		}
		return new ArrayList<>();
	}
	
        @Override
	public List<StockMovement> getAllSMsASCByCode() {
		List<StockMovement> sms = smRepo.findAll(
				Sort.by(Sort.Direction.ASC, "smCode"));
		if (!sms.isEmpty()) {
			return sms;
		}
		return new ArrayList<>();
	}
	
        @Override
	public List<StockMovement> getAllSMsDESCByCode() {
		List<StockMovement> sms = smRepo.findAll(
				Sort.by(Sort.Direction.DESC, "smCode"));
		if (!sms.isEmpty()) {
			return sms;
		}
		return new ArrayList<>();
	}
	
        @Override
	public StockMovement getOneSM(String smId) {
				StockMovement existedSM = smRepo.findById(smId).orElse(null);
				if (existedSM != null) {
					return existedSM;
				}
			return null;
	}
	
        @Override
	public StockMovement addNewSM(StockMovement sm, String materialId) {
			sm.setDateSM(new Date());
                        sm.setActiveState(true);
			Material existedMaterial = materialRepo.findById(materialId).orElse(null);
			if (existedMaterial != null) {
				sm.setMaterial(existedMaterial);
			}
			smRepo.save(sm);
			return sm;
	}
        
        @Override
        public StockMovement archiveSM(String smId) {
            StockMovement existedSM = smRepo.findById(smId).orElse(null);
				if (existedSM != null) {
					existedSM.setActiveState(false);
					smRepo.save(existedSM);
					return existedSM;
				} else {
					return null;
				}
        }
        
        @Override
        public StockMovement restoreSM(String smId) {
            StockMovement existedSM = smRepo.findById(smId).orElse(null);
				if (existedSM != null) {
					existedSM.setActiveState(true);
					smRepo.save(existedSM);
					return existedSM;
				} else {
					return null;
				}
        }

}
