package ipact.manazello.accounting.business.ibusiness;

import ipact.manazello.accounting.model.CreditPayment;

import java.util.List;

public interface ICreditPaymentBusiness {
    List<CreditPayment> findByCredit(String id);
}
