package manazelo.microservice.finance.controllers;

import manazelo.microservice.finance.business.businessimpl.TransactionImpl;
import manazelo.microservice.finance.entities.MonthlyBalanceChart;
import manazelo.microservice.finance.entities.Transaction;
import manazelo.microservice.finance.entities.TransactionResponse;

import manazelo.microservice.finance.repositories.TransactionRep;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class TransactionController {

    private final TransactionImpl ts;
    private final TransactionRep tr;
    @Autowired
    public TransactionController(TransactionImpl ts, TransactionRep tr) {
        this.ts = ts;
        this.tr = tr;
    }


    @PostMapping("/transaction/createTransaction")
    @ResponseBody
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction instance = ts.addTransaction(transaction);
        return new ResponseEntity<>(instance, HttpStatus.CREATED);
    }
    @PutMapping("/transaction/updateTransaction")
    @ResponseBody
    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction) {
        Transaction updatedTransaction = ts.updateTransaction(transaction);
        return new ResponseEntity<>(updatedTransaction,HttpStatus.OK);
    }
    @DeleteMapping("/transaction/removeTransaction/{id}")
    @ResponseBody
    public ResponseEntity<String> removeTransaction(@PathVariable("id") String id) {
        ts.deleteTransaction(id);
        return new ResponseEntity<>("transaction deleted",HttpStatus.OK);
    }
    @GetMapping("/transaction/retrieveAllTransactions")
    @ResponseBody
    public ResponseEntity<List<Transaction>> getTransactions() {
        List<Transaction> list = ts.retrieveAllTransactions();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/transaction/retrieve-transactionById/{id}")
    @ResponseBody
    public ResponseEntity<Optional<Transaction>> retrieveTransaction(@PathVariable("id") String id) {
        Optional<Transaction> t =ts.retrieveTransaction(id);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //convert the date Note that the conversion here should always be in the same format as the string passed in, e.g. 2015-9-9 should be yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor is a custom date editor
    }


    @GetMapping("/transaction/retrieve-transactionByDate/{date}")
    @ResponseBody
    public ResponseEntity<List<Transaction>> retrieveByDate(@PathVariable("date")   Date date) {
        List<Transaction> t =ts.retrieveTransactionByDate(date);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }



    @GetMapping("/transaction/retrieve-transactionByType/{type}")
    @ResponseBody
    public ResponseEntity<List<Transaction>> retrieveByType(@PathVariable("type") String type) {
        List<Transaction> t =ts.retrieveTransactionByType(type);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @GetMapping("/transaction/retrieve-transactionByMonth/{month}/{year}")
    @ResponseBody
    public ResponseEntity<List<Transaction>> retrieveByMonth(@PathVariable("month") int month, @PathVariable ("year") int year) {
        List<Transaction> t =ts.retrieveTransactionByMonth(month,year);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @GetMapping("/transaction/retrieve-transactionByYear/{year}")
    @ResponseBody
    public ResponseEntity<List<Transaction>> retrieveByYear(@PathVariable("year") int year) {
        List<Transaction> t =ts.retrieveTransactionByYear(year);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @GetMapping("transaction/global/{year}/{month}")
    @ResponseBody
    public ResponseEntity<List<TransactionResponse>> retrievetByYearAndMonth(@PathVariable("year") int year,@PathVariable("month") int month) throws JSONException {
        List<TransactionResponse> t =ts.retrieveTransactionByMonthAndYear(year,month);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @GetMapping("transaction/FilteredMbc/{month}/{year}")
    @ResponseBody
    public ResponseEntity<List<MonthlyBalanceChart>> retrieveByYearAndMonth(@PathVariable("month") int month,@PathVariable("year") int year) throws JSONException {
        List<MonthlyBalanceChart> t =ts.retrieveMbcByMonthAndYear(month,year);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

//reconciliation
@PutMapping("/transaction/reconcileTransaction/{id}")
@ResponseBody
public ResponseEntity<Transaction> reconcileTransaction(@PathVariable String id) {
    Transaction reconciledTransaction = ts.reconcile(id);
    return new ResponseEntity<>(reconciledTransaction,HttpStatus.OK);
}

    @GetMapping("transaction/reconciledTransactions")
    @ResponseBody
    public ResponseEntity<List<Transaction>> findReconciledTransactions(){
        List<Transaction> t =tr.findReconciledTransactions();
        return new ResponseEntity<>(t, HttpStatus.OK);
    }
    @GetMapping("transaction/nonReconciledTransactions")
    @ResponseBody
    public ResponseEntity<List<Transaction>> findNonReconciledTransactions(){
        List<Transaction> t =tr.findNonReconciledTransactions();
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @GetMapping("transaction/transactionsByDateRange/{minDate}/{maxDate}")
    @ResponseBody
    public ResponseEntity<List<Transaction>> findTransactionsByDateRange(@PathVariable Date minDate, @PathVariable Date maxDate) throws Exception {
        List<Transaction> t =ts.retrieveTransactionsByDateRange(minDate,maxDate);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }


    @GetMapping("transaction/operatingTransactions/{year}")
    @ResponseBody
    public ResponseEntity<List<TransactionResponse>> findOperatingTransactions(@PathVariable int year) {
        List<TransactionResponse> t = ts.retrieveOperatingTransactions(year);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

}
