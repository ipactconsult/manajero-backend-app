package manazelo.microservice.finance.business.businessimpl;
import manazelo.microservice.finance.business.ibusiness.IForecast;
import manazelo.microservice.finance.entities.ForecastMoneyFlow;
import manazelo.microservice.finance.repositories.ForecastRep;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ForecastImpl implements IForecast {

    private final ForecastRep fr;

    public ForecastImpl(ForecastRep fr) {
        this.fr = fr;
    }




    private static final String EXPENSE ="Expense";
    private void computeTotals (ForecastMoneyFlow fmf) {
       ForecastMoneyFlow taxFound =fr.computeTotalsByType("Tax",fmf.getYear());
        if (taxFound==null) {
            taxFound = new ForecastMoneyFlow("Tax "+fmf.getYear(),EXPENSE,"Tax","Annual Tax", fmf.getYear(),0 ,0,0,0,0,0,0,0,0,0,0,0,0,"tax",13);
         }
        //Total Operating and Non Operating
        ForecastMoneyFlow totalTyped=new ForecastMoneyFlow();
        List<ForecastMoneyFlow> totalsByType=fr.computeTotalByType();

        List<ForecastMoneyFlow> filtered =totalsByType.stream().filter(ele->ele.getId().equals("{\"direction\": \""+fmf.getDirection()+ "\", \"year\": "+fmf.getYear()+ ", \"type\": \""+fmf.getType()+"\"" +"}")).collect(Collectors.toList());

        for (ForecastMoneyFlow f : filtered){
               totalTyped = f;}

            totalTyped.setId("{\"direction\": \""+fmf.getDirection()+ "\", \"year\": "+fmf.getYear()+ ", \"type\": \""+fmf.getType()+"\"" +"}");
            totalTyped.setType("Total "+fmf.getType());
            totalTyped.setDirection(fmf.getDirection());
            totalTyped.setYear(fmf.getYear());
            totalTyped.setDescription("Total "+fmf.getType());
            totalTyped.setTotal(totalTyped.getApril()+totalTyped.getDecember()+totalTyped.getJuly()+totalTyped.getNovember()+totalTyped.getOctober()+totalTyped.getSeptember()+totalTyped.getAugust()+totalTyped.getJune()+totalTyped.getMay()+totalTyped.getMarch()+totalTyped.getFebruary()+totalTyped.getJanuary());
            totalTyped.setDifferenciator("Total_"+fmf.getType());
        switch (fmf.getType()) {
            case "Operating Income":
                totalTyped.setSortOrder(2);
                break;
            case "Non Operating Income":
                totalTyped.setSortOrder(4);

                break;
            case "Operating Expense":
                totalTyped.setSortOrder(7);
                break;
            case "Non Operating Expense":
                totalTyped.setSortOrder(9);
                break;
            default :
                break;
        }

        fr.save(totalTyped);

        //Totals
        ForecastMoneyFlow total=new ForecastMoneyFlow();
        List<ForecastMoneyFlow> totals = fr.computeTotalYearly();

        List<ForecastMoneyFlow> filteredT =totals.stream().filter(ele->ele.getId().equals("{\"direction\": \""+fmf.getDirection()+ "\", \"year\": "+fmf.getYear()+ ", \"differenciator\": \""+"Unit"+"\"" +"}")).collect(Collectors.toList());
        for (ForecastMoneyFlow f : filteredT){
            total = f;
        }
        total.setId("{\"direction\": \""+fmf.getDirection()+ "\", \"year\": "+fmf.getYear()+ ", \"type\": \"Total "+fmf.getDirection()+"\"" +"}");
            total.setType("Total "+fmf.getDirection());
            total.setDirection(fmf.getDirection());
            total.setYear(fmf.getYear());
            total.setDescription("Total "+fmf.getDirection());
        total.setDifferenciator("Total_"+fmf.getDirection());
        if (fmf.getDirection().equals("Income")) {
            total.setSortOrder(5);
        }
        else {
            total.setSortOrder(10);
        }


        total.setTotal(total.getApril()+total.getDecember()+total.getJuly()+total.getNovember()+total.getOctober()+total.getSeptember()+total.getAugust()+total.getJune()+total.getMay()+total.getMarch()+total.getFebruary()+total.getJanuary());

        fr.save(total);

        ForecastMoneyFlow netIncome;
        ForecastMoneyFlow totalExpenseFound;
       ForecastMoneyFlow totalIncomeFound;

        if( fmf.getDirection().equals("Income")) {

            totalExpenseFound = fr.findFmfByDifferenciatorAndYear("Total_Expense",fmf.getYear());

            if(totalExpenseFound==null){
                netIncome = new ForecastMoneyFlow("Net Income Before Tax "+fmf.getYear(),"Income","Net Income Before Tax","Net Income Before Tax",fmf.getYear(),total.getJanuary(),total.getFebruary(),total.getMarch(),total.getApril(),total.getMay(),total.getJune(),total.getJuly(),total.getAugust(),total.getSeptember(),total.getOctober(),total.getNovember(),total.getDecember(),total.getTotal(),"No tax",12);
                fr.save(netIncome);
            }
            else {
                netIncome = new ForecastMoneyFlow("Net Income Before Tax "+fmf.getYear(),"Income","Net Income Before Tax","Net Income Before Tax",fmf.getYear(),total.getJanuary()-totalExpenseFound.getJanuary(),total.getFebruary()-totalExpenseFound.getFebruary(),total.getMarch()-totalExpenseFound.getMarch(),total.getApril()-totalExpenseFound.getApril(),total.getMay()-totalExpenseFound.getMay(),total.getJune()-totalExpenseFound.getJune(),total.getJuly()-totalExpenseFound.getJuly(),total.getAugust()-totalExpenseFound.getAugust(),total.getSeptember()-totalExpenseFound.getSeptember(),total.getOctober()-totalExpenseFound.getOctober(),total.getNovember()-totalExpenseFound.getNovember(),total.getDecember()-totalExpenseFound.getDecember(),total.getTotal()-totalExpenseFound.getTotal(),"No Tax",12);
                fr.save(netIncome);

            }


        }
        else {

            totalIncomeFound =fr.findFmfByDifferenciatorAndYear("Total_Income",fmf.getYear());

            if(totalIncomeFound==null){
                netIncome = new ForecastMoneyFlow("Net Income Before Tax "+fmf.getYear(),"Income","Net Income Before Tax","Net Income Before Tax",fmf.getYear(),-total.getJanuary(),-total.getFebruary(),-total.getMarch(),-total.getApril(),-total.getMay(),-total.getJune(),-total.getJuly(),-total.getAugust(),-total.getSeptember(),-total.getOctober(),-total.getNovember(),-total.getDecember(),-total.getTotal(),"No tax",12);
                fr.save(netIncome);
            }
            else {
                netIncome = new ForecastMoneyFlow("Net Income Before Tax "+fmf.getYear(),"Income","Net Income Before Tax","Net Income Before Tax",fmf.getYear(),totalIncomeFound.getJanuary()-total.getJanuary(),totalIncomeFound.getFebruary()-total.getFebruary(),totalIncomeFound.getMarch()-total.getMarch(),totalIncomeFound.getApril()-total.getApril(),totalIncomeFound.getMay()-total.getMay(),totalIncomeFound.getJune()-total.getJune(),totalIncomeFound.getJuly()-total.getJuly(),totalIncomeFound.getAugust()-total.getAugust(),totalIncomeFound.getSeptember()-total.getSeptember(),totalIncomeFound.getOctober()-total.getOctober(),totalIncomeFound.getNovember()-total.getNovember(),totalIncomeFound.getDecember()-total.getDecember(),totalIncomeFound.getTotal()-total.getTotal(),"No tax",12);
                fr.save(netIncome);

            }


        }

        ForecastMoneyFlow finalNet= new ForecastMoneyFlow("Net Income"+fmf.getYear(),"Income","Net Income","Net Income",fmf.getYear(), netIncome.getJanuary() - taxFound.getJanuary(), netIncome.getFebruary()- taxFound.getFebruary(), netIncome.getMarch()- taxFound.getMarch(), netIncome.getApril()- taxFound.getApril(), netIncome.getMay()- taxFound.getMay(), netIncome.getJune()- taxFound.getJune(), netIncome.getJuly()-taxFound.getJuly(), netIncome.getAugust()- taxFound.getAugust(), netIncome.getSeptember()- taxFound.getSeptember(), netIncome.getOctober()- taxFound.getOctober(), netIncome.getNovember()- taxFound.getNovember(), netIncome.getDecember()-taxFound.getDecember(), netIncome.getTotal()- taxFound.getTotal() ,"Net",14);
        fr.save(finalNet);
    }



    @Override
    public ForecastMoneyFlow createOrUpdateForecastMoneyFlow(ForecastMoneyFlow fmf) {
        fmf.setTotal(fmf.getApril()+fmf.getDecember()+fmf.getJuly()+fmf.getNovember()+fmf.getOctober()+fmf.getSeptember()+fmf.getAugust()+fmf.getJune()+fmf.getMay()+fmf.getMarch()+fmf.getFebruary()+fmf.getJanuary());
        fmf.setDifferenciator("Unit");
        if (fmf.getDirection().equals("Income")&& fmf.getType().equals("Operating Income")) {
            fmf.setSortOrder(1);
        }
        else if (fmf.getDirection().equals("Income")&& fmf.getType().equals("Non Operating Income")) {
            fmf.setSortOrder(3);
        }
        else if (fmf.getDirection().equals(EXPENSE)&& fmf.getType().equals("Operating Expense")) {
            fmf.setSortOrder(6);
        }
        else  if (fmf.getDirection().equals(EXPENSE)&& fmf.getType().equals("Non Operating Expense")){
            fmf.setSortOrder(8);

        }

        fr.save(fmf);
        computeTotals(fmf);
        return fmf;
    }



    @Override
    public List<ForecastMoneyFlow> retrieveAllForecastMoneyFlow() {
        return null;
    }



    @Override
    public List<ForecastMoneyFlow> retrieveAllByYear(int year) {

        return fr.findFmfByYear(year);
    }

    @Override
    public ForecastMoneyFlow createOrUpdateTax(ForecastMoneyFlow fmf) {
        fmf.setTotal(fmf.getApril()+fmf.getDecember()+fmf.getJuly()+fmf.getNovember()+fmf.getOctober()+fmf.getSeptember()+fmf.getAugust()+fmf.getJune()+fmf.getMay()+fmf.getMarch()+fmf.getFebruary()+fmf.getJanuary());

        fmf.setSortOrder(13);
        ForecastMoneyFlow created = fr.save(fmf);
        ForecastMoneyFlow netNoTax = fr.findFmfByTypeAndYear("Net Income Before Tax", fmf.getYear());
        if (netNoTax==null)
        {  netNoTax = new ForecastMoneyFlow();}
        ForecastMoneyFlow net = fr.findFmfByTypeAndYear("Net Income",fmf.getYear());
        if (net ==null) {
            net = new ForecastMoneyFlow();
        }

        ForecastMoneyFlow totalTax = fr.computeTotalsByType("Tax", fmf.getYear());
        net.setId("Net Income"+fmf.getYear());
        net.setDirection("Income");
        net.setType("Net Income");
        net.setDescription("Net Income");
        net.setDifferenciator("Net");
        net.setSortOrder(14);
        net.setYear(fmf.getYear());
        net.setJanuary(netNoTax.getJanuary()-totalTax.getJanuary());
        net.setFebruary(netNoTax.getFebruary()- totalTax.getFebruary());
        net.setMarch(netNoTax.getMarch()- totalTax.getMarch());
        net.setApril(netNoTax.getApril()- totalTax.getApril());
        net.setMay(netNoTax.getMay()-totalTax.getMay());
        net.setJune(netNoTax.getJune()-totalTax.getJune());
        net.setJuly(netNoTax.getJuly()- totalTax.getJuly());
        net.setAugust(netNoTax.getAugust()- totalTax.getAugust());
        net.setSeptember(netNoTax.getSeptember()- totalTax.getSeptember());
        net.setOctober(netNoTax.getOctober()-totalTax.getOctober());
        net.setNovember(netNoTax.getNovember()- totalTax.getNovember());
        net.setDecember(netNoTax.getDecember()-totalTax.getDecember());
        net.setTotal(netNoTax.getTotal()-totalTax.getTotal());
        fr.save(net);



        return created;
    }
    @Override
    public ForecastMoneyFlow deleteTax(String id) {
        ForecastMoneyFlow toDelete = fr.findById(id).orElse(null);
        assert toDelete != null;
        ForecastMoneyFlow net = fr.findFmfByTypeAndYear("Net Income",toDelete.getYear());
        net.setJanuary(net.getJanuary()+toDelete.getJanuary());
        net.setFebruary(net.getFebruary()+ toDelete.getFebruary());
        net.setMarch(net.getMarch()+ toDelete.getMarch());
        net.setApril(net.getApril()+ toDelete.getApril());
        net.setMay(net.getMay()+toDelete.getMay());
        net.setJune(net.getJune()+toDelete.getJune());
        net.setJuly(net.getJuly()+ toDelete.getJuly());
        net.setAugust(net.getAugust()+ toDelete.getAugust());
        net.setSeptember(net.getSeptember()+ toDelete.getSeptember());
        net.setOctober(net.getOctober()+ toDelete.getOctober());
        net.setNovember(net.getNovember()+ toDelete.getNovember());
        net.setDecember(net.getDecember()+toDelete.getDecember());
        net.setTotal(net.getTotal()+toDelete.getTotal());
        fr.save(net);
        fr.delete(toDelete);

        return toDelete;


    }

    @Override
    public ForecastMoneyFlow deleteForecastMoneyFlow(String id) {
        ForecastMoneyFlow toDelete = fr.findById(id).orElse(null);
        assert toDelete != null;
        ForecastMoneyFlow netNoTax = fr.findById("Net Income Before Tax "+toDelete.getYear()).orElse(null);
        assert  netNoTax != null;
        ForecastMoneyFlow net = fr.findFmfByTypeAndYear("Net Income",toDelete.getYear());
        ForecastMoneyFlow total= fr.findFmfByTypeAndYear("Total "+toDelete.getDirection(), toDelete.getYear());
        ForecastMoneyFlow totalTyped = fr.findFmfByTypeAndYear("Total "+toDelete.getType(),toDelete.getYear());
        total.setJanuary(total.getJanuary()-toDelete.getJanuary());
        total.setFebruary(total.getFebruary()-toDelete.getFebruary());
        total.setMarch(total.getMarch()-toDelete.getMarch());
        total.setApril(total.getApril()-toDelete.getApril());
        total.setMay(total.getMay()- toDelete.getMay());
        total.setJune(total.getJune()-toDelete.getJune());
        total.setJuly(total.getJuly()-toDelete.getJuly());
        total.setAugust(total.getAugust()- toDelete.getAugust());
        total.setSeptember(total.getSeptember()-toDelete.getSeptember());
        total.setOctober(total.getOctober()-toDelete.getOctober());
        total.setNovember(total.getNovember()-toDelete.getNovember());
        total.setDecember(total.getDecember()-toDelete.getDecember());
        total.setTotal(total.getTotal()-toDelete.getTotal());
        fr.save(total);
        totalTyped.setJanuary(totalTyped.getJanuary()-toDelete.getJanuary());
        totalTyped.setFebruary(totalTyped.getFebruary()-toDelete.getFebruary());
        totalTyped.setMarch(totalTyped.getMarch()-toDelete.getMarch());
        totalTyped.setApril(totalTyped.getApril()-toDelete.getApril());
        totalTyped.setMay(totalTyped.getMay()- toDelete.getMay());
        totalTyped.setJune(totalTyped.getJune()-toDelete.getJune());
        totalTyped.setJuly(totalTyped.getJuly()-toDelete.getJuly());
        totalTyped.setAugust(totalTyped.getAugust()- toDelete.getAugust());
        totalTyped.setSeptember(totalTyped.getSeptember()-toDelete.getSeptember());
        totalTyped.setOctober(totalTyped.getOctober()-toDelete.getOctober());
        totalTyped.setNovember(totalTyped.getNovember()-toDelete.getNovember());
        totalTyped.setDecember(totalTyped.getDecember()-toDelete.getDecember());
        totalTyped.setTotal(totalTyped.getTotal()-toDelete.getTotal());
        fr.save(totalTyped);

        if (toDelete.getDirection().equals("Income")) {
            netNoTax.setJanuary(netNoTax.getJanuary()-toDelete.getJanuary());
            netNoTax.setFebruary(netNoTax.getFebruary()- toDelete.getFebruary());
            netNoTax.setMarch(netNoTax.getMarch()- toDelete.getMarch());
            netNoTax.setApril(netNoTax.getApril()- toDelete.getApril());
            netNoTax.setMay(netNoTax.getMay()-toDelete.getMay());
            netNoTax.setJune(netNoTax.getJune()-toDelete.getJune());
            netNoTax.setJuly(netNoTax.getJuly()- toDelete.getJuly());
            netNoTax.setAugust(netNoTax.getAugust()- toDelete.getAugust());
            netNoTax.setSeptember(netNoTax.getSeptember()- toDelete.getSeptember());
            netNoTax.setOctober(netNoTax.getOctober()- toDelete.getOctober());
            netNoTax.setNovember(netNoTax.getNovember()- toDelete.getNovember());
            netNoTax.setDecember(netNoTax.getDecember()-toDelete.getDecember());
            netNoTax.setTotal(netNoTax.getTotal()-toDelete.getTotal());
            fr.save(netNoTax);
            net.setJanuary(net.getJanuary()-toDelete.getJanuary());
            net.setFebruary(net.getFebruary()- toDelete.getFebruary());
            net.setMarch(net.getMarch()- toDelete.getMarch());
            net.setApril(net.getApril()- toDelete.getApril());
            net.setMay(net.getMay()-toDelete.getMay());
            net.setJune(net.getJune()-toDelete.getJune());
            net.setJuly(net.getJuly()- toDelete.getJuly());
            net.setAugust(net.getAugust()- toDelete.getAugust());
            net.setSeptember(net.getSeptember()- toDelete.getSeptember());
            net.setOctober(net.getOctober()- toDelete.getOctober());
            net.setNovember(net.getNovember()- toDelete.getNovember());
            net.setDecember(net.getDecember()-toDelete.getDecember());
            net.setTotal(net.getTotal()-toDelete.getTotal());
            fr.save(net);
        }
        else {
            netNoTax.setJanuary(netNoTax.getJanuary()+toDelete.getJanuary());
            netNoTax.setFebruary(netNoTax.getFebruary()+ toDelete.getFebruary());
            netNoTax.setMarch(netNoTax.getMarch()+ toDelete.getMarch());
            netNoTax.setApril(netNoTax.getApril()+ toDelete.getApril());
            netNoTax.setMay(netNoTax.getMay()+toDelete.getMay());
            netNoTax.setJune(netNoTax.getJune()+toDelete.getJune());
            netNoTax.setJuly(netNoTax.getJuly()+ toDelete.getJuly());
            netNoTax.setAugust(netNoTax.getAugust()+ toDelete.getAugust());
            netNoTax.setSeptember(netNoTax.getSeptember()+ toDelete.getSeptember());
            netNoTax.setOctober(netNoTax.getOctober()+ toDelete.getOctober());
            netNoTax.setNovember(netNoTax.getNovember()+ toDelete.getNovember());
            netNoTax.setDecember(netNoTax.getDecember()+toDelete.getDecember());
            netNoTax.setTotal(netNoTax.getTotal()+toDelete.getTotal());
            fr.save(netNoTax);
            net.setJanuary(net.getJanuary()+toDelete.getJanuary());
            net.setFebruary(net.getFebruary()+ toDelete.getFebruary());
            net.setMarch(net.getMarch()+ toDelete.getMarch());
            net.setApril(net.getApril()+ toDelete.getApril());
            net.setMay(net.getMay()+toDelete.getMay());
            net.setJune(net.getJune()+toDelete.getJune());
            net.setJuly(net.getJuly()+ toDelete.getJuly());
            net.setAugust(net.getAugust()+ toDelete.getAugust());
            net.setSeptember(net.getSeptember()+ toDelete.getSeptember());
            net.setOctober(net.getOctober()+ toDelete.getOctober());
            net.setNovember(net.getNovember()+ toDelete.getNovember());
            net.setDecember(net.getDecember()+toDelete.getDecember());
            net.setTotal(net.getTotal()+toDelete.getTotal());
            fr.save(net);

        }

        fr.delete(toDelete);



        return toDelete;
    }
}
