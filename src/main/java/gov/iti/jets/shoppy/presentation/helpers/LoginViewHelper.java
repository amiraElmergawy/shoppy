package gov.iti.jets.shoppy.presentation.helpers;

import gov.iti.jets.shoppy.service.dtos.UserDto;
import lombok.Data;

@Data
public class LoginViewHelper {
    private UserDto userDto;
    private String error;
}
