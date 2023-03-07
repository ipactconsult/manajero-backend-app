package com.stock.main.business.businessimpl;

import com.stock.main.business.ibusiness.IReplenishmentProcessBusiness;
import com.stock.main.entities.ReplenishmentProcess;
import com.stock.main.repositories.ReplenishmentProcessRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ReplenishmentProcessBusiness implements IReplenishmentProcessBusiness {
    
    @Autowired
    private ReplenishmentProcessRepository rpRepo;
    
    @Override
    public List<ReplenishmentProcess> getAllRPs() {
           List<ReplenishmentProcess> rps = rpRepo.findAll(
                   Sort.by(Sort.Direction.DESC, "rpCreation")
           );
           if (!rps.isEmpty()) {
                return rps;
           }
            return new ArrayList<>();
	}
    
    @Override
    public ReplenishmentProcess getOneRP(String ppId) {
        ReplenishmentProcess existedRP = rpRepo.findById(ppId).orElse(null);
        if (existedRP != null) {
            return existedRP;
	} else {
            return null;
	}
    }
    
    @Override
    public ReplenishmentProcess createRP(ReplenishmentProcess rp) {
        rp.setRpCreation(new Date());
        rpRepo.save(rp);
        return rp;
    }
    
    @Override
    public ReplenishmentProcess firstEditRP(String rpId) {
        ReplenishmentProcess existedRP = rpRepo.findById(rpId).orElse(null);
        if (existedRP != null) {
                existedRP.setStep(2);
                rpRepo.save(existedRP);
                return existedRP;
        }
        return null;
    }
    
    @Override
    public ReplenishmentProcess editPRState(ReplenishmentProcess rp, String rpId) {
        ReplenishmentProcess existedRP = rpRepo.findById(rpId).orElse(null);
        if (existedRP != null) {
                existedRP.setPr(rp.getPr());
                rpRepo.save(existedRP);
                return existedRP;
        }
        return null;
    }
    
    @Override
    public ReplenishmentProcess deleteRP(String rpId) {
        ReplenishmentProcess existedRP = rpRepo.findById(rpId).orElse(null);
        if (existedRP != null) {
            rpRepo.delete(existedRP);
            return existedRP;
	} else {
            return null;
	}
    }
    
}
