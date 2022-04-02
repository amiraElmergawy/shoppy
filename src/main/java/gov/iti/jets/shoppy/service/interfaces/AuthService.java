package gov.iti.jets.shoppy.service.interfaces;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.repository.entity.UserEntity;
import gov.iti.jets.shoppy.repository.util.RepoFactory;
import gov.iti.jets.shoppy.service.dtos.UserDto;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public interface AuthService {

    public LoginViewHelper signin(String email, String password, EntityManager entityManager);

}
