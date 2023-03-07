package com.stock.main.business.ibusiness;

import java.util.List;

import com.stock.main.entities.StockMovement;

public interface IStockMovement {
	
	public List<StockMovement> getAllSMs();
	public List<StockMovement> getAllSMsASCByCode();
	public List<StockMovement> getAllSMsDESCByCode();
	public StockMovement getOneSM(String smId);
	public StockMovement addNewSM(StockMovement sm, String materialId);
        public StockMovement archiveSM(String smId);
        public StockMovement restoreSM(String smId);

}
