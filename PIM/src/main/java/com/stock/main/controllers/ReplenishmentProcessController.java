package com.stock.main.controllers;

import com.stock.main.business.businessimpl.ReplenishmentProcessBusiness;
import com.stock.main.business.dtos.ReplenishmentProcessDTO;
import com.stock.main.entities.ReplenishmentProcess;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rp")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class ReplenishmentProcessController {
    
        @Autowired
	private ReplenishmentProcessBusiness rpBusiness;
	
	@Autowired
        private ModelMapper modelMapper;
        
        @GetMapping("/all")
        public List<ReplenishmentProcess> getAllRPs() {
            return rpBusiness.getAllRPs();
        }
        
        @GetMapping("/{rpId}")
        public ReplenishmentProcess getOneRP(@PathVariable String rpId) {
            return rpBusiness.getOneRP(rpId);
        }
        
        @PostMapping("/create")
        public ReplenishmentProcess createRP(@RequestBody ReplenishmentProcessDTO rpDTO) {
            ReplenishmentProcess rp = convertToEntity(rpDTO);
            return rpBusiness.createRP(rp);
        }
        
        @PutMapping("/first-edit/{rpId}")
        public ReplenishmentProcess firstEditRP(@PathVariable String rpId) {
            return rpBusiness.firstEditRP(rpId);
        }
        
        @PutMapping("/edit-pr/{rpId}")
        public ReplenishmentProcess editPRState(@RequestBody ReplenishmentProcessDTO rpDTO,
                @PathVariable String rpId) {
            ReplenishmentProcess rp = convertToEntity(rpDTO);
            return rpBusiness.editPRState(rp, rpId);
        }
        
        @DeleteMapping("/delete/{rpId}")
        public ReplenishmentProcess deletePP(@PathVariable String rpId) {
            return rpBusiness.deleteRP(rpId);
        }
        
        private ReplenishmentProcess convertToEntity(ReplenishmentProcessDTO rpDTO) {
	    return modelMapper.map(rpDTO, ReplenishmentProcess.class);
	}
    
}
