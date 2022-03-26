package gov.iti.jets.shoppy.repository.impls;

import gov.iti.jets.shoppy.repository.entity.ProductEntity;
import gov.iti.jets.shoppy.repository.interfaces.ProductRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepoImp implements ProductRepo {
    private final List<ProductEntity> productEntityList = new ArrayList<>();
    private final static ProductRepoImp productImpl = new ProductRepoImp();
    private ProductRepoImp() {}
    public static ProductRepoImp getInstance() {
        return productImpl;
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return this.productEntityList;
    }

    @Override
    public Optional<ProductEntity> findProductById(long id) {
        return  productEntityList.stream().filter(productEntity -> productEntity.getId() == id).findFirst();
    }
}
