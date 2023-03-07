package manazelo.microservice.finance.business.businessimpl;

import manazelo.microservice.finance.business.ibusiness.IAccount;
import manazelo.microservice.finance.entities.Account;
import manazelo.microservice.finance.repositories.AccountRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountImpl implements IAccount {

    private final AccountRep bar;

    @Autowired
    public AccountImpl(AccountRep bar) {
        this.bar = bar;
    }

    @Override
    public Account addAccount(Account ba) {
        Date date = new Date();

        ba.setCreatedAt(date);
        return bar.save(ba);
    }

    @Override
    public Account updateAccount(Account a) {
        Date date = new Date();

        a.setUpdatedAt(date);
        return bar.save(a);
    }

    @Override
    public Account updateBankAccountBalance(float amount) {
        Account account = bar.findBankAccountByCode("ba1000");
        account.setBalance(account.getBalance()+amount);
        return account;
    }

    @Override
    public Account updateGlobalAccountBalance(float amount) {
        Account account = bar.findBankAccountByCode("ga1000");
        account.setBalance(account.getBalance()+amount);
        return account;
    }

    @Override
    public float getGlobalAccountBalance() {
        Account account = bar.findBankAccountByCode("ga1000");


        return account.getBalance();
    }

    @Override
    public float getBankAccountBalance() {
        Account account = bar.findBankAccountByCode("ba1000");

        return account.getBalance();
    }


}
