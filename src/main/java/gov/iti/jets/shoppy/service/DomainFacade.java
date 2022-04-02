package gov.iti.jets.shoppy.service;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.service.dtos.UserDto;
import gov.iti.jets.shoppy.service.interfaces.AuthService;
import gov.iti.jets.shoppy.service.util.ServiceFactory;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class DomainFacade {
    private final AuthService authService = ServiceFactory.INSTANCE.getAuthService();
    private static DomainFacade domainFacade = new DomainFacade();
    private DomainFacade(){}

    public static DomainFacade getInstance(){
        return domainFacade;
    }
    public LoginViewHelper signin(String email, String password, EntityManager entityManager){
        return ServiceFactory.INSTANCE.getAuthService().signin(email, password, entityManager);
    }
}
