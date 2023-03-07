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

import com.stock.main.business.businessimpl.StockExitBusiness;
import com.stock.main.business.dtos.StockExitDTO;
import com.stock.main.entities.StockExit;

@RestController
@RequestMapping("/stock-exit")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class StockExitController {
	
	@Autowired
	private StockExitBusiness seBusiness;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping("/all")
	public List<StockExit> getAllStockExits() {
		return seBusiness.getAllStockExits();
	}
	
	@GetMapping("/all/asc")
	public List<StockExit> getAllStockExitsASC() {
		return seBusiness.getAllStockExitsASC();
	}
	
	@GetMapping("/all/desc")
	public List<StockExit> getAllStockExitsDESC() {
		return seBusiness.getAllStockExitsDESC();
	}
	
	@PostMapping("/create")
	public StockExit addNewStockExit(@RequestBody StockExitDTO stockExitDTO) {
		StockExit stockExit = convertToEntity(stockExitDTO);
		return seBusiness.addNewStockExit(stockExit);
	}
	
	@PutMapping("/archive/{stockExitId}")
	public StockExit archiveStockExit(@PathVariable String stockExitId) {
		return seBusiness.archiveStockExit(stockExitId);
	}
	
	@PutMapping("/restore/{stockExitId}")
	public StockExit restoreStockExit(@PathVariable String stockExitId) {
		return seBusiness.restoreStockExit(stockExitId);
	}
	
	private StockExit convertToEntity(StockExitDTO stockExitDTO) {
	    return modelMapper.map(stockExitDTO, StockExit.class);
	}

}
