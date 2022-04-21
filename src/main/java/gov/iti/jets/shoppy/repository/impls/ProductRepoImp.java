package gov.iti.jets.shoppy.repository.impls;

import gov.iti.jets.shoppy.repository.entity.ProductEntity;
import gov.iti.jets.shoppy.repository.interfaces.ProductRepo;
import gov.iti.jets.shoppy.repository.util.ImageUtility;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

public class ProductRepoImp implements ProductRepo {
    private static int pageSize = 12;
    private ImageUtility imageUtility = ImageUtility.getInstance();
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
    public List<ProductEntity> searchProducts(String value) {
        String coulmnName = "productName";
        Query query = entityManager.createQuery("from ProductEntity where productName like :value", ProductEntity.class)
                .setParameter("value","%"+value+"%");
        query.setFirstResult(0);
        query.setMaxResults(12);
        System.out.println(query.getResultList());
        return query.getResultList();
    }

    @Override
    public Optional<ProductEntity> findProductById(Integer id) {
        return Optional.of(entityManager.find(ProductEntity.class, id));
    }

    @Override
    public boolean updateProduct(ProductEntity productEntity) {
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
    public boolean addProduct(ProductEntity productEntity, List<String> encodedImages) {
        boolean added = false;
        try {
            entityManager.getTransaction().begin();
            productEntity.setImgPath("product_id");
            entityManager.persist(productEntity);
            entityManager.getTransaction().commit();
            imageUtility.saveImages(productEntity.getId(), encodedImages);
            added = true;
        } catch (IllegalArgumentException exception){
            exception.printStackTrace();
        }
        return added;
    }

    @Override
    public boolean updateProductById(ProductEntity productEntity, List<String> encodedImages) {
        entityManager.getTransaction().begin();
        ProductEntity updatedProduct = entityManager.find(ProductEntity.class, productEntity.getId());
        try {
            updatedProduct.setProductName(productEntity.getProductName());
            updatedProduct.setProductDesc(updatedProduct.getProductDesc());
            updatedProduct.setPrice(productEntity.getPrice());
            updatedProduct.setStock(productEntity.getStock());
            updatedProduct.setCategory(productEntity.getCategory());
            updatedProduct.setImgPath("product_id");
            entityManager.merge(updatedProduct);
            entityManager.getTransaction().commit();
            imageUtility.saveImages(productEntity.getId(), encodedImages);
            return  true;
        } catch (IllegalArgumentException exception){
            exception.printStackTrace();
            return  false;
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        ProductEntity productEntity = entityManager.find(ProductEntity.class , id);
        try {
            if (productEntity != null){
                entityManager.getTransaction().begin();
                entityManager.remove(productEntity);
                entityManager.getTransaction().commit();

                return true;
            }
            return false;
        } catch (Exception e){
            return false;
        }

    }
}
