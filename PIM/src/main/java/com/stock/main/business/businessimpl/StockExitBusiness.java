package com.stock.main.business.businessimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stock.main.business.ibusiness.IStockExitBusiness;
import com.stock.main.entities.StockExit;
import com.stock.main.repositories.StockExitRepository;

@Service
public class StockExitBusiness implements IStockExitBusiness {
	
	@Autowired
	private StockExitRepository stockExitRepo;
	
	public List<StockExit> getAllStockExits() {
		List<StockExit> stockExits = stockExitRepo.findAll(
                        Sort.by(Sort.Direction.DESC, "stockExitDate")
                );
		if (!stockExits.isEmpty()) {
			return stockExits;
		}
		return new ArrayList<>();
	}
	
	public List<StockExit> getAllStockExitsASC() {
		List<StockExit> stockExits = stockExitRepo.findAll(
				Sort.by(Sort.Direction.ASC, "stockExitRef"));
		if (!stockExits.isEmpty()) {
			return stockExits;
		}
		return new ArrayList<>();
	}
	
	public List<StockExit> getAllStockExitsDESC() {
		List<StockExit> stockExits = stockExitRepo.findAll(
				Sort.by(Sort.Direction.DESC, "stockExitRef"));
		if (!stockExits.isEmpty()) {
			return stockExits;
		}
		return new ArrayList<>();
	}
	
	public StockExit addNewStockExit(StockExit stockExit) {
		stockExit.setStockExitDate(new Date());
		stockExit.setStockExitState(true);
		stockExitRepo.save(stockExit);
		return stockExit;
	}
	
	public StockExit archiveStockExit(String stockExitId) {
		StockExit existedStockExit = stockExitRepo.findById(stockExitId).orElse(null);
		if (existedStockExit != null) {
			existedStockExit.setStockExitState(false);
			stockExitRepo.save(existedStockExit);
			return existedStockExit;
		}
	return null;
	}
	
	public StockExit restoreStockExit(String stockExitId) {
		StockExit existedStockExit = stockExitRepo.findById(stockExitId).orElse(null);
		if (existedStockExit != null) {
			existedStockExit.setStockExitState(true);
			stockExitRepo.save(existedStockExit);
			return existedStockExit;
		}
	return null;
	}

}
