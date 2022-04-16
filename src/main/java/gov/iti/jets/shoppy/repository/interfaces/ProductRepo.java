package gov.iti.jets.shoppy.repository.interfaces;

import gov.iti.jets.shoppy.repository.entity.ProductEntity;
import java.util.List;
import java.util.Optional;

public interface ProductRepo {
    List<ProductEntity> getAllProducts();
    List<ProductEntity> getProducts(int pageNumber);
    List<ProductEntity> searchProducts(String value);
    Long getProductsCount();
    Optional<ProductEntity> findProductById(Integer id);

}
