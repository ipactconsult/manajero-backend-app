package com.stock.main.business.ibusiness;

import com.stock.main.entities.ReplenishmentProcess;
import java.util.List;

public interface IReplenishmentProcessBusiness {
    
    public List<ReplenishmentProcess> getAllRPs();
    public ReplenishmentProcess getOneRP(String rpId);
    public ReplenishmentProcess createRP(ReplenishmentProcess rp);
    public ReplenishmentProcess firstEditRP(String rpId);
    public ReplenishmentProcess editPRState(ReplenishmentProcess rp, String rpId);
    public ReplenishmentProcess deleteRP(String rpId);
    
}
