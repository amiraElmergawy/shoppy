package gov.iti.jets.shoppy.presentation.helpers;

import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import gov.iti.jets.shoppy.service.dtos.ProductDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ViewCustomerHelper {
    private List<CustomerDto> customerDtoList;
    private String errorMessage;
    Long allCustomerCount;
}
