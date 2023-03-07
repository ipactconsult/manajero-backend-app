package manazelo.microservice.finance.controllers;


import manazelo.microservice.finance.business.businessimpl.ForecastImpl;
import manazelo.microservice.finance.business.businessimpl.MoneyFlowImpl;
import manazelo.microservice.finance.entities.ForecastMoneyFlow;
import manazelo.microservice.finance.entities.MoneyFlow;
import manazelo.microservice.finance.repositories.ForecastRep;
import manazelo.microservice.finance.repositories.MoneyFlowRep;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@Controller
public class BudgetsController {

    final MoneyFlowImpl mfi;
    final MoneyFlowRep mfr;
    final ForecastImpl fi;
    final ForecastRep fr;

    public BudgetsController(MoneyFlowImpl mfi, MoneyFlowRep mfr, ForecastImpl fi, ForecastRep fr) {
        this.mfi = mfi;
        this.mfr = mfr;
        this.fi = fi;
        this.fr = fr;
    }

    @PostMapping("/budgets/createIncome")
    @ResponseBody
    public ResponseEntity<MoneyFlow> addIncomeFlow(@RequestBody MoneyFlow mf) {
        MoneyFlow instance = mfi.createIncomeMoneyFlow(mf);

        return new ResponseEntity<>(instance, HttpStatus.OK);
    }
    @PostMapping("/budgets/createExpense")
    @ResponseBody
    public ResponseEntity<MoneyFlow> addExpenseFlow(@RequestBody MoneyFlow mf) {
        MoneyFlow instance = mfi.createExpenseMoneyFlow(mf);

        return new ResponseEntity<>(instance, HttpStatus.OK);
    }



    @GetMapping("/budgets/retrieveAllMoneyFlow")
    @ResponseBody
    public ResponseEntity<List<MoneyFlow>> getAllMoneyFlow(@RequestParam("direction") String direction , @RequestParam("year") int year,@RequestParam("month") String month,@RequestParam("type") String type) {
        List<MoneyFlow> list = mfi.retrieveAllMoneyFlow(direction,year,month,type);


        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PutMapping("/budgets/updateTax")
    @ResponseBody
    public ResponseEntity<MoneyFlow> upTax(@RequestBody MoneyFlow mf) {
        MoneyFlow instance = mfi.updateOrCreateTax(mf);

        return new ResponseEntity<>(instance, HttpStatus.OK);
    }
    @PostMapping("/budgets/createTax")
    @ResponseBody
    public ResponseEntity<MoneyFlow> createTax(@RequestBody MoneyFlow mf) {
        MoneyFlow instance = mfi.updateOrCreateTax(mf);

        return new ResponseEntity<>(instance, HttpStatus.OK);
    }
    @PutMapping("/budgets/updateExpense")
    @ResponseBody
    public ResponseEntity<MoneyFlow> upExpense(@RequestBody MoneyFlow mf) {
        MoneyFlow instance = mfi.updateExpenseMoneyFlow(mf);

        return new ResponseEntity<>(instance, HttpStatus.OK);
    }
    @PutMapping("/budgets/updateIncome")
    @ResponseBody
    public ResponseEntity<MoneyFlow> upIncome(@RequestBody MoneyFlow mf) {
        MoneyFlow instance = mfi.updateIncomeMoneyFlow(mf);

        return new ResponseEntity<>(instance, HttpStatus.OK);
    }

    @DeleteMapping("/budgets/removeExpense/{id}")
    @ResponseBody
    public ResponseEntity<MoneyFlow> removeExpense(@PathVariable String id) {
       MoneyFlow mf = mfi.deleteExpense(id);
        return new ResponseEntity<>(mf,HttpStatus.OK);
    }
    @DeleteMapping("/budgets/removeIncome/{id}")
    @ResponseBody
    public ResponseEntity<MoneyFlow> removeIncome(@PathVariable String id) {
        MoneyFlow mf =mfi.deleteIncome(id);
        return new ResponseEntity<>(mf,HttpStatus.OK);
    }
    @DeleteMapping("/budgets/removeTax/{id}")
    @ResponseBody
    public ResponseEntity<MoneyFlow> removeTax(@PathVariable String id) {
        MoneyFlow mf = mfi.deleteTax(id);
        return new ResponseEntity<>(mf,HttpStatus.OK);
    }








    @GetMapping("/budgets/test")
    @ResponseBody
    public ResponseEntity<List<MoneyFlow>> getAllMoneyFlowd(@RequestParam("direction") String direction , @RequestParam("year") int year,@RequestParam("month") String month,@RequestParam("type") String type) {
        List<MoneyFlow> list = mfr.findMoneyFlowByDirectionAndYearAndMonthAndType(direction,year,month,type);


        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/budgets/test2")
    @ResponseBody
    public ResponseEntity<MoneyFlow> getAllMoneyFlowde(@RequestParam("id") String id , @RequestParam("year") int year,@RequestParam("month") String month,@RequestParam("type") String type) {
        MoneyFlow list = mfr.findMoneyFlowByIdAndYear(id,year,month,type);


        return new ResponseEntity<>(list, HttpStatus.OK);
    }



    //Forecast Budgets
    @PostMapping("/budgets/createFmf")
    @ResponseBody
    public ResponseEntity<ForecastMoneyFlow> addForecastFlow(@RequestBody ForecastMoneyFlow fmf) {
        ForecastMoneyFlow instance = fi.createOrUpdateForecastMoneyFlow(fmf);

        return new ResponseEntity<>(instance, HttpStatus.OK);
    }
    @PutMapping("/budgets/updateFmf")
    @ResponseBody
    public ResponseEntity<ForecastMoneyFlow> updateForecastFlow(@RequestBody ForecastMoneyFlow fmf) {
        ForecastMoneyFlow instance = fi.createOrUpdateForecastMoneyFlow(fmf);

        return new ResponseEntity<>(instance, HttpStatus.OK);
    }
    @PostMapping("/budgets/createForecastTax")
    @ResponseBody
    public ResponseEntity<ForecastMoneyFlow> addTax(@RequestBody ForecastMoneyFlow fmf) {
        ForecastMoneyFlow instance = fi.createOrUpdateTax(fmf);

        return new ResponseEntity<>(instance, HttpStatus.OK);
    }
    @PutMapping("/budgets/updateForecastTax")
    @ResponseBody
    public ResponseEntity<ForecastMoneyFlow> updateTax(@RequestBody ForecastMoneyFlow fmf) {
        ForecastMoneyFlow instance = fi.createOrUpdateTax(fmf);

        return new ResponseEntity<>(instance, HttpStatus.OK);
    }

    @DeleteMapping("/budgets/removeForecastFlow/{id}")
    @ResponseBody
    public ResponseEntity<ForecastMoneyFlow> removeForecastFlow(@PathVariable String id) {
        ForecastMoneyFlow mf =fi.deleteForecastMoneyFlow(id);
        return new ResponseEntity<>(mf,HttpStatus.OK);
    }
    @DeleteMapping("/budgets/removeForecastTax/{id}")
    @ResponseBody
    public ResponseEntity<ForecastMoneyFlow> removeForecastTax(@PathVariable String id) {
        ForecastMoneyFlow mf = fi.deleteTax(id);
        return new ResponseEntity<>(mf,HttpStatus.OK);
    }



    @GetMapping("/budgets/test3")
    @ResponseBody
    public ResponseEntity<List<ForecastMoneyFlow>> getAllMoneyFlowde() {
        List<ForecastMoneyFlow> fmf = fr.computeTotalYearly();


        return new ResponseEntity<>(fmf, HttpStatus.OK);
    }

    @GetMapping("/budgets/test4")
    @ResponseBody
    public ResponseEntity<List<ForecastMoneyFlow>> getAllMoneyFlowded() {
        List<ForecastMoneyFlow> fmf = fr.computeTotalByType();







        return new ResponseEntity<>(fmf, HttpStatus.OK);
    }

    @GetMapping("/budgets/trah/{type}/{year}")
    @ResponseBody
    public ResponseEntity<ForecastMoneyFlow> d(@PathVariable String type,@PathVariable int year) {
        ForecastMoneyFlow fmf = fr.computeTotalsByType(type,year);







        return new ResponseEntity<>(fmf, HttpStatus.OK);
    }
    @GetMapping("/budgets/test5/{differenciator}/{year}")
    @ResponseBody
    public ResponseEntity<ForecastMoneyFlow> getAllMoneyFlowdede(@PathVariable String differenciator,@PathVariable int year) {
        ForecastMoneyFlow fmf = fr.findFmfByDifferenciatorAndYear(differenciator,year);







        return new ResponseEntity<>(fmf, HttpStatus.OK);
    }
    @GetMapping("/budgets/findByYear/{year}")
    @ResponseBody
    public ResponseEntity<List<ForecastMoneyFlow>> getAllMoneyFlowdede(@PathVariable int year) {
        List<ForecastMoneyFlow> list = fi.retrieveAllByYear(year);







        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/budgets/riskInfos/{year}")
    @ResponseBody
    public ResponseEntity<MoneyFlow> getRiskInfos(@PathVariable int year) {
MoneyFlow mf = mfi.getBudgetRiskInfos(year);






        return new ResponseEntity<>(mf, HttpStatus.OK);
    }


    @GetMapping("/forecast/forecastExpenses/{year}")
    @ResponseBody
    public float getForecastExpenses(@PathVariable int year) {

        ForecastMoneyFlow found = fr.findFmfByTypeAndYear("Total Expense",year);




        return found.getTotal();
    }





}
