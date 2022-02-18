package us.mattroberts.weedbuddy.model.input;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
public class StrainInput {

	@Size(max = 250, message = "Name cannot be more than 250 characters.")
	@NotBlank(message = "Name must not be blank.")
	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String description;

	@Size(max = 2, message = "Flower Type cannot be more than 2 characters.")
	@Getter
	@Setter
	private String flowerType;

}
