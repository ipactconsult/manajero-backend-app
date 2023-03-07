package ipact.manazello.accounting.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaxDto {
    @Id
    private String id;
    private String type;
    private String name;
    private String status;
    private String reportTaxType;
    private boolean canApplyToAssets;
    private boolean canApplyToEquity;
    private boolean canApplyToExpenses;
    private boolean canApplyToLiabilities;
    private boolean canApplyToRevenue;
    private String displayTaxRate;
    private float effectiveRate;

}
