package ipact.manazello.accounting.business.businessimpl;

import ipact.manazello.accounting.business.ibusiness.ICreditBusiness;
import ipact.manazello.accounting.model.Credit;
import ipact.manazello.accounting.model.CreditPayment;
import ipact.manazello.accounting.repository.CreditPaymentRepository;
import ipact.manazello.accounting.repository.CreditRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class CreditBusinessImpl implements ICreditBusiness {

    private final CreditRepository cr;

    private final CreditPaymentRepository cpr;

    public CreditBusinessImpl(CreditRepository cr, CreditPaymentRepository cpr) {
        this.cr = cr;
        this.cpr = cpr;
    }


    @Override
    public Credit addCredit(Credit credit) {

        Instant instanceNow = Instant.now();
        credit.setCreatedAt(instanceNow);
        credit.setModifiedAt(instanceNow);
        credit.setArchived(false);
        double v = Math.pow((1 + credit.getInterestRate() ) / (1+credit.getInflationRate() ) ,(-1));
        credit.setV((float)v);
        Credit c = cr.save(credit);
        int periods = c.getPeriods();
        double payment = (credit.getInitialCapital()*(1-v))/(1-Math.pow(v,periods));
        double balance = credit.getInitialCapital() - payment;
        cpr.save(new CreditPayment(0,(float) payment,credit.getInitialCapital(),(float) balance,c));
        double pV = credit.getInitialCapital() * (1+credit.getInflationRate());
        double interest ;
        double taxP ;
        int period = 0;
        double sumInterest = 0 ;
        for (int i=1; i < periods; i++)
        {

            payment = (pV*(1-v))/(1-Math.pow(v,periods));
            interest = balance * c.getInterestRate();
            sumInterest = sumInterest + interest;
            taxP = interest * credit.getTaxRate();
            period = period + 1;
            balance = balance * (1+ credit.getInterestRate()) - payment;
            cpr.save(new CreditPayment((float) payment,c, period,(float)pV,(float)interest,(float)balance, (float)sumInterest,(float)taxP));
            pV = pV * (1+credit.getInflationRate());

        }

        return c;
    }

    @Override
    public List<Credit> getAllCredit() {
        return cr.findAll();
    }

    @Override
    public Credit getCreditById(String id) {
        return cr.findById(id).orElse(null);
    }


    @Override
    public Credit updateCredit(Credit credit) {
        Optional<Credit> creditManagedEntitys = cr.findById(credit.getId());
        return ((creditManagedEntitys.isPresent()) ? cr.save(credit) : null);

    }

    @Override
    public Credit archive(String id) {
        Credit credit = cr.findById(id).orElse(null);
        if(credit.isArchived()) {credit.setArchived(false);}
        else{credit.setArchived(true);}
        return cr.save(credit);
    }


}
