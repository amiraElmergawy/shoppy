package gov.iti.jets.shoppy.service.dtos;

import lombok.Data;

@Data
public class OrderProductDto {
    private ProductDto product;
    private Integer quantity;
    private double total;
    public double getTotal() {
        this.total = product.getPrice() * quantity;
        return total;
    }
}
