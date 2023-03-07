package com.stock.main.controllers;

import com.stock.main.business.businessimpl.PurchaseProcessBusiness;
import com.stock.main.business.dtos.PurchaseProcessDTO;
import com.stock.main.entities.PurchaseProcess;
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
@RequestMapping("/pp")
@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
public class PurchaseProcessController {
    
        @Autowired
	private PurchaseProcessBusiness ppBusiness;
	
	@Autowired
        private ModelMapper modelMapper;
        
        @GetMapping("/all")
        public List<PurchaseProcess> getAllPPs() {
            return ppBusiness.getAllPPs();
        }
        
        @GetMapping("/{ppId}")
        public PurchaseProcess getOnePP(@PathVariable String ppId) {
            return ppBusiness.getOnePP(ppId);
        }
        
        @PostMapping("/create")
        public PurchaseProcess createPurchaseProcess(@RequestBody PurchaseProcessDTO ppDTO) {
            PurchaseProcess pp = convertToEntity(ppDTO);
            return ppBusiness.createPurchaseProcess(pp);
        }
        
        @PutMapping("/first-edit/{ppId}")
        public PurchaseProcess firstEditPP(@RequestBody PurchaseProcessDTO ppDTO, @PathVariable String ppId) {
            PurchaseProcess pp = convertToEntity(ppDTO);
            return ppBusiness.firstEditPP(pp, ppId);
        }
        
        @PutMapping("/edit-pp-pr/{ppId}")
        public PurchaseProcess editPPPR(@RequestBody PurchaseProcessDTO ppDTO, @PathVariable String ppId) {
            PurchaseProcess pp = convertToEntity(ppDTO);
            return ppBusiness.editPPPR(pp, ppId);
        }
        
        @PutMapping("/second-edit/{ppId}")
        public PurchaseProcess secondEditPP(@RequestBody PurchaseProcessDTO ppDTO, @PathVariable String ppId) {
            PurchaseProcess pp = convertToEntity(ppDTO);
            return ppBusiness.secondEditPP(pp, ppId);
        }
        
        @PutMapping("/third-edit/{ppId}")
        public PurchaseProcess thirdEditPP(@RequestBody PurchaseProcessDTO ppDTO, @PathVariable String ppId) {
            PurchaseProcess pp = convertToEntity(ppDTO);
            return ppBusiness.thirdEditPP(pp, ppId);
        }
        
        @PutMapping("/fourth-edit/{ppId}")
        public PurchaseProcess fourthEditPP(@RequestBody PurchaseProcessDTO ppDTO, @PathVariable String ppId) {
            PurchaseProcess pp = convertToEntity(ppDTO);
            return ppBusiness.fourthEditPP(pp, ppId);
        }
        
        @PutMapping("/fifth-edit/{ppId}")
        public PurchaseProcess fifthEditPP(@RequestBody PurchaseProcessDTO ppDTO, @PathVariable String ppId) {
            PurchaseProcess pp = convertToEntity(ppDTO);
            return ppBusiness.fifthEditPP(pp, ppId);
        }
        
        @PutMapping("/sixth-edit/{ppId}")
        public PurchaseProcess sixthEditPP(@RequestBody PurchaseProcessDTO ppDTO, @PathVariable String ppId) {
            PurchaseProcess pp = convertToEntity(ppDTO);
            return ppBusiness.sixthEditPP(pp, ppId);
        }
        
        @PutMapping("/seventh-edit-service/{ppId}")
        public PurchaseProcess seventhEditPPService(@PathVariable String ppId) {
            return ppBusiness.seventhEditPPService(ppId);
        }
        
        @PutMapping("/seventh-edit/{ppId}/{materialId}")
        public PurchaseProcess seventhEditPP(@PathVariable String ppId, @PathVariable String materialId) {
            return ppBusiness.seventhEditPP(ppId, materialId);
        }
        
        @PutMapping("/final-edit/{ppId}")
        public PurchaseProcess finalEditPPNoService(@PathVariable String ppId) {
            return ppBusiness.finalEditPPNoService(ppId);
        }
        
        @DeleteMapping("/delete/{ppId}")
        public PurchaseProcess deletePP(@PathVariable String ppId) {
            return ppBusiness.deletePP(ppId);
        }
        
        private PurchaseProcess convertToEntity(PurchaseProcessDTO ppDTO) {
	    return modelMapper.map(ppDTO, PurchaseProcess.class);
	}
    
}
