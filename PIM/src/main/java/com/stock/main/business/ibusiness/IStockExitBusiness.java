package com.stock.main.business.ibusiness;

import java.util.List;

import com.stock.main.entities.StockExit;

public interface IStockExitBusiness {
	
	public List<StockExit> getAllStockExits();
	public List<StockExit> getAllStockExitsASC();
	public List<StockExit> getAllStockExitsDESC();
	public StockExit addNewStockExit(StockExit stockExit);
	public StockExit archiveStockExit(String stockExitId);
	public StockExit restoreStockExit(String stockExitId);

}
