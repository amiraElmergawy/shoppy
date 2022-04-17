package gov.iti.jets.shoppy.service.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderProductIdDto {
    private Integer orderId;
    private Integer productId;
}
