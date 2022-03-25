package us.mattroberts.weedbuddy.model.input;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Builder
public class PurchaseInput {

	@NotBlank(message = "Dispensary must not be blank.")
	@Getter
	@Setter
	private long dispensary;

	@Getter
	@Setter
	private Date purchaseDate;

}
