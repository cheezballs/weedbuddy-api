package us.mattroberts.weedbuddy.model.mapper;

import us.mattroberts.weedbuddy.model.entity.Dispensary;
import us.mattroberts.weedbuddy.model.input.DispensaryInput;

public class DispensaryMapper {

	public static Dispensary mapFromInput(DispensaryInput input) {
		Dispensary dispensary = new Dispensary();
		dispensary.setName(input.getName());
		dispensary.setAddress(input.getAddress());
		dispensary.setCity(input.getCity());
		dispensary.setState(input.getState());
		dispensary.setGpsCoordinates(input.getGpsCoordinates());
		return dispensary;
	}

	public static void mapFromInput(Dispensary dispensary, DispensaryInput input) {
		dispensary.setName(input.getName());
		dispensary.setAddress(input.getAddress());
		dispensary.setCity(input.getCity());
		dispensary.setState(input.getState());
		dispensary.setGpsCoordinates(input.getGpsCoordinates());
	}

}
