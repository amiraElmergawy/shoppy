package gov.iti.jets.shoppy.presentation.helpers;

import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import lombok.Data;

@Data
public class ProfileViewHelper {
    private CustomerDto customerDto;
    private String error;

}
