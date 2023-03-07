package ipact.manazello.accounting.business.businessimpl;

import ipact.manazello.accounting.business.ibusiness.IJournalBusiness;
import ipact.manazello.accounting.model.Journal;
import ipact.manazello.accounting.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

import java.util.List;


@Service
public class JournalBusinessImpl implements IJournalBusiness {


    private final JournalRepository journalRepository;


    @Autowired
    public JournalBusinessImpl(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    @Override
    public Journal addjournal(Journal journal) {
        Instant instanceNow = Instant.now();
        journal.setCreatedAt(instanceNow);
        journal.setArchived(false);
        return journalRepository.save(journal);

    }

    @Override
    public List<Journal> getAlljournal() {
        return journalRepository.findAll();
    }

    @Override
    public Journal getjournalByID(String id) {
        return journalRepository.findById(id).orElse(null);
    }

    @Override
    public Journal archive(String id) {
        Journal journal = journalRepository.findById(id).orElse(null);
        if(journal.isArchived()){journal.setArchived(false);}
        else {journal.setArchived(true);}
        return journalRepository.save(journal);
    }

}
