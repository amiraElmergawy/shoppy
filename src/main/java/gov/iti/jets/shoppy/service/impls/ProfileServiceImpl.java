package gov.iti.jets.shoppy.service.impls;

import gov.iti.jets.shoppy.presentation.helpers.ProfileViewHelper;
import gov.iti.jets.shoppy.repository.entity.CustomerEntity;
import gov.iti.jets.shoppy.repository.entity.UserEntity;
import gov.iti.jets.shoppy.repository.util.RepoFactory;
import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import gov.iti.jets.shoppy.service.interfaces.ProfileService;
import gov.iti.jets.shoppy.service.mappers.CustomerMapper;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class ProfileServiceImpl implements ProfileService {
    private final RepoFactory repoFactory = RepoFactory.INSTANCE;
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;


    @Override
    public ProfileViewHelper getUser(long id, EntityManager entityManager) {
        ProfileViewHelper profileViewHelper=new ProfileViewHelper();
        Optional<? extends UserEntity> userEntityOptional = repoFactory.getUserRepo(entityManager).findUserById(id);
        if(userEntityOptional.isPresent()){
            CustomerEntity customerEntity= (CustomerEntity) userEntityOptional.get();
            System.out.println("from getUserMethod>>"+customerEntity);
            CustomerDto customerDto=customerMapper.customerEntityToDto(customerEntity);
            profileViewHelper.setCustomerDto(customerDto);
        }
        else {
            profileViewHelper.setError("Fail");
        }

        return  profileViewHelper;
    }

    @Override
    public boolean updateUser(CustomerDto customerDto, EntityManager entityManager) {
        CustomerEntity customerEntity=CustomerMapper.INSTANCE.customerDtoToEntity(customerDto);
        boolean updateUserResult = repoFactory.getUserRepo(entityManager).updateUser(customerEntity);

        return updateUserResult;
    }

}
