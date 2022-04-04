package gov.iti.jets.shoppy.service.util;

import gov.iti.jets.shoppy.service.impls.AuthServiceImpl;
import gov.iti.jets.shoppy.service.interfaces.AuthService;

public enum ServiceFactory {
    INSTANCE;

    private AuthService authService = new AuthServiceImpl();

    public AuthService getAuthService() {
        return authService;
    }
}
