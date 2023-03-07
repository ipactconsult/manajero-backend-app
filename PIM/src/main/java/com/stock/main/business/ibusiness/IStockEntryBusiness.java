package com.stock.main.business.ibusiness;

import java.util.List;

import com.stock.main.entities.StockEntry;

public interface IStockEntryBusiness {
	
	public List<StockEntry> getAllStockEntries();
	public List<StockEntry> getAllStockEntriesASC();
	public List<StockEntry> getAllStockEntriesDESC();
	public StockEntry addNewStockEntry(StockEntry stockEntry);
	public StockEntry archiveStockEntry(String stockEntryId);
	public StockEntry restoreStockEntry(String stockEntryId);

}
