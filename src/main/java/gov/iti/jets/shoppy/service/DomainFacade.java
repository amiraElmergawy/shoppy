package gov.iti.jets.shoppy.service;

import gov.iti.jets.shoppy.presentation.helpers.HomeViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.ShoppingCartViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.ViewProductHelper;
import gov.iti.jets.shoppy.service.dtos.OrderDto;
import gov.iti.jets.shoppy.service.interfaces.AuthService;
import gov.iti.jets.shoppy.service.interfaces.ShoppingCartService;
import gov.iti.jets.shoppy.service.interfaces.ProductService;
import gov.iti.jets.shoppy.service.interfaces.UserService;
import gov.iti.jets.shoppy.service.mappers.CustomerMapper;
import gov.iti.jets.shoppy.service.util.ServiceFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Optional;

public class DomainFacade {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shoppy");
    private final AuthService authService = ServiceFactory.INSTANCE.getAuthService();
    private final ProductService productService = ServiceFactory.INSTANCE.getProductService();
    private final ShoppingCartService shoppingCartService = ServiceFactory.INSTANCE.getShoppingCartService();
    private final UserService userService = ServiceFactory.INSTANCE.getUserService();

    private static final DomainFacade domainFacade = new DomainFacade();
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

    public ViewProductHelper getProductById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return productService.getProductById(id,entityManager);
    }

    public ShoppingCartViewHelper loadShoppingCart(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return shoppingCartService.getShoppingCart(id, entityManager);
    }

    public ShoppingCartViewHelper addProductToCart(Integer customerId, Integer productId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ShoppingCartViewHelper shoppingCartViewHelper = shoppingCartService.getShoppingCart(customerId, entityManager);
        if(shoppingCartViewHelper.getOrderDto() == null)
            shoppingCartViewHelper.setOrderDto(shoppingCartService.getNewShoppingCart(customerId, entityManager));
        return shoppingCartService.addProductToShoppingCart(shoppingCartViewHelper.getOrderDto(), productId, entityManager);
    }

    public ShoppingCartViewHelper addProductToCart(OrderDto orderDto, Integer productId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return shoppingCartService.addProductToShoppingCart(orderDto, productId, entityManager);
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

    public boolean saveShoppingCart(Optional<OrderDto> orderDtoOptional) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        boolean saved = shoppingCartService.saveShoppingCart(orderDtoOptional, entityManager);
        entityManager.close();
        System.out.println("domain facade save: " + saved);
        return saved;
    }

    public boolean saveOrder(Optional<OrderDto> orderDtoOptional) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        boolean saved = false;
        if (orderDtoOptional.isPresent() && (orderDtoOptional.get().getCustomer().getCreditLimit() >= orderDtoOptional.get().getTotalPrice())){
            var customer= orderDtoOptional.get().getCustomer();
            System.out.println(customer);
            customer.setCreditLimit(customer.getCreditLimit() - orderDtoOptional.get().getTotalPrice());
            System.out.println(customer);
            userService.updateCustomer((int) customer.getId(), customer.getCreditLimit(), entityManager);
            saved = shoppingCartService.saveOrder(orderDtoOptional, entityManager);
        }
        entityManager.close();
        return saved;
    }
}
