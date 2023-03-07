package ipact.manazello.accounting.business.ibusiness;


import ipact.manazello.accounting.model.Account;


import java.util.List;

public interface IAccountBusiness {
    Account addaccount (Account account);
    List<Account> getAllaccount ();
    List<Account> getByName(String name);
    Account getaccountByID(String id);
    Account updateBalance(Account account, float balance);
}
