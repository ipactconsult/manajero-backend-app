package com.stock.main.business.businessimpl;

import com.stock.main.business.ibusiness.IInventoryMovementBusiness;
import com.stock.main.entities.InventoryMovement;
import com.stock.main.repositories.InventoryMovementRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class InventoryMovementBusiness implements IInventoryMovementBusiness {
    
    @Autowired
        private InventoryMovementRepository imRepo;
        
        @Override
        public List<InventoryMovement> getAllIMs() {
            List<InventoryMovement> ims = imRepo.findAll(
                    Sort.by(Sort.Direction.DESC, "imCreationDate")
            );
		if (!ims.isEmpty()) {
			return ims;
		}
		return new ArrayList<>();
        }
        
        @Override
        public List<InventoryMovement> getAllIMsASC() {
            List<InventoryMovement> ims = imRepo.findAll(
              Sort.by(Sort.Direction.ASC, "imRef")
            );
		if (!ims.isEmpty()) {
			return ims;
		}
		return new ArrayList<>();
        }
        
        @Override
        public List<InventoryMovement> getAllIMsDESC() {
            List<InventoryMovement> ims = imRepo.findAll(
              Sort.by(Sort.Direction.DESC, "imRef")
            );
		if (!ims.isEmpty()) {
			return ims;
		}
		return new ArrayList<>();
        }
        
        @Override
        public InventoryMovement getOneIM(String imId) {
            InventoryMovement existedIM = imRepo.findById(imId).orElse(null);
				if (existedIM != null) {
					return existedIM;
				} else {
					return null;
				}
        }
        
        @Override
        public InventoryMovement createIM(InventoryMovement im) {
            im.setImCreationDate(new Date());
            im.setImState(true);
            imRepo.save(im);
            return im;
        }
        
        @Override
        public InventoryMovement archiveIM(String imId) {
            InventoryMovement existedIM = imRepo.findById(imId).orElse(null);
				if (existedIM != null) {
					existedIM.setImState(false);
					imRepo.save(existedIM);
					return existedIM;
				} else {
					return null;
				}
        }
        
        @Override
        public InventoryMovement restoreIM(String imId) {
            InventoryMovement existedIM = imRepo.findById(imId).orElse(null);
				if (existedIM != null) {
					existedIM.setImState(true);
					imRepo.save(existedIM);
					return existedIM;
				} else {
					return null;
				}
        }
        
        @Override
        public InventoryMovement deleteIM(String imId) {
            InventoryMovement existedIM = imRepo.findById(imId).orElse(null);
        if (existedIM != null) {
            imRepo.delete(existedIM);
            return existedIM;
	} else {
            return null;
	}
        }
    
}
