package us.mattroberts.weedbuddy.model.mapper;

import us.mattroberts.weedbuddy.model.entity.Brand;
import us.mattroberts.weedbuddy.model.input.BrandInput;

public class BrandMapper {

	public static Brand mapFromInput(BrandInput input) {
		Brand brand = new Brand();
		brand.setName(input.getName());
		return brand;
	}

	public static void mapFromInput(Brand brand, BrandInput input) {
		brand.setName(input.getName());
	}

}
