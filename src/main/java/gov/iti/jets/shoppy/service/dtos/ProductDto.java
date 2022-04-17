package gov.iti.jets.shoppy.service.dtos;

import gov.iti.jets.shoppy.repository.entity.ProductCategory;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductDto {
    private Integer id;
    private String productName;
    private String productDesc;
    private double price;
    private ProductCategory category;
    private Integer stock;
    private List<String> imagesPaths;

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", stock=" + stock +
                ", imagesPaths=" + imagesPaths +
                '}';
    }
}
