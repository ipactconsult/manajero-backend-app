package ipact.manazello.accounting.business.ibusiness;


import ipact.manazello.accounting.model.Journal;



import java.util.List;

public interface IJournalBusiness {
    Journal addjournal (Journal journal);
    List<Journal> getAlljournal ();
    Journal getjournalByID(String id);
    Journal archive(String id);
}
