package ipact.manazello.accounting.controller;

import ipact.manazello.accounting.business.ibusiness.IJournalLinesBusiness;
import ipact.manazello.accounting.model.JournalLines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;



import java.util.List;


@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})

@RestController
@RequestMapping("/journalLines")
@EnableCaching
public class JounalLinesController {

    private final IJournalLinesBusiness iJournalLinesBusiness;




    @Autowired
    public JounalLinesController( IJournalLinesBusiness iJournalLinesBusiness){
        this.iJournalLinesBusiness = iJournalLinesBusiness;
    }

    @PostMapping(value="/add")
    public JournalLines writeJournalLine(@RequestBody JournalLines journalLines){
        return iJournalLinesBusiness.addjournalline(journalLines);

    }
    @GetMapping("/journalslines")
    public ResponseEntity<List<JournalLines>> getAllLines(){
        try {
            List<JournalLines> journallines = iJournalLinesBusiness.getAlljournallines();

            if (journallines.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(journallines, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/ledgerpdf/{id}")
    public String getLedgerPDF(@PathVariable("id") String id){
        return iJournalLinesBusiness.exportLedger(id);
    }


    @GetMapping("/journalslines/{id}")
    public ResponseEntity<List<JournalLines>> getByJournal(@PathVariable("id") String id){
        try {
            List<JournalLines> journallines = iJournalLinesBusiness.findByJournal(id);

            if (journallines.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(journallines, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/topdf/{id}")
    public List<JournalLines> exportToPDF(@PathVariable("id") String id){
        return iJournalLinesBusiness.exportLinesPDF(id);
    }


}
