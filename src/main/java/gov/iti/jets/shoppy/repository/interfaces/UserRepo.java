package gov.iti.jets.shoppy.repository.interfaces;

import gov.iti.jets.shoppy.repository.entity.UserEntity;

import java.util.Optional;

public interface UserRepo {
    Optional<UserEntity> getUserById(long id);
    Optional<UserEntity> getUserByEmail(String email);
    boolean insertUser(UserEntity userEntity);
    boolean updateUser(UserEntity userEntity);
}
