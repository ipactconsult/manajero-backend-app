package manazelo.microservice.finance.business.ibusiness;

import manazelo.microservice.finance.entities.MoneyFlow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMoneyFlow {
  List<MoneyFlow> retrieveAllMoneyFlow (String direction,int year, String month, String type );
  MoneyFlow updateOrCreateTax (MoneyFlow mf);
  MoneyFlow deleteExpense (String id);
  MoneyFlow deleteIncome (String id);
  MoneyFlow deleteTax (String id);
  MoneyFlow createIncomeMoneyFlow (MoneyFlow mf);
  MoneyFlow createExpenseMoneyFlow(MoneyFlow mf);
  MoneyFlow updateIncomeMoneyFlow (MoneyFlow mf);
  MoneyFlow updateExpenseMoneyFlow(MoneyFlow mf);

  //risk Management
  MoneyFlow getBudgetRiskInfos(int year);
}
