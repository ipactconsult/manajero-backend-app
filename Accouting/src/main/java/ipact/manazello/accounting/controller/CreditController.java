package ipact.manazello.accounting.controller;


import ipact.manazello.accounting.business.ibusiness.ICreditBusiness;
import ipact.manazello.accounting.model.Credit;
import ipact.manazello.accounting.model.Dto.CreditDto;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
@RestController
@RequestMapping("/credit")
public class CreditController {



    private final ICreditBusiness cb;

    private final ModelMapper modelMapper;

    @Autowired
    public CreditController( ICreditBusiness cb, ModelMapper modelMapper){
        this.cb = cb;
        this.modelMapper = modelMapper;
    }
    @PostMapping(value = "/add")
    public Credit createCredit(@RequestBody Credit credit) {
        return cb.addCredit(credit);
    }
    @GetMapping("/credits")
    public ResponseEntity<List<Credit>> getAllCredits() {
        try {
            List<Credit> credit = cb.getAllCredit();

            if (credit.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(credit, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/findByIdCredit/{id}")
    public ResponseEntity<Credit> findByIdCredit(@PathVariable String id) {
        Credit credit = cb.getCreditById(id);
        return (credit != null) ? new ResponseEntity<>(credit, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Credit> updateCredit(@RequestBody CreditDto creditDto) {
        Credit credit = modelMapper.map(creditDto, Credit.class);
        return ((cb.updateCredit(credit) != null)
                ? new ResponseEntity<>(cb.addCredit(credit), HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

    }

    @PutMapping("/archiver/{id}")
    public Credit archive(@PathVariable("id") String id){
        return cb.archive(id);
    }


}
