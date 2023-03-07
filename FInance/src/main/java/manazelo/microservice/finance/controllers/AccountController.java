package manazelo.microservice.finance.controllers;

import manazelo.microservice.finance.business.businessimpl.AccountImpl;
import manazelo.microservice.finance.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@Controller
public class AccountController {
    private final AccountImpl ts;
    private final RestTemplate restTemplate;

   @Autowired
    public AccountController(AccountImpl ts, RestTemplateBuilder builder) {
        this.ts = ts;
        this.restTemplate = builder.build();
    }
    @PostMapping("/account/createAccount")
    @ResponseBody
    public ResponseEntity<Account> createAccount(@RequestBody Account ba) {
        Account account = ts.addAccount(ba);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
    @PutMapping("/account/updateBankAccountBalance")
    @ResponseBody
    public ResponseEntity<Account> updateBankAccountBalance(@RequestParam float amount) {
        Account account = ts.updateBankAccountBalance(amount);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }
    @PutMapping("/account/updateAccount")
    @ResponseBody
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        Account upAccount = ts.updateAccount(account);
        return new ResponseEntity<>(upAccount,HttpStatus.OK);
    }
    @PutMapping("/account/updateGlobalAccountBalance")
    @ResponseBody
    public ResponseEntity<Account> updateGlobalAccountBalance(@RequestParam float amount) {
        Account account = ts.updateGlobalAccountBalance(amount);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }


    @GetMapping("/account/retrieveExternalAccounts")
    @ResponseBody
    public ResponseEntity<Object[]> getExternalAccounts() {
        Object[] accounts = restTemplate.getForObject
                ("https://accounting-erp.herokuapp.com/account/accounts", Object[].class);


        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @GetMapping("/account/retrieveGlobalAccountBalance")
    @ResponseBody
    public ResponseEntity<String> getGlobalAccountBalance() {
        float balance =ts.getGlobalAccountBalance();


        return new ResponseEntity<>(Float.toString(balance), HttpStatus.OK);
    }
    @GetMapping("/account/retrieveBankAccountBalance")
    @ResponseBody
    public ResponseEntity<String> getBankAccountBalance() {
        float balance =ts.getBankAccountBalance();


        return new ResponseEntity<>(Float.toString(balance), HttpStatus.OK);
    }
}
