package us.mattroberts.weedbuddy.model.mapper;

import us.mattroberts.weedbuddy.model.entity.Strain;
import us.mattroberts.weedbuddy.model.input.StrainInput;

public class StrainMapper {

	public static Strain mapFromInput(StrainInput input) {
		Strain strain = new Strain();
		strain.setName(input.getName());
		strain.setDescription(input.getDescription());
		strain.setFlowerType(input.getFlowerType());
		return strain;
	}

	public static void mapFromInput(Strain strain, StrainInput input) {
		strain.setName(input.getName());
		strain.setDescription(input.getDescription());
		strain.setFlowerType(input.getFlowerType());
	}
}
