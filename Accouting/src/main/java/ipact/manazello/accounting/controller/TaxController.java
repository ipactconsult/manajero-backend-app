package ipact.manazello.accounting.controller;


import ipact.manazello.accounting.business.ibusiness.ITaxBusiness;
import ipact.manazello.accounting.model.Dto.TaxDto;
import ipact.manazello.accounting.model.Tax;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
@RestController
@RequestMapping("/Tax")
public class TaxController {

    private final ITaxBusiness tb;

    private final ModelMapper modelMapper;

    @Autowired
    public TaxController(ITaxBusiness tb, ModelMapper modelMapper){
        this.tb = tb;
        this.modelMapper = modelMapper;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Tax> createTax(@RequestBody TaxDto taxDto) {
        Tax tax = modelMapper.map(taxDto, Tax.class);
        return ((tb.addTax(tax) != null)
                ? new ResponseEntity<>(tb.addTax(tax), HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping("/taxrates")
    public ResponseEntity<List<Tax>> getAllTax() {
        try {
            List<Tax> tax = tb.getAllTaxe();

            if (tax.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tax, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTax(@PathVariable("id") String id) {
        try {
            tb.deleteTax(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/Put")
    public ResponseEntity<Tax> updateTax(@RequestBody TaxDto taxDto){
        Tax tax = modelMapper.map(taxDto, Tax.class);
        return ((tb.updateTax(tax) != null)
                ? new ResponseEntity<>(tb.addTax(tax), HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

    }
}
