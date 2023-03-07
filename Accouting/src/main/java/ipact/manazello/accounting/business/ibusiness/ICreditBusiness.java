package ipact.manazello.accounting.business.ibusiness;

import ipact.manazello.accounting.model.Credit;

import java.util.List;

public interface ICreditBusiness {
    Credit addCredit(Credit credit);
    List<Credit> getAllCredit();
    Credit getCreditById(String id);
    Credit updateCredit(Credit credit);
    Credit archive(String id);;
}
