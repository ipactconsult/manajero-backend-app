package com.stock.main.business.businessimpl;

import com.stock.main.business.ibusiness.IPurchaseProcessBusiness;
import com.stock.main.entities.Material;
import com.stock.main.repositories.PurchaseProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.main.entities.PurchaseProcess;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseProcessBusiness implements IPurchaseProcessBusiness {
    
    @Autowired
    private PurchaseProcessRepository ppRepo;
    
    @Override
    public List<PurchaseProcess> getAllPPs() {
           List<PurchaseProcess> pps = ppRepo.findAll();
           if (!pps.isEmpty()) {
                return pps;
           }
            return new ArrayList<>();
	}
    
    @Override
    public PurchaseProcess getOnePP(String ppId) {
        PurchaseProcess existedPP = ppRepo.findById(ppId).orElse(null);
        if (existedPP != null) {
            return existedPP;
	} else {
            return null;
	}
    }
    
    @Override
    public PurchaseProcess createPurchaseProcess(PurchaseProcess pp) {
        pp.setMaterialsStocked(0);
        ppRepo.save(pp);
        return pp;
    }
    
    @Override
    public PurchaseProcess firstEditPP(PurchaseProcess pp, String ppId) {
        PurchaseProcess existedPP = ppRepo.findById(ppId).orElse(null);
        if (existedPP != null) {
                existedPP.setStep(pp.getStep());
                existedPP.setPr(pp.getPr());
                existedPP.setMaterials(pp.getMaterials());
                ppRepo.save(existedPP);
                return existedPP;
        }
        return null;
    }
    
    @Override
    public PurchaseProcess editPPPR(PurchaseProcess pp, String ppId) {
        PurchaseProcess existedPP = ppRepo.findById(ppId).orElse(null);
        if (existedPP != null) {
                existedPP.setPr(pp.getPr());
                ppRepo.save(existedPP);
                return existedPP;
        }
        return null;
    }
    
    @Override
    public PurchaseProcess secondEditPP(PurchaseProcess pp, String ppId) {
        PurchaseProcess existedPP = ppRepo.findById(ppId).orElse(null);
        if (existedPP != null) {
                existedPP.setStep(pp.getStep());
                existedPP.setRfq(pp.getRfq());
                ppRepo.save(existedPP);
                return existedPP;
        }
        return null;
    }
    
    @Override
    public PurchaseProcess thirdEditPP(PurchaseProcess pp, String ppId) {
        PurchaseProcess existedPP = ppRepo.findById(ppId).orElse(null);
        if (existedPP != null) {
                existedPP.setStep(pp.getStep());
                existedPP.setQuotations(pp.getQuotations());
                ppRepo.save(existedPP);
                return existedPP;
        }
        return null;
    }
    
    @Override
    public PurchaseProcess fourthEditPP(PurchaseProcess pp, String ppId) {
        PurchaseProcess existedPP = ppRepo.findById(ppId).orElse(null);
        if (existedPP != null) {
                existedPP.setStep(pp.getStep());
                existedPP.setSupplier(pp.getSupplier());
                ppRepo.save(existedPP);
                return existedPP;
        }
        return null;
    }
    
    @Override
    public PurchaseProcess fifthEditPP(PurchaseProcess pp, String ppId) {
        PurchaseProcess existedPP = ppRepo.findById(ppId).orElse(null);
        if (existedPP != null) {
                existedPP.setStep(pp.getStep());
                existedPP.setPo(pp.getPo());
                ppRepo.save(existedPP);
                return existedPP;
        }
        return null;
    }
    
    @Override
    public PurchaseProcess sixthEditPP(PurchaseProcess pp, String ppId) {
        PurchaseProcess existedPP = ppRepo.findById(ppId).orElse(null);
        if (existedPP != null) {
                existedPP.setPo(pp.getPo());
                ppRepo.save(existedPP);
                return existedPP;
        }
        return null;
    }
    
    @Override
    public PurchaseProcess seventhEditPPService(String ppId) {
        PurchaseProcess existedPP = ppRepo.findById(ppId).orElse(null);
        if (existedPP != null) {
                existedPP.setStep(7);
                ppRepo.save(existedPP);
                return existedPP;
        }
        return null;
    }
    
    @Override
    public PurchaseProcess seventhEditPP(String ppId, String materialId) {
        PurchaseProcess existedPP = ppRepo.findById(ppId).orElse(null);
        if (existedPP != null) {
            existedPP.setMaterialsStocked(existedPP.getMaterialsStocked() + 1);
            for (Material material : existedPP.getMaterials()) {
                if (material.getMaterialId().equals(materialId)) {
                    material.setStockState(true);
                }
            }
                ppRepo.save(existedPP);
                return existedPP;
        }
        return null;
    }
    
    @Override
    public PurchaseProcess finalEditPPNoService(String ppId) {
        PurchaseProcess existedPP = ppRepo.findById(ppId).orElse(null);
        int numberProdsRM = 0;
        int stocked = 0;
        if (existedPP != null) {
            for (Material material : existedPP.getMaterials()) {
                if (material.getMaterialType().equals("Finished Product") || 
                        material.getMaterialType().equals("Raw Material")) {
                        numberProdsRM = numberProdsRM + 1;
                    }
                if (material.getStockState()) {
                    stocked = stocked + 1;
                }
                }
            if (numberProdsRM == stocked) {
                existedPP.setStep(7);
            } else {
                existedPP.setStep(6);
            }
            ppRepo.save(existedPP);
                return existedPP;
            }
             return null;   
        }
    
    @Override
    public PurchaseProcess deletePP(String ppId) {
        PurchaseProcess existedPP = ppRepo.findById(ppId).orElse(null);
        if (existedPP != null) {
            ppRepo.delete(existedPP);
            return existedPP;
	} else {
            return null;
	}
    }
    
}
