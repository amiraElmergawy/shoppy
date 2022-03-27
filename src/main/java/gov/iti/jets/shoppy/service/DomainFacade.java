package gov.iti.jets.shoppy.service;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.service.util.ServiceFactory;

public class DomainFacade {

    private static DomainFacade domainFacade = new DomainFacade();

    private DomainFacade(){}

    public static DomainFacade getInstance(){
        return domainFacade;
    }
    public LoginViewHelper signin(String email, String password){
        return ServiceFactory.INSTANCE.getAuthService().signin(email, password);
    }
}
