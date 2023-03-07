package ipact.manazello.accounting.business.ibusiness;

import ipact.manazello.accounting.model.Tax;

import java.util.List;

public interface ITaxBusiness {
    Tax addTax(Tax tax);
    List<Tax> getAllTaxe();
    Tax updateTax(Tax tax);
    boolean deleteTax(String id);

}
