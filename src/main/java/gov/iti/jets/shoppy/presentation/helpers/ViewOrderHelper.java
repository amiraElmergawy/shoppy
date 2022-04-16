package gov.iti.jets.shoppy.presentation.helpers;

import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import gov.iti.jets.shoppy.service.dtos.OrderDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ViewOrderHelper {
    private List<OrderDto> ordersDtoList;
    private String errorMessage;
    Long allOrdersCount;
}
