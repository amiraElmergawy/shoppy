package gov.iti.jets.shoppy.repository.impls;

import gov.iti.jets.shoppy.repository.entity.ProductEntity;
import gov.iti.jets.shoppy.repository.interfaces.ProductRepo;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class ProductRepoImp implements ProductRepo {
    private final EntityManager entityManager;
    public ProductRepoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return entityManager.createQuery("from ProductEntity", ProductEntity.class).getResultList();
    }

    @Override
    public Optional<ProductEntity> findProductById(Integer id) {
        return Optional.of(entityManager.find(ProductEntity.class, id));
    }

}
