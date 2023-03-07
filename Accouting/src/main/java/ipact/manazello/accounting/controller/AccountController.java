package ipact.manazello.accounting.controller;


import ipact.manazello.accounting.business.ibusiness.IAccountBusiness;
import ipact.manazello.accounting.model.Account;


import ipact.manazello.accounting.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountRepository accountRepository;
    private final IAccountBusiness iAccountBusiness;


    @Autowired
    public AccountController(AccountRepository accountRepository, IAccountBusiness iAccountBusiness){
        this.accountRepository = accountRepository;

        this.iAccountBusiness = iAccountBusiness;
    }
    @PostMapping(value = "/add")
    public Account createAccount(@RequestBody Account account) {
        return iAccountBusiness.addaccount(account);
    }
    @GetMapping("/getallaccountsbyname/{name}")
    public ResponseEntity<List<Account>> getAccountbyName(@PathVariable String name) {
        try {
            List<Account> account = accountRepository.findByName(name);

            if (account.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(account, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccount() {
        try {
            List<Account> account = iAccountBusiness.getAllaccount();

            if (account.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(account, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("id") String id) {
        try {
            accountRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
