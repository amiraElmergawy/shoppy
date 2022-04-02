package gov.iti.jets.shoppy.repository.interfaces;

import gov.iti.jets.shoppy.repository.entity.UserEntity;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public interface UserRepo {

    Optional<UserEntity> findUserById(long id, EntityManager entityManager);
    Optional<UserEntity> findUser(String email, String password, EntityManager entityManager);
    boolean insertUser(UserEntity userEntity, EntityManager entityManager);
    boolean updateUser(UserEntity userEntity, EntityManager entityManager);


}
