package gov.iti.jets.shoppy.service;

import gov.iti.jets.shoppy.presentation.helpers.*;
import gov.iti.jets.shoppy.presentation.helpers.HomeViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.ProfileViewHelper;
import gov.iti.jets.shoppy.service.dtos.AddressDto;
import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import gov.iti.jets.shoppy.presentation.helpers.ShoppingCartViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.ViewProductHelper;
import gov.iti.jets.shoppy.service.interfaces.AuthService;
import gov.iti.jets.shoppy.service.interfaces.OrderService;
import gov.iti.jets.shoppy.service.interfaces.ShoppingCartService;
import gov.iti.jets.shoppy.service.interfaces.ProductService;
import gov.iti.jets.shoppy.service.interfaces.ProfileService;
import gov.iti.jets.shoppy.service.interfaces.UserService;
import gov.iti.jets.shoppy.service.util.ServiceFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DomainFacade {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shoppy");
    private final AuthService authService = ServiceFactory.INSTANCE.getAuthService();
    private final ProductService productService = ServiceFactory.INSTANCE.getProductService();
    private  final ProfileService profileService=ServiceFactory.INSTANCE.getProfileService();

    private final UserService userService = ServiceFactory.INSTANCE.getUserService();
    private final OrderService orderService = ServiceFactory.INSTANCE.getOrderService();
    private final ShoppingCartService shoppingCartService = ServiceFactory.INSTANCE.getShoppingCartService();

    private static final DomainFacade domainFacade = new DomainFacade();
    private DomainFacade(){}

    public static DomainFacade getInstance(){
        return domainFacade;
    }

    public LoginViewHelper signIn(String email, String password){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        LoginViewHelper loginViewHelper = authService.signIn(email, password, entityManager);
        entityManager.close();
        return loginViewHelper;
    }

    public LoginViewHelper rememberMe(Long uid) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        LoginViewHelper loginViewHelper = authService.rememberMe(uid, entityManager);
        entityManager.close();
        return loginViewHelper;
    }

    public boolean signUp(CustomerDto customerDto){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        boolean signUpResult = authService.signUp(customerDto, entityManager);
        entityManager.close();
        return signUpResult;
    }

    public HomeViewHelper retrieveProducts(int pageNumber){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        HomeViewHelper homeViewHelper = productService.getProducts(pageNumber, entityManager);
        entityManager.close();
        return homeViewHelper;
    }
    public HomeViewHelper searchForProducts(String value){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return  productService.searchForProducts(entityManager, value);

    }
    public ProfileViewHelper customerProfile(int id){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        return profileService.getUser(id,entityManager);
    }
    public boolean updateProfile(int id , CustomerDto customerDto, AddressDto addressDto){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        return profileService.updateUser(id,customerDto,addressDto,entityManager);
    }


    public ViewProductHelper getProductById(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return productService.getProductById(id,entityManager);
    }

    public ViewCustomerHelper retrieveCustomers(int pageNumber){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return userService.getCustomers(pageNumber, entityManager);
    }

    public ViewOrderHelper retrieveOrders(int pageNumber){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return orderService.getOrders(pageNumber, entityManager);
    }

    public ShoppingCartViewHelper getShoppingCart(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return shoppingCartService.getShoppingCart(id, entityManager);
    }

    public ShoppingCartViewHelper initializeCustomerCart(Integer customerId,Integer productId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return shoppingCartService.initializeCustomerCart(customerId, productId, entityManager);
    }

    public boolean increaseProductInShoppingCart(int productId){
       EntityManager entityManager = entityManagerFactory.createEntityManager();
        boolean increaseQuantityResult = shoppingCartService.increaseProductInShoppingCart(productId, entityManager);
        entityManager.close();
        return increaseQuantityResult;
    }

    public void decreaseProductInShoppingCart(int productId){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        shoppingCartService.decreaseProductInShoppingCart(productId, entityManager);
        entityManager.close();
    }

    public void deleteProductFromShoppingCart(int productId, int currentProductQuantity){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        shoppingCartService.deleteProductFromShoppingCard(productId, currentProductQuantity, entityManager);
        entityManager.close();
    }
}
