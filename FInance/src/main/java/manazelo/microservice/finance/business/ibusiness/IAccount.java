package manazelo.microservice.finance.business.ibusiness;

import manazelo.microservice.finance.entities.Account;
import org.springframework.stereotype.Service;

@Service
public interface IAccount {
    Account addAccount (Account ba);
    Account updateAccount (Account a);
    Account updateBankAccountBalance (float amount);
    Account updateGlobalAccountBalance (float amount);
    float getGlobalAccountBalance ();
    float getBankAccountBalance();

}
