package gov.iti.jets.shoppy.service.util;

import gov.iti.jets.shoppy.service.impls.AuthServiceImpl;
import gov.iti.jets.shoppy.service.impls.OrderServiceImpl;
import gov.iti.jets.shoppy.service.impls.ProductServiceImpl;
import gov.iti.jets.shoppy.service.interfaces.AuthService;
import gov.iti.jets.shoppy.service.interfaces.OrderService;
import gov.iti.jets.shoppy.service.interfaces.ProductService;

public enum ServiceFactory {
    INSTANCE;

    private AuthService authService = new AuthServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    private OrderService orderService = new OrderServiceImpl();

    public AuthService getAuthService() {
        return authService;
    }
    public ProductService getProductService() {return productService;}
    public OrderService getOrderService() {return orderService;}
}
