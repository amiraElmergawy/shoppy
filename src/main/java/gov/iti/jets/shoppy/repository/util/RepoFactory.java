package gov.iti.jets.shoppy.repository.util;

import gov.iti.jets.shoppy.repository.impls.OrderRepoImp;
import gov.iti.jets.shoppy.repository.impls.ProductRepoImp;
import gov.iti.jets.shoppy.repository.impls.UserRepoImpl;
import gov.iti.jets.shoppy.repository.interfaces.OrderRepo;
import gov.iti.jets.shoppy.repository.interfaces.ProductRepo;
import gov.iti.jets.shoppy.repository.interfaces.UserRepo;
import jakarta.persistence.EntityManager;

public enum RepoFactory {
    INSTANCE;
    public UserRepo getUserRepo(EntityManager entityManager) {
        return new UserRepoImpl(entityManager);
    }

    public ProductRepo getProductRepo(EntityManager entityManager) {
        return new ProductRepoImp(entityManager);
    }

    public OrderRepo getOrderRepo(EntityManager entityManager) {return  new OrderRepoImp(entityManager);}

}
