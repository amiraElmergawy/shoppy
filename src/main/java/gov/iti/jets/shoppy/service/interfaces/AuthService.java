package gov.iti.jets.shoppy.service.interfaces;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import jakarta.persistence.EntityManager;

public interface AuthService {
    LoginViewHelper signIn(String email, String password, EntityManager entityManager);
    LoginViewHelper rememberMe(Long uid, EntityManager entityManager);
    boolean signUp(CustomerDto customerDto,EntityManager entityManager);

}
