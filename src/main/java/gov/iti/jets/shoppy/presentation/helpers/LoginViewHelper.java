package gov.iti.jets.shoppy.presentation.helpers;

import gov.iti.jets.shoppy.service.dtos.UserDto;
import lombok.Data;

@Data
public class LoginViewHelper {

    private static LoginViewHelper instance = new LoginViewHelper();
    private UserDto userDto;
    private String error;
    private LoginViewHelper(){}
    public static LoginViewHelper getInstance(){
        return instance;
    }
}
