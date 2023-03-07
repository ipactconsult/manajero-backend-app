package manazelo.microservice.finance.business.ibusiness;
import manazelo.microservice.finance.entities.Account;
import manazelo.microservice.finance.entities.MonthlyBalanceChart;
import manazelo.microservice.finance.entities.Transaction;
import manazelo.microservice.finance.entities.TransactionResponse;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface ITransaction {
    Transaction addTransaction (Transaction t);
    Transaction updateTransaction(Transaction t);
    List<Transaction> retrieveAllTransactions();
    Optional<Transaction> retrieveTransaction (String id);
    List<Transaction> retrieveTransactionByDate(Date date);
    List<Transaction> retrieveTransactionByType(String type);
    List <Transaction> retrieveTransactionByMonth(int month,int year);
    List <Transaction> retrieveTransactionByYear(int year);
    List <TransactionResponse> retrieveTransactionByMonthAndYear( int year,int month) throws JSONException;
    void deleteTransaction (String id);
    List<MonthlyBalanceChart> retrieveMbcByMonthAndYear (int month, int year);
    Transaction reconcile (String id);
    List<Transaction> retrieveTransactionsByDateRange(Date minDate, Date maxDate) throws Exception;
    List<TransactionResponse> retrieveOperatingTransactions(int year);




}
