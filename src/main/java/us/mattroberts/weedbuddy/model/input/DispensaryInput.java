package us.mattroberts.weedbuddy.model.input;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
public class DispensaryInput {

    @Size(max = 100, message = "Name cannot be more than 100 characters.")
    @NotBlank(message = "Name must not be blank.")
    @Getter
    @Setter
    private String name;

    @Size(max = 250, message = "Address cannot be more than 250 characters.")
    @Getter
    @Setter
    private String address;

    @Size(max = 100, message = "City cannot be more than 100 characters.")
    @Getter
    @Setter
    private String city;

    @Size(max = 2, message = "State cannot be more than 2 characters.")
    @Getter
    @Setter
    private String state;

    @Getter
    @Setter
    private String gpsCoordinates;

}
