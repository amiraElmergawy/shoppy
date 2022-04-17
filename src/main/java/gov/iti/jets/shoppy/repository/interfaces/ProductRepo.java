package gov.iti.jets.shoppy.repository.interfaces;

import gov.iti.jets.shoppy.repository.entity.ProductEntity;
import java.util.List;
import java.util.Optional;

public interface ProductRepo {
    List<ProductEntity> getAllProducts();
    List<ProductEntity> getProducts(int pageNumber);
    Long getProductsCount();
    Optional<ProductEntity> findProductById(Integer id);
    boolean updateProduct(ProductEntity productEntity);
    boolean addProduct(ProductEntity productEntity);

}
