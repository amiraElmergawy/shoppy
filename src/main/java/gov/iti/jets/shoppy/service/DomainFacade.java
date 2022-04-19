package gov.iti.jets.shoppy.service;

import gov.iti.jets.shoppy.presentation.helpers.*;
import gov.iti.jets.shoppy.presentation.helpers.HomeViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.ProfileViewHelper;
import gov.iti.jets.shoppy.service.dtos.AddressDto;
import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import gov.iti.jets.shoppy.presentation.helpers.ShoppingCartViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.ViewProductHelper;
import gov.iti.jets.shoppy.service.dtos.ProductDto;
import gov.iti.jets.shoppy.service.dtos.OrderDto;
import gov.iti.jets.shoppy.service.interfaces.AuthService;
import gov.iti.jets.shoppy.service.interfaces.OrderService;
import gov.iti.jets.shoppy.service.interfaces.ShoppingCartService;
import gov.iti.jets.shoppy.service.interfaces.ProductService;
import gov.iti.jets.shoppy.service.interfaces.ProfileService;
import gov.iti.jets.shoppy.service.interfaces.UserService;
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
        HomeViewHelper homeViewHelper =  productService.searchForProducts(entityManager, value);
        entityManager.close();
        return homeViewHelper;
    }
    public ProfileViewHelper customerProfile(int id){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        ProfileViewHelper profileViewHelper =  profileService.getUser(id,entityManager);
        entityManager.close();
        return profileViewHelper;
    }
    public boolean updateProfile(int id , CustomerDto customerDto, AddressDto addressDto){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        boolean updated = profileService.updateUser(id,customerDto,addressDto,entityManager);
        entityManager.close();
        return updated;
    }


    public ViewProductHelper getProductById(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ViewProductHelper viewProductHelper =  productService.getProductById(id,entityManager);
        entityManager.close();
        return viewProductHelper;
    }

    public ViewCustomerHelper retrieveCustomers(int pageNumber){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ViewCustomerHelper viewCustomerHelper =  userService.getCustomers(pageNumber, entityManager);
        entityManager.close();
        return viewCustomerHelper;
    }

    public ViewOrderHelper retrieveOrders(int pageNumber){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ViewOrderHelper viewOrderHelper = orderService.getOrders(pageNumber, entityManager);
        entityManager.close();
        return viewOrderHelper;
    }

    public ShoppingCartViewHelper loadShoppingCart(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ShoppingCartViewHelper shoppingCartViewHelper =  shoppingCartService.getShoppingCart(id, entityManager);
        entityManager.close();
        return shoppingCartViewHelper;
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
    public boolean addProduct(ProductDto productDto){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        boolean added = productService.addProduct(productDto, entityManager);
        entityManager.close();
        return added;
    }

    public boolean deleteProduct(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        boolean deleted = productService.deleteProduct(id,entityManager);
        entityManager.close();
        return deleted;
    }

    public ViewOrderHelper getOrderByCustomerId(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ViewOrderHelper viewOrderHelper = orderService.getOrdersByCustomerId(id , entityManager);
        entityManager.close();
        return viewOrderHelper;
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
            System.out.println("order saving result: "+ saved);
        }
        entityManager.close();
        return saved;
    }
}
