package gov.iti.jets.shoppy.service.impls;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.repository.entity.UserEntity;
import gov.iti.jets.shoppy.repository.util.RepoFactory;
import gov.iti.jets.shoppy.service.interfaces.AuthService;
import gov.iti.jets.shoppy.service.mappers.AdminMapper;
import gov.iti.jets.shoppy.service.util.HashManager;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class AuthServiceImpl implements AuthService {
    private final HashManager hashManager = HashManager.INSTANCE;

    @Override
    public LoginViewHelper signIn(String email, String password, EntityManager entityManager){
        LoginViewHelper loginViewHelper = new LoginViewHelper();
        String hashedPassword = hashManager.generateSecurePassword(password);
        Optional<? extends UserEntity> userEntityOptional = RepoFactory.INSTANCE.getUserRepo(entityManager).findUser(email, password);
        System.out.println(userEntityOptional);
        userEntityOptional.ifPresentOrElse(
                (value) -> {
                    System.out.println("Value is present, its: "+ value);
                    loginViewHelper.setUserDto(AdminMapper.INSTANCE.adminEntityToDto(value));
                },
                () -> {
                    System.out.println("Value is empty");
                    loginViewHelper.setError("Invalid email or password");
                });
        return loginViewHelper;
    }

}
