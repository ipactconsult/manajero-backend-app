package com.stock.main.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.main.business.businessimpl.StockEntryBusiness;
import com.stock.main.business.dtos.StockEntryDTO;
import com.stock.main.entities.StockEntry;

@RestController
@RequestMapping("/stock-entry")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class StockEntryController {
	
	@Autowired
	private StockEntryBusiness stockEntryBusiness;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping("/all")
	public List<StockEntry> getAllStockEntries() {
		return stockEntryBusiness.getAllStockEntries();
	}
	
	@GetMapping("/all/asc")
	public List<StockEntry> getAllStockEntriesASC() {
		return stockEntryBusiness.getAllStockEntriesASC();
	}
	
	@GetMapping("/all/desc")
	public List<StockEntry> getAllStockEntriesDESC() {
		return stockEntryBusiness.getAllStockEntriesDESC();
	}
	
	@PostMapping("/create")
	public StockEntry addNewStockEntry(@RequestBody StockEntryDTO stockEntryDTO) {
		StockEntry stockEntry = convertToEntity(stockEntryDTO);
		return stockEntryBusiness.addNewStockEntry(stockEntry);
	}
	
	@PutMapping("/archive/{stockEntryId}")
	public StockEntry archiveStockEntry(@PathVariable String stockEntryId) {
		return stockEntryBusiness.archiveStockEntry(stockEntryId);
	}
	
	@PutMapping("/restore/{stockEntryId}")
	public StockEntry restoreStockEntry(@PathVariable String stockEntryId) {
		return stockEntryBusiness.restoreStockEntry(stockEntryId);
	}
	
	private StockEntry convertToEntity(StockEntryDTO stockEntryDTO) {
	    return modelMapper.map(stockEntryDTO, StockEntry.class);
	}

}
