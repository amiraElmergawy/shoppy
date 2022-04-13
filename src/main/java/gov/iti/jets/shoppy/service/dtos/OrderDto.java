package gov.iti.jets.shoppy.service.dtos;


import lombok.Builder;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class OrderDto {
    private Integer id;
    private Date createdAt;
    private double totalPrice;
    private Boolean isSubmitted;
    private List<ProductDto> products;
}
