package manazelo.microservice.finance.business.businessimpl;

import manazelo.microservice.finance.business.ibusiness.ITransaction;
import manazelo.microservice.finance.entities.Account;
import manazelo.microservice.finance.entities.MonthlyBalanceChart;
import manazelo.microservice.finance.entities.Transaction;
import manazelo.microservice.finance.entities.TransactionResponse;
import manazelo.microservice.finance.repositories.AccountRep;
import manazelo.microservice.finance.repositories.MonthlyBalanceRep;
import manazelo.microservice.finance.repositories.TransactionRep;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


@Service
public class TransactionImpl implements ITransaction {



    private final TransactionRep transactionRep;
    private final MonthlyBalanceRep mbr;
    private final AccountRep ar;

    @Autowired
    public TransactionImpl(@Qualifier("transactions") TransactionRep transactionRep, MonthlyBalanceRep mbr, AccountRep ar) {
        this.transactionRep = transactionRep;
        this.mbr = mbr;
        this.ar = ar;
    }


    public Transaction addTransaction (Transaction t ) {
        t.setBalance(t.getIncome()-t.getExpense());
        if (t.getBalance()>0) {
            t.setSortOrder(1);
        }
        else if (t.getBalance()<0) {
            t.setSortOrder(3);
        }
         t.setYear(t.getDate().getYear()+1900);
         t.setMonth(t.getDate().getMonth()+1);
         int year =t.getDate().getYear()+1900;
         int month=t.getDate().getMonth()+1;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(t.getDate());
         int day= calendar.get(Calendar.DAY_OF_MONTH);
        t.setStringDate(""+year+"-"+""+month+"-"+""+day);

        Date date = new Date();
         t.setAddedAt(date);

         Account account = ar.findBankAccountByCode("ga1000");
         account.setBalance(account.getBalance()+t.getBalance());
         ar.save(account);
        float balance=0;



        Transaction createdT= transactionRep.save(t);
        List<Transaction> filteredtransactions = transactionRep.findTransactionByDate(t.getDate());
        for ( Transaction transaction :filteredtransactions) {
            balance= balance +transaction.getBalance();
        }
        MonthlyBalanceChart query = mbr.findMbcByDate(t.getDate());
        if ( query==null) {
            MonthlyBalanceChart mbc = new MonthlyBalanceChart();

            mbc.setBalance(balance);
            mbc.setDate(t.getDate());
            mbc.setMonth(t.getMonth());
            mbc.setYear(t.getYear());

            mbr.save(mbc);


        }
        else {
            query.setBalance(balance);
            mbr.save(query);

        }

        return createdT;
    }


    public Transaction updateTransaction(Transaction t) {
        Optional<Transaction> optr = transactionRep.findById(t.getId());
        t.setBalance(t.getIncome()-t.getExpense());
        t.setYear(t.getDate().getYear()+1900);
        Date date = new Date();
        t.setUpdatedAt(date);
         float balance =0;
         float nonBalance=0;

        Transaction upt =transactionRep.save(t);
        Account account = ar.findBankAccountByCode("ga1000");
        List<Transaction> list= transactionRep.findAll();
        for ( Transaction transaction :list) {
            nonBalance = nonBalance + transaction.getBalance();
        }
        account.setBalance(nonBalance);
        ar.save(account);
        if(upt.getReconciled()==Boolean.TRUE) {
            upt.setReconciled(Boolean.FALSE);
            Account account2 = ar.findBankAccountByCode("ba1000");
            List<Transaction> list2= transactionRep.findReconciledTransactions();
            for ( Transaction transaction :list2) {
                balance = balance + transaction.getBalance();
            }
            account2.setBalance(balance);
            ar.save(account2);




        }
        MonthlyBalanceChart query =null;

        try {
            List<Transaction> filteredtransactions = transactionRep.findTransactionByDate(t.getDate());
            for ( Transaction transaction :filteredtransactions) {
                balance= balance +transaction.getBalance();
            }
            query = mbr.findMbcByDate(t.getDate());
            query.setBalance(balance);

            mbr.save(query);

        }
        catch(Exception e) {
            MonthlyBalanceChart instance = new MonthlyBalanceChart("id",balance,t.getDate(),t.getYear(),t.getMonth());
            mbr.save(instance);
            List<Transaction> ft = transactionRep.findAll();
            List<MonthlyBalanceChart> mbcs = mbr.findAll();
            List<Date> dates = new ArrayList<>();

            for ( Transaction fts : ft) {
                dates.add(fts.getDate());
            }

            for ( MonthlyBalanceChart mbc : mbcs) {
                if (!dates.contains(mbc.getDate())) {
                    mbr.delete(mbc);
                }
            }
        }









        return (optr.isPresent() ?
                upt
                : null);

    }


    public List<Transaction> retrieveAllTransactions() {
        return transactionRep.findAll();
    }




    public Optional<Transaction> retrieveTransaction(String id) {
        return transactionRep.findById(id);
    }


    public List<Transaction> retrieveTransactionByDate(Date date) {
        return transactionRep.findTransactionByDate(date);
    }





    public List<Transaction> retrieveTransactionByType(String type) {

        return transactionRep.findTransactionByType(type);
    }

    @Override
    public List<Transaction> retrieveTransactionByMonth(int month, int year) {
        return transactionRep.findTransactionByMonth(month,year);

    }

    @Override
    public List<Transaction> retrieveTransactionByYear(int year) {
        return transactionRep.findTransactionByYear(year);
    }



    @Override
    public List<TransactionResponse> retrieveTransactionByMonthAndYear( int year,int month) throws JSONException {
        List <TransactionResponse> list = transactionRep
                .findTransactionByMonthAndYear(year,month);

        AtomicReference<Float> allExpense= new AtomicReference<>((float) 0);
        AtomicReference<Float> allIncome= new AtomicReference<>((float) 0);
        AtomicReference<Float> allBalance = new AtomicReference<>((float) 0);
        AtomicReference<Float> avgExpense = new AtomicReference<>((float) 0);
        AtomicReference<Float> avgIncome = new AtomicReference<>((float) 0);
        AtomicReference<Float> avgBalance = new AtomicReference<>((float) 0);
        List <TransactionResponse> list2 =new ArrayList<>();
        List<String> months = new ArrayList<>();
        for (int i=1;i<13;i++) {

            months.add(Integer.toString(i));
        }

      final String moonth="month";

        list.forEach(ele -> {
           try {
               JSONObject jsonObject = new JSONObject(ele.getId());
               if (String.valueOf(jsonObject.get("year")).equals(String.valueOf(year))) {
                   list2.add(ele);
                   ele.setId(String.valueOf(jsonObject.get(moonth)));

                   allExpense.set(allExpense.get() + ele.getTotalexpense());
                   allIncome.set(allIncome.get() + ele.getTotalincome());
                   allBalance.set(allBalance.get() + ele.getTotalbalance());


                   if (months.contains(String.valueOf(jsonObject.get(moonth))))  {
                       months.remove(String.valueOf(jsonObject.get(moonth)));




                   }
                   else {return ;  }

                   if (list2.isEmpty()) {
                       avgExpense.set((float) 0);
                       avgIncome.set((float) 0);
                       avgBalance.set((float) 0);

                   }
                   else {
                       avgExpense.set(allExpense.get()/list2.size());
                       avgIncome.set(allIncome.get()/list2.size());
                       avgBalance.set(allBalance.get()/list2.size());
                   }
               }

           } catch (JSONException e) {
             e.printStackTrace();
           }
       });

        for (Object o : months) {
            TransactionResponse empty = new TransactionResponse(o.toString(), 0, 0, 0);
            list2.add(empty);

        }

        TransactionResponse t = new TransactionResponse("Total", Float.parseFloat(String.valueOf(allExpense)),Float.parseFloat(String.valueOf(allIncome)),Float.parseFloat(String.valueOf(allBalance)));
        TransactionResponse avg = new TransactionResponse("Averages",Float.parseFloat(String.valueOf(avgExpense)),Float.parseFloat(String.valueOf(avgIncome)),Float.parseFloat(String.valueOf(avgBalance) ));
        list2.add(t);
        list2.add(avg);


        return list2;

    }


    public void deleteTransaction(String id) {
        Transaction deletedTransaction = transactionRep.findById(id).orElse(null);
        assert deletedTransaction != null;

        List<Transaction> filteredtransactions = transactionRep.findTransactionByDate(deletedTransaction.getDate());
        float balance =0;
        MonthlyBalanceChart query = mbr.findMbcByDate(deletedTransaction.getDate());
        Account account = ar.findBankAccountByCode("ga1000");
        account.setBalance(account.getBalance()-deletedTransaction.getBalance());
        ar.save(account);
        if (deletedTransaction.getReconciled()== Boolean.TRUE)
        {
        Account account2 = ar.findBankAccountByCode("ba1000");
        account2.setBalance(account2.getBalance()-deletedTransaction.getBalance());
        ar.save(account);}


        if(filteredtransactions.size()==1) {
            mbr.delete(query);

        }
        else {

        for ( Transaction transaction :filteredtransactions) {
            balance= balance +transaction.getBalance();

        }
        query.setBalance(balance-deletedTransaction.getBalance());}



        transactionRep.deleteById(id);





    }

    @Override
    public List<MonthlyBalanceChart> retrieveMbcByMonthAndYear(int month, int year) {
        return mbr.findMbcByMonthAndYear(month,year);
    }

    @Override
    public Transaction reconcile(String id) {
        Transaction t = transactionRep.findById(id).orElse(null);
        assert t != null;

        t.setReconciled(Boolean.TRUE);
        Account account = ar.findBankAccountByCode("ba1000");
        account.setBalance(account.getBalance()+t.getBalance());
        ar.save(account);
        return transactionRep.save(t);

    }

    @Override
    public List<Transaction> retrieveTransactionsByDateRange(Date minDate, Date maxDate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = dateFormat.format(minDate);
        String date2 = dateFormat.format(maxDate);

        if ( !(sdf.parse(date2).compareTo(sdf.parse(date1)) >0)  ) {
            throw new Exception("Maximum date should be superior to minimum date");
        }

        List<Transaction> allTransactions = transactionRep.findAll();
        List <Transaction> filteredList = allTransactions.stream().filter(t-> {
            try {
                return sdf.parse(dateFormat.format(t.getDate())).compareTo(sdf.parse(date1))>0 && sdf.parse(dateFormat.format(t.getDate())).compareTo(sdf.parse(date2))<0;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return false;
        }).collect(Collectors.toList());
        Transaction inc=null;
        Transaction ex=null;
        float totalIncome=0;
        float totalExpense=0;
        List<Transaction> transactionsFrag= new ArrayList<>();
        List<Transaction> transactionsFound= new ArrayList<>();
        for( Transaction transaction : filteredList){
                totalIncome=totalIncome+transaction.getIncome();
                totalExpense =totalExpense+transaction.getExpense();

             if(transaction.getIncome()!=0 && transaction.getExpense()!=0) {
                 inc = new Transaction(0, transaction.getIncome(),transaction.getIncome(), transaction.getDetails(), transaction.getDate(), transaction.getType(), transaction.getAccount(),1);
                ex = new Transaction(transaction.getExpense(), 0,-transaction.getExpense(), transaction.getDetails(), transaction.getDate(), transaction.getType(), transaction.getAccount(),3);
                 transactionsFrag.add(inc);
                 transactionsFrag.add(ex);

                 transactionsFound.add(transaction);
            }
        }
        Transaction totalIn = new Transaction(0,totalIncome,totalIncome,"Total Revenue",maxDate,"Total Revenue","Not Classified",2);
        Transaction totalEx = new Transaction(totalExpense,0,-totalExpense,"Total Expense",maxDate,"Total Expense","Not Classified",4);
        Transaction netInc = new Transaction(0,totalIncome-totalExpense,totalIncome-totalExpense,"Net Income",maxDate,"Net Income","Not Classified",5);

        filteredList.add(totalIn);
        filteredList.add(totalEx);
        filteredList.add(netInc);
        filteredList.addAll(transactionsFrag);

        for (Transaction tr :transactionsFound) {
            filteredList.remove(tr);
        }



        return filteredList;

    }

    @Override
    public List<TransactionResponse> retrieveOperatingTransactions(int year) {
        List<TransactionResponse> list = transactionRep.findOperatingTransactions();

        List<TransactionResponse> finalList =list.stream().filter(t->String.valueOf(new JSONObject(t.getId()).get("type")).equals("Operating")&& String.valueOf(new JSONObject(t.getId()).get("year")).equals(String.valueOf(year))).collect(Collectors.toList());
        for (TransactionResponse t:finalList) {
            t.setId(String.valueOf((new JSONObject(t.getId()).get("month"))));

        }
        return finalList;
    }


}
