package ipact.manazello.accounting.business.businessimpl;

import ipact.manazello.accounting.business.ibusiness.IAccountBusiness;
import ipact.manazello.accounting.business.ibusiness.IJournalLinesBusiness;
import ipact.manazello.accounting.model.Account;
import ipact.manazello.accounting.model.Journal;
import ipact.manazello.accounting.model.JournalLines;
import ipact.manazello.accounting.repository.JournalLinesRepository;
import ipact.manazello.accounting.repository.JournalRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.bson.types.ObjectId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;

import java.util.*;

@Service
public class JournalLinesBuisnessImpl implements IJournalLinesBusiness {




    private final JournalLinesRepository journalLinesRepository;
    private final JournalRepository jr;
    private final IAccountBusiness ab;


    @Autowired
    public JournalLinesBuisnessImpl(JournalLinesRepository journalLinesRepository, JournalRepository jr, IAccountBusiness ab) {
        this.journalLinesRepository = journalLinesRepository;
        this.jr = jr;
        this.ab = ab;
    }

    @Override
    public JournalLines addjournalline(JournalLines journalLines) {
        Instant instanceNow = Instant.now();
        float balance = journalLines.getDebit() - journalLines.getCredit()  ;
        journalLines.setCreatedAt(instanceNow);
        journalLines.setBalance(balance);
        ab.updateBalance(journalLines.getAccount(), balance);
        Account checkingAccount = ab.getaccountByID("62d56219f4f5d05dc79e995d");
        ab.updateBalance(checkingAccount, balance);
        return journalLinesRepository.save(journalLines);

    }

    @Override
    public List<JournalLines> getAlljournallines() {
        return journalLinesRepository.findAll();
    }

    @Override
    public JournalLines getjournallineByID(String id) {
        return journalLinesRepository.findById(id).orElse(null);
    }



    @Override
    public List<JournalLines> findByJournal(String id) {
        return journalLinesRepository.findAllByJournal_Id(new ObjectId(id));
    }



    @Override
    public List<JournalLines> exportLinesPDF(String id) {

        List<JournalLines> lines =  journalLinesRepository.findAllByJournal_Id(new ObjectId(id));

        float total =0.0f;
        for (int i = 0; i < lines.size(); i++)
           total = total + lines.get(i).getBalance();

        try{
            String filePath = "D:\\internship_Ipact\\accounting\\src\\main\\resources\\templates\\Simple_Blue2.jrxml";

            Journal j = jr.findById(id).orElse(null);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("code",j.getCode());
            parameters.put("journalName",j.getName());
            parameters.put("balanceTotal",total);

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lines);

            JasperReport report = JasperCompileManager.compileReport(filePath);

            JasperPrint print = JasperFillManager.fillReport(report,parameters,dataSource);

            JasperExportManager.exportReportToPdfFile(print,"D:\\internship_Ipact\\reportspdf\\Report"+j.getName()+".pdf" );



        }  catch (Exception e) {
            return lines;
        }
        return lines;
    }

    @Override
    public List<JournalLines> findByAccountAndPeriod(String id, Date d1, Date d2) {
        List<JournalLines> lines = journalLinesRepository.findAllByAccount_Id(new ObjectId(id));
        List<JournalLines> res = null;
        Instant i;
        Instant i1 = d1.toInstant();
        Instant i2 = d2.toInstant();

        for(int j = 0; j< lines.size(); j++){
            i = lines.get(j).getCreatedAt();
            if(i.compareTo(i1) > 0 && i.compareTo(i2) < 0)
                res.add(lines.get(j));
        }
        return res;
    }

    @Override
    public String exportLedger(String id){
        List<JournalLines> lines = journalLinesRepository.findAllByAccount_Id(new ObjectId(id));
        float total =0.0f;
        float tdebit =0.0f;
        float tcredit =0.0f;
        for (int i = 0; i < lines.size(); i++) {
            total = total + lines.get(i).getBalance();
            tdebit = tdebit + lines.get(i).getDebit();
            tcredit = tcredit + lines.get(i).getCredit();
        }
        try{
            String filePath = "D:\\internship_Ipact\\accounting\\src\\main\\resources\\templates\\Blank_A4_Landscape.jrxml";

            Account a = ab.getaccountByID(id);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("journalName",a.getName());
            parameters.put("balanceTotal",total);
            parameters.put("debitTotal",tdebit);
            parameters.put("creditTotal",tcredit);
            parameters.put("accountName",a.getName());

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lines);

            JasperReport report = JasperCompileManager.compileReport(filePath);

            JasperPrint print = JasperFillManager.fillReport(report,parameters,dataSource);

            JasperExportManager.exportReportToPdfFile(print,"D:\\internship_Ipact\\reportspdf\\Ledger_"+a.getName()+".pdf" );



        }  catch (Exception e) {
            return ""+e;

        }


        return "lines";
    }
}
