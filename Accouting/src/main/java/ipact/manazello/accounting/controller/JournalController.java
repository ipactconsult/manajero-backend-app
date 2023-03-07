package ipact.manazello.accounting.controller;

import ipact.manazello.accounting.business.ibusiness.IJournalBusiness;
import ipact.manazello.accounting.model.Journal;
import ipact.manazello.accounting.repository.JournalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})

@RestController
@RequestMapping("/journal")
public class JournalController {
    private final JournalRepository journalRepository;
    private final IJournalBusiness iJournalBusiness;


    @Autowired
    public JournalController(JournalRepository journalRepository, IJournalBusiness iJournalBusiness){
        this.journalRepository = journalRepository;



        this.iJournalBusiness = iJournalBusiness;
    }
    @PostMapping(value = "/add")
    public Journal createJournal(@RequestBody Journal journal) {
        return iJournalBusiness.addjournal(journal);
    }


    @GetMapping("/getalljournalsbyname/{name}")
    public List<Journal> getJournalbyName(@PathVariable String name) {
        return journalRepository.findByName(name);
    }
    @GetMapping("/journals")
    public List<Journal> getAlljournal() {
        return iJournalBusiness.getAlljournal();
    }
    @GetMapping("/journal/{id}")
    public ResponseEntity<Journal> getJournalbyId (@PathVariable("id") String id){
        Journal journal = iJournalBusiness.getjournalByID(id);
        return (journal != null) ? new ResponseEntity<>(journal, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/journals/{id}")
    public ResponseEntity<HttpStatus> deletejournal(@PathVariable("id") String id) {
        try {
            journalRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping( "/journals/descending")
    public ResponseEntity<List<Journal>> listJournalDesc(){
        return new ResponseEntity<>(journalRepository.findAll(Sort.by("name").descending()), HttpStatus.OK);
    }
    @GetMapping( "/journals/ascending")
    public ResponseEntity<List<Journal>> listJournalAsc(){
        return new ResponseEntity<>(journalRepository.findAll(Sort.by("name").ascending()), HttpStatus.OK);
    }

    @PutMapping("/archiver/{id}")
    public Journal archive(@PathVariable("id") String id){
        return iJournalBusiness.archive(id);
    }

}
