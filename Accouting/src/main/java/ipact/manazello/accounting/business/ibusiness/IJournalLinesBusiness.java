package ipact.manazello.accounting.business.ibusiness;

import ipact.manazello.accounting.model.JournalLines;


import java.util.Date;
import java.util.List;

public interface IJournalLinesBusiness {
    JournalLines addjournalline (JournalLines journalline);
    List<JournalLines> getAlljournallines ();
    JournalLines getjournallineByID(String id);
    List<JournalLines> findByJournal(String id);
    List<JournalLines> exportLinesPDF(String id);
    List<JournalLines> findByAccountAndPeriod(String id,Date d1, Date d2);

    String exportLedger(String id);
}
