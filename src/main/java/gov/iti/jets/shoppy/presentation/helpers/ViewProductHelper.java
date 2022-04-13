package gov.iti.jets.shoppy.presentation.helpers;

import gov.iti.jets.shoppy.service.dtos.ProductDto;
import lombok.Data;

@Data
public class ViewProductHelper {
    private ProductDto productDto;
    private String errorMessage;
}