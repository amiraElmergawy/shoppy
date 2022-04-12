package gov.iti.jets.shoppy.service.util;

import gov.iti.jets.shoppy.service.impls.AuthServiceImpl;
import gov.iti.jets.shoppy.service.impls.ProductServiceImpl;
import gov.iti.jets.shoppy.service.impls.ProfileServiceImpl;
import gov.iti.jets.shoppy.service.interfaces.AuthService;
import gov.iti.jets.shoppy.service.interfaces.ProductService;
import gov.iti.jets.shoppy.service.interfaces.ProfileService;

public enum ServiceFactory {
    INSTANCE;

    private AuthService authService = new AuthServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    private ProfileService profileService = new ProfileServiceImpl();

    public AuthService getAuthService() {
        return authService;
    }
    public ProductService getProductService() {return productService;}
    public ProfileService getProfileService(){return profileService;}

}
