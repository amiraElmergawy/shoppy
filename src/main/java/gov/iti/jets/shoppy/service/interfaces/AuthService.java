package gov.iti.jets.shoppy.service.interfaces;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import jakarta.persistence.EntityManager;

public interface AuthService {
    LoginViewHelper signIn(String email, String password, EntityManager entityManager);
    LoginViewHelper rememberMe(Long uid, EntityManager entityManager);
}
