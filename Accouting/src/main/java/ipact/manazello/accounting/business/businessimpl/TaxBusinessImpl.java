package ipact.manazello.accounting.business.businessimpl;

import ipact.manazello.accounting.business.ibusiness.ITaxBusiness;
import ipact.manazello.accounting.model.Tax;
import ipact.manazello.accounting.repository.TaxRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TaxBusinessImpl implements ITaxBusiness {

    private final TaxRepository tr;

    public TaxBusinessImpl(TaxRepository tr) {
        this.tr = tr;
    }


    @Override
    public Tax addTax(Tax tax) {
        Instant instanceNow = Instant.now();
        tax.setCreatedAt(instanceNow);
        tax.setModifiedAt(instanceNow);
        return tax;
    }

    @Override
    public List<Tax> getAllTaxe() {
        return tr.findAll();
    }

    @Override
    public Tax updateTax(Tax tax) {
        Optional<Tax> taxManagedEntitys = tr.findById(tax.getId());
        return ((taxManagedEntitys.isPresent()) ? tr.save(tax) : null);

    }
    @Override
    public boolean deleteTax(String id) {
        Optional<Tax> taxManagedEntitys = tr.findById(id);
        if (taxManagedEntitys.isPresent()) {
            tr.delete(taxManagedEntitys.get());
            return true;
        }
        return false;        }



}
