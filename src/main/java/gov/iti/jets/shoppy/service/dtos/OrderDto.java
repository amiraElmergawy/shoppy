package gov.iti.jets.shoppy.service.dtos;


import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class OrderDto {
    private Integer id;
    private Date createdAt;
    private double totalPrice;
    private List<ProductDto> products;
}
