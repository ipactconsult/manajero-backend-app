package com.stock.main.business.businessimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stock.main.business.ibusiness.IStockEntryBusiness;
import com.stock.main.entities.StockEntry;
import com.stock.main.repositories.StockEntryRepository;

@Service
public class StockEntryBusiness implements IStockEntryBusiness {
	
	@Autowired
	private StockEntryRepository stockEntryRepo;
	
	public List<StockEntry> getAllStockEntries() {
		List<StockEntry> stockEntries = stockEntryRepo.findAll(
                        Sort.by(Sort.Direction.DESC, "stockEntryDate")
                );
		if (!stockEntries.isEmpty()) {
			return stockEntries;
		}
		return new ArrayList<>();
	}
	
	public List<StockEntry> getAllStockEntriesASC() {
		List<StockEntry> stockEntries = stockEntryRepo.findAll(
				Sort.by(Sort.Direction.ASC, "stockEntryRef"));
		if (!stockEntries.isEmpty()) {
			return stockEntries;
		}
		return new ArrayList<>();
	}
	
	public List<StockEntry> getAllStockEntriesDESC() {
		List<StockEntry> stockEntries = stockEntryRepo.findAll(
				Sort.by(Sort.Direction.DESC, "stockEntryRef"));
		if (!stockEntries.isEmpty()) {
			return stockEntries;
		}
		return new ArrayList<>();
	}
	
	public StockEntry addNewStockEntry(StockEntry stockEntry) {
		stockEntry.setStockEntryDate(new Date());
		stockEntry.setStockEntryState(true);
		stockEntryRepo.save(stockEntry);
		return stockEntry;
	}
	
	public StockEntry archiveStockEntry(String stockEntryId) {
		StockEntry existedStockEntry = stockEntryRepo.findById(stockEntryId).orElse(null);
		if (existedStockEntry != null) {
			existedStockEntry.setStockEntryState(false);
			stockEntryRepo.save(existedStockEntry);
			return existedStockEntry;
		}
	return null;
	}
	
	public StockEntry restoreStockEntry(String stockEntryId) {
		StockEntry existedStockEntry = stockEntryRepo.findById(stockEntryId).orElse(null);
		if (existedStockEntry != null) {
			existedStockEntry.setStockEntryState(true);
			stockEntryRepo.save(existedStockEntry);
			return existedStockEntry;
		}
	return null;
	}

}
