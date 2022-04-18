package gov.iti.jets.shoppy.repository.impls;

import gov.iti.jets.shoppy.repository.entity.ProductEntity;
import gov.iti.jets.shoppy.repository.interfaces.ProductRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

public class ProductRepoImp implements ProductRepo {
    private static int pageSize = 12;
    private final EntityManager entityManager;
    public ProductRepoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return entityManager.createQuery("from ProductEntity", ProductEntity.class).getResultList();
    }

    @Override
    public List<ProductEntity> getProducts(int pageNumber) {
        Query query = entityManager.createQuery("from ProductEntity", ProductEntity.class);
        query.setFirstResult((pageNumber-1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public Long getProductsCount() {
        return entityManager.createQuery("select count(*) from ProductEntity", Long.class)
                        .getSingleResult();
    }

    @Override
    public Optional<ProductEntity> findProductById(Integer id) {
        return Optional.of(entityManager.find(ProductEntity.class, id));
    }

    @Override
    public boolean updateProduct(ProductEntity productEntity) {
        System.out.println(productEntity);
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(productEntity);
            entityManager.getTransaction().commit();
            return true;
        } catch (IllegalArgumentException exception){
            return false;
        }
    }

    @Override
    public boolean addProduct(ProductEntity productEntity) {
        entityManager.getTransaction().begin();
        try {
          //should add image path here
            productEntity.setImgPath("1.jpg");
            entityManager.persist(productEntity);
            entityManager.getTransaction().commit();

            return  true;

        } catch (IllegalArgumentException exception){
            System.out.println("error");
            return  false;
        }
    }
    @Override
    public boolean updateProductById(ProductEntity productEntity, int id) {
        entityManager.getTransaction().begin();
        ProductEntity updatedProduct = entityManager.find(ProductEntity.class, id);
        try {
            updatedProduct.setProductName(productEntity.getProductName());
            updatedProduct.setProductDesc(updatedProduct.getProductDesc());
            updatedProduct.setPrice(productEntity.getPrice());
            updatedProduct.setStock(productEntity.getStock());
            updatedProduct.setCategory(productEntity.getCategory());
            updatedProduct.setImgPath("1.jpg");
            entityManager.merge(updatedProduct);
            entityManager.getTransaction().commit();
            return  true;

        } catch (IllegalArgumentException exception){
            System.out.println("error");
            return  false;
        }
    }

}
