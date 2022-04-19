package gov.iti.jets.shoppy.service.util;

import gov.iti.jets.shoppy.service.impls.AuthServiceImpl;
import gov.iti.jets.shoppy.service.impls.OrderServiceImpl;
import gov.iti.jets.shoppy.service.impls.ShoppingCartServiceImpl;
import gov.iti.jets.shoppy.service.impls.ProductServiceImpl;
import gov.iti.jets.shoppy.service.impls.ProfileServiceImpl;
import gov.iti.jets.shoppy.service.impls.UserServiceImpl;
import gov.iti.jets.shoppy.service.interfaces.AuthService;
import gov.iti.jets.shoppy.service.interfaces.OrderService;
import gov.iti.jets.shoppy.service.interfaces.ProductService;
import gov.iti.jets.shoppy.service.interfaces.ProfileService;
import gov.iti.jets.shoppy.service.interfaces.UserService;

public enum ServiceFactory {
    INSTANCE;

    private AuthService authService = new AuthServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    private ProfileService profileService = new ProfileServiceImpl();
    private UserService userService = new UserServiceImpl();
    private OrderService orderService = new OrderServiceImpl();
    private ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

    public AuthService getAuthService() {
        return authService;
    }
    public ProductService getProductService() {return productService;}
    public ProfileService getProfileService(){return profileService;}

    public UserService getUserService(){return userService;}
    public OrderService getOrderService(){return orderService;}
    public ShoppingCartService getShoppingCartService() {return shoppingCartService;}
}
