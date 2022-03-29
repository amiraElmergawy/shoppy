package gov.iti.jets.shoppy.service.impls;

import gov.iti.jets.shoppy.repository.entity.UserEntity;
import gov.iti.jets.shoppy.repository.util.RepoFactory;
import gov.iti.jets.shoppy.service.dtos.UserDto;
import gov.iti.jets.shoppy.service.interfaces.AuthService;
import gov.iti.jets.shoppy.service.util.HashManager;
import gov.iti.jets.shoppy.service.mappers.UserMapper;

import java.util.Optional;

public class AuthServiceImpl implements AuthService {
    private final HashManager hashManager = HashManager.INSTANCE;
    @Override
    public Optional<UserDto> signin(String email, String password){
        String hashedPassword = HashManager.INSTANCE.generateSecurePassword(password);
        Optional<UserEntity> userEntityOptional = RepoFactory.INSTANCE.getUserRepo().findUser(email, hashedPassword);
        System.out.println(userEntityOptional);
        Optional<UserDto> userDtoOptional = Optional.empty();
        if(userEntityOptional.isPresent())
            userDtoOptional = Optional.of(UserMapper.INSTANCE.UserEntityToDto(userEntityOptional.get()));

        return userDtoOptional;
    }

}
