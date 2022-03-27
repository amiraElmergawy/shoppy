package gov.iti.jets.shoppy.repository.interfaces;

import gov.iti.jets.shoppy.repository.entity.UserEntity;
import java.util.Optional;

public interface UserRepo {
    Optional<UserEntity> findUserById(long id);
    Optional<UserEntity> findUser(String email, String password);
    boolean insertUser(UserEntity userEntity);
    boolean updateUser(UserEntity userEntity);
}
