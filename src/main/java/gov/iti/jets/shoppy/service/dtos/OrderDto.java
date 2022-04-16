package gov.iti.jets.shoppy.service.dtos;


import gov.iti.jets.shoppy.repository.entity.CustomerEntity;
import gov.iti.jets.shoppy.repository.entity.OrderProductsEntity;
import gov.iti.jets.shoppy.repository.entity.ProductEntity;
import lombok.Data;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class OrderDto {
    private Integer id;
    private Date createdAt;
    private double totalPrice;
    private List<ProductDto> products;
    private CustomerDto customer;
    private Set<OrderProductsEntity> orderProducts;
}
