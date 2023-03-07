package ipact.manazello.accounting.business.businessimpl;

import ipact.manazello.accounting.business.ibusiness.ICreditPaymentBusiness;
import ipact.manazello.accounting.model.CreditPayment;
import ipact.manazello.accounting.repository.CreditPaymentRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditPaymentBusinessImpl implements ICreditPaymentBusiness {

    private final CreditPaymentRepository cpr;

    public CreditPaymentBusinessImpl(CreditPaymentRepository cpr) {
        this.cpr = cpr;
    }

    @Override
    public List<CreditPayment> findByCredit(String id) {
        return cpr.findAllByCredit_Id(new ObjectId(id));
    }
}
