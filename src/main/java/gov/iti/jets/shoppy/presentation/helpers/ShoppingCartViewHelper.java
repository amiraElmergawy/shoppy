package gov.iti.jets.shoppy.presentation.helpers;

import gov.iti.jets.shoppy.service.dtos.OrderDto;
import lombok.Data;

@Data
public class ShoppingCartViewHelper {
    private OrderDto orderDto;
    private String error;
}
