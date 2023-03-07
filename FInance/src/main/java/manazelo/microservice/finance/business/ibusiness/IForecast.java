package manazelo.microservice.finance.business.ibusiness;


import manazelo.microservice.finance.entities.ForecastMoneyFlow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IForecast {

    ForecastMoneyFlow createOrUpdateForecastMoneyFlow ( ForecastMoneyFlow fmf);
    List<ForecastMoneyFlow> retrieveAllForecastMoneyFlow ();
    ForecastMoneyFlow deleteForecastMoneyFlow(String id);
    ForecastMoneyFlow deleteTax (String id);
    List<ForecastMoneyFlow> retrieveAllByYear (int year);
    ForecastMoneyFlow createOrUpdateTax ( ForecastMoneyFlow fmf);
}
