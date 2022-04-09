package gov.iti.jets.shoppy.presentation.helpers;


import gov.iti.jets.shoppy.service.dtos.OrderDto;
import gov.iti.jets.shoppy.service.dtos.Role;
import lombok.Data;

@Data
public class LoginViewHelper {
    private String email;
    private Role role;
    private Integer id;
    private String error;
    private OrderDto shoppingCart;
}
