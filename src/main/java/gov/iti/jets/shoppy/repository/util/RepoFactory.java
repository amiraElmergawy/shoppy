package gov.iti.jets.shoppy.repository.util;

import gov.iti.jets.shoppy.repository.impls.ProductRepoImp;
import gov.iti.jets.shoppy.repository.impls.UserRepoImpl;
import gov.iti.jets.shoppy.repository.interfaces.ProductRepo;
import gov.iti.jets.shoppy.repository.interfaces.UserRepo;
import jakarta.persistence.EntityManager;

public enum RepoFactory {
    INSTANCE;
//    private final UserRepo userRepo = UserRepoImpl.getInstance();
    private final ProductRepo productRepo = ProductRepoImp.getInstance();
    public UserRepo getUserRepo(EntityManager entityManager) {
        return new UserRepoImpl(entityManager);
    }

    public ProductRepo getProductRepo() {
        return productRepo;
    }

}
