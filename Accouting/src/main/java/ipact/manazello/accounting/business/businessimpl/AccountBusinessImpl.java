package ipact.manazello.accounting.business.businessimpl;

import ipact.manazello.accounting.business.ibusiness.IAccountBusiness;
import ipact.manazello.accounting.model.Account;
import ipact.manazello.accounting.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.Instant;

import java.util.List;


@Service
public class AccountBusinessImpl implements IAccountBusiness {


    private final AccountRepository accountRepository;

    @Autowired
    public AccountBusinessImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account addaccount(Account account) {
        Instant instanceNow = Instant.now();
        account.setCreatedAt(instanceNow);
        account.setModifiedAt(instanceNow);
        return  accountRepository.save(account);
    }

    @Override
    public List<Account> getAllaccount() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getByName(String name) {
        return accountRepository.findByName(name);
    }

    @Override
    public Account getaccountByID(String id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account updateBalance(Account account, float balance) {
        float oldBalance = account.getBalance();
        account.setBalance(oldBalance + balance);
        return accountRepository.save(account);
    }

}
