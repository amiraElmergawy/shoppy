package gov.iti.jets.shoppy.repository.interfaces;

import gov.iti.jets.shoppy.repository.entity.AddressEntity;
import gov.iti.jets.shoppy.repository.entity.CustomerEntity;
import gov.iti.jets.shoppy.repository.entity.UserEntity;
import java.util.List;
import java.util.Optional;

public interface UserRepo {

    Optional<UserEntity> findUserById(long id);
    Optional<? extends UserEntity> findUser(String email, String password);
    boolean insertUser(UserEntity userEntity);
    boolean updateUser(int id , CustomerEntity customer, AddressEntity addressEntity);
    List<CustomerEntity> getCustomers(int pageNumber);
    Long getCustomerCount();
    boolean updateCustomerCreditLimit(Integer customerId, double amount);

}
