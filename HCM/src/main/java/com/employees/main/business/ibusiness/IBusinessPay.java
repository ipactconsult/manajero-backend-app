package com.employees.main.business.ibusiness;

import com.employees.main.business.dto.PayDTO;
import com.employees.main.entities.Pay;
import com.stripe.exception.StripeException;

import java.util.List;
import java.util.Optional;

public interface IBusinessPay {

float gainCalculate(Pay pay);

Pay addPay(PayDTO payDTO, String id) ;
List<Pay> findData();
Optional<Pay> getItem(String id);

}
