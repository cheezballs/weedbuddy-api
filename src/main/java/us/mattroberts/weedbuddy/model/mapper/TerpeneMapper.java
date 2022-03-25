package us.mattroberts.weedbuddy.model.mapper;

import us.mattroberts.weedbuddy.model.entity.Terpene;
import us.mattroberts.weedbuddy.model.input.TerpeneInput;

public class TerpeneMapper {

	public static Terpene mapFromInput(TerpeneInput input) {
		Terpene terpene = new Terpene();
		terpene.setName(input.getName());
		terpene.setDescription(input.getDescription());
		return terpene;
	}

	public static void mapFromInput(Terpene terpene, TerpeneInput input) {
		terpene.setName(input.getName());
		terpene.setDescription(input.getDescription());
	}
}
