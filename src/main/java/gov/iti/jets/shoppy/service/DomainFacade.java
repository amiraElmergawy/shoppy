package gov.iti.jets.shoppy.service;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.repository.entity.UserEntity;
import gov.iti.jets.shoppy.repository.util.RepoFactory;
import gov.iti.jets.shoppy.service.interfaces.UserMapper;

import java.util.Optional;

public class DomainFacade {

    public LoginViewHelper sigin(String email, String password){
        LoginViewHelper loginViewHelper = LoginViewHelper.getInstance();
        Optional<UserEntity> userEntityResult = RepoFactory.INSTANCE.getUserRepo().findUser(email, password);
        userEntityResult.ifPresentOrElse(
                (value) -> {
                    System.out.println("Value is present, its: "+ value);
                    loginViewHelper.setUserDto(UserMapper.INSTANCE.userEntityToUserDto(value));
                    },
                () -> {
                    System.out.println("Value is empty");
                    loginViewHelper.setError("Invalid email or password");
                });

        return loginViewHelper;
    }
}
