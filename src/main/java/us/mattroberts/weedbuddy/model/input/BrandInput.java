package us.mattroberts.weedbuddy.model.input;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
public class BrandInput {

	@Size(max = 100, message = "Name cannot be more than 100 characters.")
	@NotBlank(message = "Name must not be blank.")
	@Getter
	@Setter
	private String name;

}
