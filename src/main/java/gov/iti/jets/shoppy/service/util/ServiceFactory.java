package gov.iti.jets.shoppy.service.util;

import gov.iti.jets.shoppy.service.impls.AuthServiceImpl;
import gov.iti.jets.shoppy.service.impls.ProductServiceImpl;
import gov.iti.jets.shoppy.service.impls.UserServiceImpl;
import gov.iti.jets.shoppy.service.interfaces.AuthService;
import gov.iti.jets.shoppy.service.interfaces.ProductService;
import gov.iti.jets.shoppy.service.interfaces.UserService;

public enum ServiceFactory {
    INSTANCE;

    private AuthService authService = new AuthServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    private UserService userService = new UserServiceImpl();

    public AuthService getAuthService() {
        return authService;
    }
    public ProductService getProductService() {return productService;}
    public UserService getUserService(){return userService;}
}
