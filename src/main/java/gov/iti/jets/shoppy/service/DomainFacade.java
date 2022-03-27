package gov.iti.jets.shoppy.service;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.service.util.ServiceFactory;

public class DomainFacade {

    public LoginViewHelper signin(String email, String password){
        return ServiceFactory.INSTANCE.getAuthService().signin(email, password);
    }
}
