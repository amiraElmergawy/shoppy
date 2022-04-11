package gov.iti.jets.shoppy.service;

import gov.iti.jets.shoppy.presentation.helpers.HomeViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.service.interfaces.AuthService;
import gov.iti.jets.shoppy.service.interfaces.ProductService;
import gov.iti.jets.shoppy.service.util.ServiceFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DomainFacade {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shoppy");
    private final AuthService authService = ServiceFactory.INSTANCE.getAuthService();
    private final ProductService productService = ServiceFactory.INSTANCE.getProductService();

    private static DomainFacade domainFacade = new DomainFacade();
    private DomainFacade(){}

    public static DomainFacade getInstance(){
        return domainFacade;
    }

    public LoginViewHelper signIn(String email, String password){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return authService.signIn(email, password, entityManager);
    }

    public LoginViewHelper rememberMe(Long uid) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return authService.rememberMe(uid, entityManager);
    }
    public HomeViewHelper retrieveProducts(int pageNumber){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return productService.getProducts(pageNumber, entityManager);
    }

}
