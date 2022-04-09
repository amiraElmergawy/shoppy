package gov.iti.jets.shoppy.service.interfaces;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import jakarta.persistence.EntityManager;

public interface AuthService {

    public LoginViewHelper signIn(String email, String password, EntityManager entityManager);

}
