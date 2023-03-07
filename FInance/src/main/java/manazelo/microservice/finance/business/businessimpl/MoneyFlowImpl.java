package manazelo.microservice.finance.business.businessimpl;

import manazelo.microservice.finance.business.ibusiness.IMoneyFlow;
import manazelo.microservice.finance.entities.MoneyFlow;
import manazelo.microservice.finance.entities.TransactionResponse;
import manazelo.microservice.finance.repositories.MoneyFlowRep;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MoneyFlowImpl implements IMoneyFlow {
    private final MoneyFlowRep mfr;
    private final TransactionImpl ti;

    public MoneyFlowImpl(MoneyFlowRep mfr, TransactionImpl ti) {
        this.mfr = mfr;
        this.ti = ti;
    }



    public void calculYearlyForExpense (MoneyFlow toCreate) {
        float actual=0;
        float budget=0;
        float difference=0;

        float actualNo =0;
        float budgetNo =0;
        float differenceNo=0;



        float testActual;
        float testBudget;
        float testDifference;

        List<MoneyFlow> list = mfr.findMoneyFlowByDirectionAndYear(toCreate.getDirection(),toCreate.getYear());
        for (MoneyFlow moneyFlow:list) {
            if ( !Arrays.asList("Total","Tax").contains(moneyFlow.getCategory())) {
                actual= actual + moneyFlow.getActual();
                budget =budget+ moneyFlow.getBudget();
                difference = difference + moneyFlow.getDifference();
            }

        }
        MoneyFlow newYearlyTotal = new MoneyFlow("All "+toCreate.getDirection()+"void"+toCreate.getYear(),"Total", actual, budget, difference, toCreate.getDirection(),"Total "+toCreate.getDirection(),toCreate.getYear(),5,"void","Yearly");
        mfr.save(newYearlyTotal);
        MoneyFlow noTaxyearly = mfr.findMoneyFlowByIdAndYear("netIncomeNoTaxvoid"+toCreate.getYear(), toCreate.getYear(), "void","Yearly");

        List<MoneyFlow> list2= mfr.findMoneyFlowByCategoryAndYearAndType("Net Income Before Tax", toCreate.getYear(), "Monthly");
        if (list2.size()==0)

        { MoneyFlow oke = new MoneyFlow("netIncomeNoTaxvoid"+toCreate.getYear(),"Net Income Before Tax", -toCreate.getActual(), -toCreate.getBudget(), -toCreate.getDifference(), "Income","Net Income Before Tax", toCreate.getYear(),7,"void","Yearly");
            mfr.save(oke);
            testActual=oke.getActual();
            testBudget= oke.getBudget();
            testDifference= oke.getDifference();
        }
        else {
            for(MoneyFlow moneyFlow:list2)
            {
                actualNo= actualNo + moneyFlow.getActual();
                budgetNo = budgetNo+ moneyFlow.getBudget();
                differenceNo = differenceNo+moneyFlow.getDifference();
            }

            if(noTaxyearly!=null)
            {
                MoneyFlow newYearlyNoTax = new MoneyFlow("netIncomeNoTaxvoid"+toCreate.getYear(),"Net Income Before Tax",noTaxyearly.getActual()- toCreate.getActual(),noTaxyearly.getBudget()- toCreate.getBudget(),noTaxyearly.getDifference()-toCreate.getDifference(),"Income","Net Income Before Tax", toCreate.getYear(),7,"void","Yearly");
                mfr.save(newYearlyNoTax);
                testActual=newYearlyNoTax.getActual();
                testBudget= newYearlyNoTax.getBudget();
                testDifference= newYearlyNoTax.getDifference();}
            else{
                MoneyFlow newYearlyNoTax = new MoneyFlow("netIncomeNoTaxvoid"+toCreate.getYear(),"Net Income Before Tax",actualNo,budgetNo,differenceNo,"Income","Net Income Before Tax", toCreate.getYear(),7,"void","Yearly");
                mfr.save(newYearlyNoTax);
                testActual=newYearlyNoTax.getActual();
                testBudget= newYearlyNoTax.getBudget();
                testDifference= newYearlyNoTax.getDifference();}}


        MoneyFlow findTax= new MoneyFlow();
        List<MoneyFlow> taxes = mfr.findMoneyFlowByCategoryAndYearAndMonthAndDirection("Tax",toCreate.getYear(),"void","Expense");
        if (!taxes.isEmpty())
        {
            for(MoneyFlow instance :taxes) {
                findTax.setActual(findTax.getActual()+ instance.getActual());
                findTax.setBudget(findTax.getBudget()+instance.getBudget());
                findTax.setDifference((findTax.getDifference()+instance.getDifference()));

            }}



            MoneyFlow newYearlyNet = new MoneyFlow("netIncomevoid"+toCreate.getYear(),"Net Income", testActual- findTax.getActual(), testBudget- findTax.getActual(), testDifference- findTax.getActual(), "Income","Net Income", toCreate.getYear(),8,"void","Yearly");
            mfr.save(newYearlyNet);




    }

     public void calculYearlyForIncome (MoneyFlow toCreate ) {

            float actual=0;
            float budget=0;
            float difference=0;

            float actualNo =0;
            float budgetNo =0;
            float differenceNo=0;




         List<MoneyFlow> list = mfr.findMoneyFlowByDirectionAndYear(toCreate.getDirection(),toCreate.getYear());
             for (MoneyFlow moneyFlow:list) {
                 if ( !Arrays.asList("Total", "Net "+toCreate.getDirection(), "Net Income Before Tax").contains(moneyFlow.getCategory())) {
                     actual= actual + moneyFlow.getActual();
                     budget =budget+ moneyFlow.getBudget();
                     difference = difference + moneyFlow.getDifference();
                 }

             }
                MoneyFlow newYearlyTotal = new MoneyFlow("All "+toCreate.getDirection()+"void"+toCreate.getYear(),"Total", actual, budget, difference, toCreate.getDirection(),"Total "+toCreate.getDirection(),toCreate.getYear(),5,"void","Yearly");
                mfr.save(newYearlyTotal);

                MoneyFlow noTaxyearly = mfr.findMoneyFlowByIdAndYear("netIncomeNoTaxvoid"+toCreate.getYear(), toCreate.getYear(), "void","Yearly");

                MoneyFlow newYearlyNoTax;
                List<MoneyFlow> list2= mfr.findMoneyFlowByCategoryAndYearAndType("Net Income Before Tax", toCreate.getYear(), "Monthly");
              /*+++*/ if (list2.size()==0) {
                         if(noTaxyearly!=null)
                         {newYearlyNoTax = new MoneyFlow("netIncomeNoTaxvoid"+toCreate.getYear(),"Net Income Before Tax", toCreate.getActual()+noTaxyearly.getActual(), toCreate.getBudget()+noTaxyearly.getBudget(), toCreate.getDifference()+noTaxyearly.getDifference(), "Income","Net Income Before Tax", toCreate.getYear(),7,"void","Yearly");
                             mfr.save(newYearlyNoTax) ;
                             }
                        else{
                             {newYearlyNoTax = new MoneyFlow("netIncomeNoTaxvoid"+toCreate.getYear(),"Net Income Before Tax", toCreate.getActual(), toCreate.getBudget(), toCreate.getDifference(), "Income","Net Income Before Tax", toCreate.getYear(),7,"void","Yearly");
                              mfr.save(newYearlyNoTax);
                      }

                  }}
                  else {
                for(MoneyFlow moneyFlow:list2) {
                       actualNo= actualNo + moneyFlow.getActual();
                       budgetNo = budgetNo+ moneyFlow.getBudget();
                       differenceNo = differenceNo+moneyFlow.getDifference();
                   }

                     if(noTaxyearly!=null)
                      {
                          newYearlyNoTax = new MoneyFlow("netIncomeNoTaxvoid"+toCreate.getYear(),"Net Income Before Tax",noTaxyearly.getActual()+ toCreate.getActual(),noTaxyearly.getBudget()+ toCreate.getBudget(),noTaxyearly.getDifference()+ toCreate.getDifference(),"Income","Net Income Before Tax", toCreate.getYear(),7,"void","Yearly");
                          mfr.save(newYearlyNoTax);
                        }
                      else{
                           newYearlyNoTax = new MoneyFlow("netIncomeNoTaxvoid"+toCreate.getYear(),"Net Income Before Tax",actualNo,budgetNo,differenceNo,"Income","Net Income Before Tax", toCreate.getYear(),7,"void","Yearly");
                          mfr.save(newYearlyNoTax);
                          }





                  }



                           Optional<MoneyFlow> optTax =mfr.findOneMoneyFlowByCategoryAndYearAndType("Tax", toCreate.getYear(), "Yearly");
                              MoneyFlow tax = optTax.orElseGet(() -> new MoneyFlow("" , "Net Income", 0, 0, 0, "Income", "Net Income",2022, 8, "", "ok"));

                          MoneyFlow newYearlyNet = new MoneyFlow("netIncomevoid"+toCreate.getYear(),"Net Income",newYearlyNoTax.getActual()-tax.getActual(), newYearlyNoTax.getBudget()-tax.getBudget(),newYearlyNoTax.getDifference()-tax.getDifference(),"Income","Net Income", toCreate.getYear(),8,"void","Yearly");
                          mfr.save(newYearlyNet);














     }

     public MoneyFlow calculTotalForIncome (MoneyFlow mf) {
         if ( mf.getCategory().equals("Operating")) {
             mf.setSortOrder(1);
         }
         else {
             mf.setSortOrder(3);
         }
         mf.setDifference(mf.getActual() - mf.getBudget());
         mf.setDirection("Income");
         MoneyFlow created =mfr.save(mf);

         float totalActual = 0;
         float totalBudget = 0;
         float totalDifference = 0;

         List<MoneyFlow> list =mfr.findMoneyFlowByDirectionAndYear(mf.getDirection(),mf.getYear());
         MoneyFlow totalExpense = mfr.findMoneyFlowByIdAndYear("All Expense" +mf.getMonth() +mf.getYear(), mf.getYear(),mf.getMonth(),mf.getType());
         MoneyFlow tax = new MoneyFlow();
         List<MoneyFlow> taxes = mfr.findMoneyFlowByCategoryAndYearAndMonthAndDirection("Tax",mf.getYear(),mf.getMonth(),"Expense");
         if (!taxes.isEmpty())
         {
         for(MoneyFlow instance :taxes) {
             tax.setActual(tax.getActual()+ instance.getActual());
             tax.setBudget(tax.getBudget()+instance.getBudget());
             tax.setDifference((tax.getDifference()+instance.getDifference()));

         }}


         if(mf.getType().equals("Monthly"))
         {
             for (MoneyFlow moneyFlow :list) {
                 if ( !Arrays.asList("Total", "Net "+mf.getDirection(), "Net Income Before Tax").contains(moneyFlow.getCategory()))
                 {   if(moneyFlow.getMonth().equals(mf.getMonth()))
                 {
                     totalActual = totalActual+moneyFlow.getActual();
                     totalBudget = totalBudget+moneyFlow.getBudget();
                     totalDifference= totalDifference+moneyFlow.getDifference();}}

             }}
         else

         {for (MoneyFlow moneyFlow :list) {
             if ( !Arrays.asList("Total", "Net "+mf.getDirection(), "Net Income Before Tax").contains(moneyFlow.getCategory()))
             {totalActual = totalActual+moneyFlow.getActual();
                 totalBudget = totalBudget+moneyFlow.getBudget();
                 totalDifference= totalDifference+moneyFlow.getDifference();}
         }}

         MoneyFlow totIn = new MoneyFlow("All " + mf.getDirection() +mf.getMonth()+ mf.getYear(), "Total", totalActual, totalBudget, totalDifference, mf.getDirection(), "Total " + mf.getDirection(), mf.getYear(),5,mf.getMonth(),mf.getType());
         mfr.save(totIn);



             if (totalExpense ==null) {
                 MoneyFlow noTaxInc = new MoneyFlow("netIncomeNoTax"+mf.getMonth()+mf.getYear(), "Net Income Before Tax", totIn.getActual() , totIn.getBudget() , totIn.getDifference() , "Income", "Net Income Before Tax", mf.getYear(),7,mf.getMonth(),mf.getType());
                 MoneyFlow netIncome = new MoneyFlow("netIncome" +mf.getMonth()+ mf.getYear(), "Net Income", noTaxInc.getActual()-tax.getActual() , noTaxInc.getBudget()-tax.getBudget() , noTaxInc.getDifference()- tax.getDifference() , "Income", "Net Income", mf.getYear(),8,mf.getMonth(),mf.getType());
                 mfr.save(noTaxInc);
                 mfr.save(netIncome);

             }
             else {
                 MoneyFlow noTaxInc = new MoneyFlow("netIncomeNoTax"+mf.getMonth()+mf.getYear(), "Net Income Before Tax", totIn.getActual() - totalExpense.getActual(), totIn.getBudget() - totalExpense.getBudget(), totIn.getDifference() - totalExpense.getDifference(), "Income", "Net Income Before Tax", mf.getYear(),7,mf.getMonth(),mf.getType());
                 MoneyFlow netIncome = new MoneyFlow("netIncome" +mf.getMonth()+ mf.getYear(), "Net Income", noTaxInc.getActual()-tax.getActual() , noTaxInc.getBudget()-tax.getBudget() , noTaxInc.getDifference()- tax.getDifference() , "Income", "Net Income", mf.getYear(),8,mf.getMonth(),mf.getType());
                 mfr.save(noTaxInc);
                 mfr.save(netIncome);

             }


         return created;

     }

     public MoneyFlow calculTotalsForExpense (MoneyFlow mf) {
         if ( mf.getCategory().equals("Operating")) {
             mf.setSortOrder(1);
         }
         else {
             mf.setSortOrder(3);
         }
         mf.setDirection("Expense");

         mf.setDifference(mf.getActual() - mf.getBudget());
         MoneyFlow created =mfr.save(mf);

         float totalActual = 0;
         float totalBudget = 0;
         float totalDifference = 0;
         MoneyFlow tax =new MoneyFlow();
         List<MoneyFlow> list =mfr.findMoneyFlowByDirectionAndYear(mf.getDirection(),mf.getYear());

         List<MoneyFlow> taxes = mfr.findMoneyFlowByCategoryAndYearAndMonthAndDirection("Tax",mf.getYear(),mf.getMonth(),"Expense");
         if (!taxes.isEmpty())
         {
             for(MoneyFlow instance :taxes) {
                 tax.setActual(tax.getActual()+ instance.getActual());
                 tax.setBudget(tax.getBudget()+instance.getBudget());
                 tax.setDifference((tax.getDifference()+instance.getDifference()));

             }}
         if(mf.getType().equals("Monthly"))
         {
             for (MoneyFlow moneyFlow :list) {
                 if ( !Arrays.asList("Total", "Net "+mf.getDirection(), "Net Income Before Tax","Tax").contains(moneyFlow.getCategory()))
                 {   if(moneyFlow.getMonth().equals(mf.getMonth()))
                 {
                     totalActual = totalActual+moneyFlow.getActual();
                     totalBudget = totalBudget+moneyFlow.getBudget();
                     totalDifference= totalDifference+moneyFlow.getDifference();}}

             }}
         else{
             for (MoneyFlow moneyFlow :list) {
                 if ( !Arrays.asList("Total", "Net "+mf.getDirection(), "Net Income Before Tax","Tax").contains(moneyFlow.getCategory()))
                 {totalActual = totalActual+moneyFlow.getActual();
                     totalBudget = totalBudget+moneyFlow.getBudget();
                     totalDifference= totalDifference+moneyFlow.getDifference();}
             }}
         MoneyFlow totEx = new MoneyFlow("All " + mf.getDirection() +mf.getMonth()+ mf.getYear(), "Total", totalActual, totalBudget, totalDifference, mf.getDirection(), "Total " + mf.getDirection(), mf.getYear(),5,mf.getMonth(),mf.getType());
         mfr.save(totEx);
         MoneyFlow totalIncome = mfr.findMoneyFlowByIdAndYear("All Income" +mf.getMonth() + mf.getYear(), mf.getYear(),mf.getMonth(),mf.getType());



             if (totalIncome ==null) {
                 MoneyFlow noTaxInc = new MoneyFlow("netIncomeNoTax"+mf.getMonth()+mf.getYear(), "Net Income Before Tax",  - totEx.getActual(), -totEx.getBudget(),  - totEx.getDifference(), "Income", "Net Income Before Tax", mf.getYear(),7,mf.getMonth(),mf.getType());
                 MoneyFlow netIncome = new MoneyFlow("netIncome" +mf.getMonth()+ mf.getYear(), "Net Income", noTaxInc.getActual()-tax.getActual() , noTaxInc.getBudget()-tax.getBudget() , noTaxInc.getDifference()- tax.getDifference() , "Income", "Net Income", mf.getYear(),8,mf.getMonth(),mf.getType());
                 mfr.save(noTaxInc);
                 mfr.save(netIncome);

             }
             else {
                 MoneyFlow noTaxInc = new MoneyFlow("netIncomeNoTax"+mf.getMonth()+mf.getYear(), "Net Income Before Tax", totalIncome.getActual() - totEx.getActual(), totalIncome.getBudget() - totEx.getBudget(), totalIncome.getDifference() - totEx.getDifference(), "Income", "Net Income Before Tax", mf.getYear(),7,mf.getMonth(),mf.getType());
                 MoneyFlow netIncome = new MoneyFlow("netIncome" +mf.getMonth()+ mf.getYear(), "Net Income", noTaxInc.getActual()-tax.getActual() , noTaxInc.getBudget()-tax.getBudget() , noTaxInc.getDifference()- tax.getDifference() , "Income", "Net Income", mf.getYear(),8,mf.getMonth(),mf.getType());
                 mfr.save(noTaxInc);
                 mfr.save(netIncome);

             }



         return created;

     }
    @Override
    public MoneyFlow createIncomeMoneyFlow(MoneyFlow mf) {
        MoneyFlow created = calculTotalForIncome(mf);


        if( mf.getType().equals("Monthly")) {
            calculYearlyForIncome(mf);
        }
        return created;
    }



    @Override
    public MoneyFlow createExpenseMoneyFlow(MoneyFlow mf) {

        MoneyFlow created = calculTotalsForExpense(mf);
        if( mf.getType().equals("Monthly")) {
            calculYearlyForExpense(mf);
        }
        return created;
    }






    public void updateYearly(MoneyFlow toCreate ) {

        float actual=0;
        float budget=0;
        float difference=0;

        float actualNo =0;
        float budgetNo =0;
        float differenceNo=0;

        float actualNet =0;
        float budgetNet =0;
        float differenceNet=0;


        List<MoneyFlow> list = mfr.findMoneyFlowByDirectionAndYear(toCreate.getDirection(),toCreate.getYear());
        for (MoneyFlow moneyFlow:list) {
            if ( !Arrays.asList("Total", "Net "+toCreate.getDirection(), "Net Income Before Tax","Tax").contains(moneyFlow.getCategory())) {
                actual= actual + moneyFlow.getActual();
                budget =budget+ moneyFlow.getBudget();
                difference = difference + moneyFlow.getDifference();
            }

        }
        MoneyFlow newYearlyTotal = new MoneyFlow("All "+toCreate.getDirection()+"void"+toCreate.getYear(),"Total", actual, budget, difference, toCreate.getDirection(),"Total "+toCreate.getDirection(),toCreate.getYear(),5,"void","Yearly");
        mfr.save(newYearlyTotal);

        MoneyFlow noTaxyearly = mfr.findMoneyFlowByIdAndYear("netIncomeNoTaxvoid"+toCreate.getYear(), toCreate.getYear(), "void","Yearly");
        MoneyFlow netYearly = mfr.findMoneyFlowByIdAndYear("netIncomevoid"+toCreate.getYear(),toCreate.getYear(), "void","Yearly");


        List<MoneyFlow> list2= mfr.findMoneyFlowByCategoryAndYearAndType("Net Income Before Tax", toCreate.getYear(), "Monthly");

               for( MoneyFlow instance :list2) {
                   actualNo = actualNo+ instance.getActual();
                   budgetNo =budgetNo + instance.getBudget();
                   differenceNo= differenceNo+ instance.getDifference();
               }
               noTaxyearly.setActual(actualNo);
               noTaxyearly.setBudget(budgetNo);
               noTaxyearly.setDifference(differenceNo);
               mfr.save(noTaxyearly);






        List<MoneyFlow> list3= mfr.findMoneyFlowByCategoryAndYearAndType("Net Income", toCreate.getYear(), "Monthly");
        for( MoneyFlow instance :list3) {
            actualNet = actualNet+ instance.getActual();
            budgetNet =budgetNet + instance.getBudget();
            differenceNet= differenceNet+ instance.getDifference();
        }
        netYearly.setActual(actualNet);
        netYearly.setBudget(budgetNet);
        netYearly.setDifference(differenceNet);
        mfr.save(netYearly);













    }

    @Override
    public MoneyFlow updateIncomeMoneyFlow(MoneyFlow mf) {
        MoneyFlow updated = calculTotalForIncome(mf);
        if (mf.getType().equals("Monthly")) {
            updateYearly(mf);
        }
        return updated;
    }

    @Override
    public MoneyFlow updateExpenseMoneyFlow(MoneyFlow mf) {
        MoneyFlow updated = calculTotalsForExpense(mf);
        if (mf.getType().equals("Monthly")) {
            updateYearly(mf);
        }
        return updated;    }

    @Override
    public MoneyFlow getBudgetRiskInfos(int year) {
        float balance=0;
        MoneyFlow totalIncome= mfr.findMoneyFlowByIdAndYear("All Incomevoid"+year,year,"void","Yearly");
        MoneyFlow totalExpense= mfr.findMoneyFlowByIdAndYear("All Expensevoid"+year,year,"void","Yearly");
        List<TransactionResponse> list = ti.retrieveTransactionByMonthAndYear(year,0);

        for (TransactionResponse tr :list) {
           if (tr.getId().equals("Total")) {
               balance=tr.getTotalbalance();

           }
        }

        return new MoneyFlow("",balance,totalExpense.getBudget()+totalIncome.getBudget(),balance -totalExpense.getBudget()-totalIncome.getBudget(),"","",year,0,"" ,"");
    }


    @Override
    public List<MoneyFlow> retrieveAllMoneyFlow(String direction, int year, String month, String type ) {
        List<MoneyFlow> list = mfr.findMoneyFlowByDirectionAndYearAndMonthAndType(direction, year,month,type);
        float totalOpActual = 0;
        float totalOpBudget = 0;
        float totalOpDifference = 0;

        float totalNopActual = 0;
        float totalNopBudget = 0;
        float totalNopDifference = 0;
        if ("Yearly".equals(type))
        {
            List<MoneyFlow> monthly= mfr.findMoneyFlowByDirectionAndYearAndType(direction,year,"Monthly");
            for (MoneyFlow moneyFlow:monthly) {
                if (!Arrays.asList("Total Expense", "Total Income", "Income Tax Expense","Net Income","Net Income Before Tax").contains(moneyFlow.getSubCategory()) && !moneyFlow.getCategory().equals("Tax"))
                     list.add(moneyFlow);
            }
        }

        for (MoneyFlow moneyFlow : list) {

            if (moneyFlow.getCategory().equals("Operating")) {
                totalOpActual = totalOpActual + moneyFlow.getActual();
                totalOpBudget = totalOpBudget + moneyFlow.getBudget();
                totalOpDifference = totalOpDifference + moneyFlow.getDifference();
            }
            if (moneyFlow.getCategory().equals("Non Operating")) {
                totalNopActual = totalNopActual + moneyFlow.getActual();
                totalNopBudget = totalNopBudget + moneyFlow.getBudget();
                totalNopDifference = totalNopDifference + moneyFlow.getDifference();
            }


        }

        MoneyFlow totalOp = new MoneyFlow("Total Op " + direction, "Total", totalOpActual, totalOpBudget, totalOpDifference, direction, "Total Operating " + direction, year,2,month,type);
        list.add(totalOp);
        MoneyFlow totalNop = new MoneyFlow("Total Nop " + direction, "Total", totalNopActual, totalNopBudget, totalNopDifference, direction, "Total Non Operating " + direction, year,4,month,type);
        list.add(totalNop);





        return list;

}

    @Override
    public MoneyFlow updateOrCreateTax(MoneyFlow mf) {
        mf.setDifference(mf.getActual()-mf.getBudget());
        mf.setSortOrder(6);
        mf.setDirection("Expense");

        MoneyFlow tax =mfr.save(mf);
        float taxActual =0;
        float taxBudget =0;
        float taxDifference=0;
        float taxYearlyActual =0;
        float taxYearlyBudget=0;
        float taxYearlyDifference=0;


        MoneyFlow noTax;
        Optional<MoneyFlow> opTnoTax =mfr.findById("netIncomeNoTax"+mf.getMonth()+mf.getYear());
        noTax = opTnoTax.orElseGet(() -> new MoneyFlow("", "", 0, 0, 0, "", "", 0, 0, "", ""));
        MoneyFlow net;
        Optional<MoneyFlow> opTnet =mfr.findById("netIncome"+mf.getMonth()+mf.getYear());
        net = opTnet.orElseGet(() -> new MoneyFlow("netIncome"+mf.getMonth()+mf.getYear() , "Net Income", 0, 0, 0, "Income", "Net Income", mf.getYear(), 8, mf.getMonth(), mf.getType()));
        List<MoneyFlow> taxes = mfr.findMoneyFlowByCategoryAndYearAndMonthAndDirection("Tax",mf.getYear(),mf.getMonth(),"Expense");
        if (!taxes.isEmpty())
        {
            for(MoneyFlow instance :taxes) {
                taxActual = taxActual +instance.getActual();
                taxBudget =taxBudget +instance.getBudget();
                taxDifference = taxDifference +instance.getDifference();




            }}
        net.setActual(noTax.getActual()-taxActual);
        net.setBudget(noTax.getBudget()-taxBudget);
        net.setDifference(noTax.getDifference()-taxDifference);


        mfr.save(net);

        if (mf.getType().equals("Monthly")) {
            MoneyFlow taxYearly = new MoneyFlow(mf.getId()+"yearly","Tax",mf.getActual(),mf.getBudget(),mf.getDifference(),"Expense",mf.getSubCategory(),mf.getYear(),6,"void", "Yearly");
            mfr.save(taxYearly);
            MoneyFlow noTaxYearly;
            Optional<MoneyFlow> opTnoTaxYearly =mfr.findById("netIncomeNoTaxvoid"+mf.getYear());
            noTaxYearly = opTnoTaxYearly.orElseGet(() -> new MoneyFlow("", "", 0, 0, 0, "", "", 0, 0, "", ""));
            MoneyFlow netYearly;
            Optional<MoneyFlow> opTnetYearly =mfr.findById("netIncomevoid"+mf.getYear());
            netYearly = opTnetYearly.orElseGet(() -> new MoneyFlow("netIncomevoid"+mf.getYear() , "Net Income", 0, 0, 0, "Income", "Net Income", mf.getYear(), 8, mf.getMonth(), mf.getType()));
            List<MoneyFlow> taxesy = mfr.findMoneyFlowByCategoryAndYearAndMonthAndDirection("Tax",mf.getYear(),"void","Expense");
            if (!taxesy.isEmpty())
            {
                for(MoneyFlow instance :taxesy) {
                    taxYearlyActual =taxYearlyActual +instance.getActual();
                    taxYearlyBudget= taxYearlyBudget +instance.getBudget();
                    taxYearlyDifference= taxYearlyDifference +instance.getDifference();

                }}
            netYearly.setActual(noTaxYearly.getActual()-taxYearlyActual);
            netYearly.setBudget(noTaxYearly.getBudget()-taxYearlyBudget);
            netYearly.setDifference(noTaxYearly.getDifference()-taxDifference);



            mfr.save(netYearly);

        }








        return tax;
    }

    @Override
    public MoneyFlow deleteExpense(String id) {
        MoneyFlow mf = mfr.findById(id).orElse(null);
        assert mf != null;

        MoneyFlow total = mfr.findMoneyFlowByIdAndYear("All Expense"+mf.getMonth()+mf.getYear(),mf.getYear(),mf.getMonth(),mf.getType());
        total.setActual(total.getActual()-mf.getActual());
        total.setBudget(total.getBudget()-mf.getBudget());
        total.setDifference(total.getDifference()-mf.getDifference());
        mfr.save(total);
        MoneyFlow noTax = mfr.findMoneyFlowByIdAndYear("netIncomeNoTax"+mf.getMonth()+mf.getYear(), mf.getYear(), mf.getMonth(),mf.getType());
        noTax.setActual(noTax.getActual()+mf.getActual());
        noTax.setBudget(noTax.getBudget()+mf.getBudget());
        noTax.setDifference(noTax.getDifference()+mf.getDifference());
        mfr.save(noTax);
        MoneyFlow net = mfr.findMoneyFlowByIdAndYear("netIncome"+mf.getMonth()+mf.getYear(),mf.getYear(),mf.getMonth(),mf.getType());
        net.setActual(net.getActual()+mf.getActual());
        net.setBudget(net.getBudget()+mf.getBudget());
        net.setDifference(net.getDifference()+mf.getDifference());
        mfr.save(net);

        if (mf.getType().equals("Monthly")) {
            MoneyFlow totalYearly = mfr.findMoneyFlowByIdAndYear("All Expensevoid"+mf.getYear(),mf.getYear(),"void","Yearly");
            totalYearly.setActual(totalYearly.getActual()-mf.getActual());
            totalYearly.setBudget(totalYearly.getBudget()-mf.getBudget());
            totalYearly.setDifference(totalYearly.getDifference()-mf.getDifference());
            mfr.save(totalYearly);
            MoneyFlow noTaxYearly = mfr.findMoneyFlowByIdAndYear("netIncomeNoTaxvoid"+mf.getYear(), mf.getYear(),"void","Yearly");
            noTaxYearly.setActual(noTaxYearly.getActual()+mf.getActual());
            noTaxYearly.setBudget(noTaxYearly.getBudget()+mf.getBudget());
            noTaxYearly.setDifference(noTaxYearly.getDifference()+mf.getDifference());
            mfr.save(noTaxYearly);
            MoneyFlow netYearly = mfr.findMoneyFlowByIdAndYear("netIncomevoid"+mf.getYear(),mf.getYear(),"void","Yearly");
            netYearly.setActual(netYearly.getActual()+mf.getActual());
            netYearly.setBudget(netYearly.getBudget()+mf.getBudget());
            netYearly.setDifference(netYearly.getDifference()+mf.getDifference());
            mfr.save(netYearly);

        }
        mfr.delete(mf);
        return  mf;

    }

    @Override
    public MoneyFlow deleteIncome(String id) {
        MoneyFlow mf = mfr.findById(id).orElse(null);
        assert mf != null;



        MoneyFlow total = mfr.findMoneyFlowByIdAndYear("All Income"+mf.getMonth()+mf.getYear(),mf.getYear(),mf.getMonth(),mf.getType());
        total.setActual(total.getActual()-mf.getActual());
        total.setBudget(total.getBudget()-mf.getBudget());
        total.setDifference(total.getDifference()-mf.getDifference());
        mfr.save(total);
        MoneyFlow noTax = mfr.findMoneyFlowByIdAndYear("netIncomeNoTax"+mf.getMonth()+mf.getYear(), mf.getYear(), mf.getMonth(),mf.getType());
        noTax.setActual(noTax.getActual()-mf.getActual());
        noTax.setBudget(noTax.getBudget()-mf.getBudget());
        noTax.setDifference(noTax.getDifference()-mf.getDifference());
        mfr.save(noTax);
        MoneyFlow net = mfr.findMoneyFlowByIdAndYear("netIncome"+mf.getMonth()+mf.getYear(),mf.getYear(),mf.getMonth(),mf.getType());
        net.setActual(net.getActual()-mf.getActual());
        net.setBudget(net.getBudget()-mf.getBudget());
        net.setDifference(net.getDifference()-mf.getDifference());
        mfr.save(net);

        if (mf.getType().equals("Monthly")) {
            MoneyFlow totalYearly = mfr.findMoneyFlowByIdAndYear("All Incomevoid"+mf.getYear(),mf.getYear(),"void","Yearly");
            totalYearly.setActual(totalYearly.getActual()+mf.getActual());
            totalYearly.setBudget(totalYearly.getBudget()+mf.getBudget());
            totalYearly.setDifference(totalYearly.getDifference()+mf.getDifference());
            mfr.save(totalYearly);
            MoneyFlow noTaxYearly = mfr.findMoneyFlowByIdAndYear("netIncomeNoTaxvoid"+mf.getYear(), mf.getYear(), "void","Yearly");
            noTaxYearly.setActual(noTaxYearly.getActual()-mf.getActual());
            noTaxYearly.setBudget(noTaxYearly.getBudget()-mf.getBudget());
            noTaxYearly.setDifference(noTaxYearly.getDifference()-mf.getDifference());
            mfr.save(noTaxYearly);
            MoneyFlow netYearly = mfr.findMoneyFlowByIdAndYear("netIncomevoid"+mf.getYear(),mf.getYear(),"void","Yearly");
            netYearly.setActual(netYearly.getActual()-mf.getActual());
            netYearly.setBudget(netYearly.getBudget()-mf.getBudget());
            netYearly.setDifference(netYearly.getDifference()-mf.getDifference());
            mfr.save(netYearly);

        }
        mfr.delete(mf);

        return mf;
    }

    @Override
    public MoneyFlow deleteTax(String id) {
        MoneyFlow mf = mfr.findById(id).orElse(null);

        assert mf != null;


        MoneyFlow net = mfr.findMoneyFlowByIdAndYear("netIncome"+mf.getMonth()+mf.getYear(),mf.getYear(),mf.getMonth(),mf.getType());
        net.setActual(net.getActual()+mf.getActual());
        net.setBudget(net.getBudget()+mf.getBudget());
        net.setDifference(net.getDifference()+mf.getDifference());
        mfr.save(net);

        if (mf.getType().equals("Monthly")) {
            MoneyFlow yearlyInstance = mfr.findById(mf.getId()+"yearly").orElse(null);
            mfr.delete(yearlyInstance);
            MoneyFlow netYearly = mfr.findMoneyFlowByIdAndYear("netIncomevoid"+mf.getYear(),mf.getYear(),mf.getMonth(),mf.getType());
            netYearly.setActual(netYearly.getActual()+mf.getActual());
            netYearly.setBudget(netYearly.getBudget()+mf.getBudget());
            netYearly.setDifference(netYearly.getDifference()+mf.getDifference());
            mfr.save(netYearly);

        }
        mfr.delete(mf);

        return mf;
    }


}
