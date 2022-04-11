package gov.iti.jets.shoppy.service.interfaces;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import jakarta.persistence.EntityManager;

public interface AuthService {

    public LoginViewHelper signIn(String email, String password, EntityManager entityManager);
    public boolean signUp(CustomerDto customerDto,EntityManager entityManager);

}
