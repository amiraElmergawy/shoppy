package gov.iti.jets.shoppy.service;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.repository.entity.UserEntity;
import gov.iti.jets.shoppy.repository.util.RepoFactory;
import gov.iti.jets.shoppy.service.interfaces.UserMapper;

import java.util.Optional;

public class DomainFacade {

    private static DomainFacade domainFacade = new DomainFacade();
    private DomainFacade(){}

    public static DomainFacade getInstance(){
        return domainFacade ;
    }

    public LoginViewHelper signin(String email, String password){
        LoginViewHelper loginViewHelper = LoginViewHelper.getInstance();
        Optional<UserEntity> userEntityResult = RepoFactory.INSTANCE.getUserRepo().findUser(email, password);
        userEntityResult.ifPresentOrElse(
                (value) -> {
                    loginViewHelper.setUserDto(UserMapper.INSTANCE.userEntityToUserDto(value));
                    },
                () -> {
                    System.out.println("Value is empty");
                    loginViewHelper.setError("Invalid email or password");
                });

        return loginViewHelper;
    }
}
