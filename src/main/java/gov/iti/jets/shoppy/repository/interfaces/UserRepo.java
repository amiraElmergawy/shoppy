package gov.iti.jets.shoppy.repository.interfaces;

import gov.iti.jets.shoppy.repository.entity.CustomerEntity;
import gov.iti.jets.shoppy.repository.entity.ProductEntity;
import gov.iti.jets.shoppy.repository.entity.UserEntity;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public interface UserRepo {

    Optional<UserEntity> findUserById(long id);
    Optional<? extends UserEntity> findUser(String email, String password);
    boolean insertUser(UserEntity userEntity);
    boolean updateUser(UserEntity userEntity);
    List<CustomerEntity> getCustomers(int pageNumber);
    Long getCustomerCount();
}
