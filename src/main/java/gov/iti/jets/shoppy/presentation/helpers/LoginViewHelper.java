package gov.iti.jets.shoppy.presentation.helpers;

import gov.iti.jets.shoppy.repository.entity.AdminEntity;
import gov.iti.jets.shoppy.service.dtos.AdminDto;
import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import lombok.Data;

@Data
public class LoginViewHelper {
    private CustomerDto customerDto;
    private AdminDto adminDto;
    private String error;
}
