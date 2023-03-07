package manazelo.microservice.finance.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
	@Id
	private String id;
	private float totalexpense;
	private float totalincome;
	private float totalbalance;











}
