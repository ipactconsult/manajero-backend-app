package com.stock.main.business.ibusiness;

import com.stock.main.entities.PurchaseProcess;
import java.util.List;

public interface IPurchaseProcessBusiness {
    
    public List<PurchaseProcess> getAllPPs();
    public PurchaseProcess getOnePP(String ppId);
    public PurchaseProcess createPurchaseProcess(PurchaseProcess pp);
    public PurchaseProcess firstEditPP(PurchaseProcess pp, String ppId);
    public PurchaseProcess editPPPR(PurchaseProcess pp, String ppId);
    public PurchaseProcess secondEditPP(PurchaseProcess pp, String ppId);
    public PurchaseProcess thirdEditPP(PurchaseProcess pp, String ppId);
    public PurchaseProcess fourthEditPP(PurchaseProcess pp, String ppId);
    public PurchaseProcess fifthEditPP(PurchaseProcess pp, String ppId);
    public PurchaseProcess sixthEditPP(PurchaseProcess pp, String ppId);
    public PurchaseProcess seventhEditPPService(String ppId);
    public PurchaseProcess seventhEditPP(String ppId, String materialId);
    public PurchaseProcess finalEditPPNoService(String ppId);
    public PurchaseProcess deletePP(String ppId);
    
}
