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
    public List<ProductEntity> searchProducts(String value) {

        String coulmnName = "productName";
        Query query = entityManager.createQuery("from ProductEntity where productName like :value", ProductEntity.class)
                .setParameter("value","%"+value+"%");
        query.setFirstResult(0);
        query.setMaxResults(11);
        System.out.println(query.getResultList());
        return query.getResultList();
    }

    @Override
    public Optional<ProductEntity> findProductById(Integer id) {
        return Optional.of(entityManager.find(ProductEntity.class, id));
    }

//    @Override
//    public Long getSearchProductsCount(String key, String value) {
//        System.out.println(entityManager.createQuery("select count(*) from ProductEntity where productName like :value", Long.class)
//                .setParameter("value","%"+value+"%")
//                .getSingleResult());
//        //String coulmnName = "product_name";
//        return entityManager.createQuery("select count(*) from ProductEntity where productName like :value", Long.class)
//                .setParameter("value","%"+value+"%")
//                .getSingleResult();
//
//    }

}
