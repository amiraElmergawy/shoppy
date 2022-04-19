package gov.iti.jets.shoppy.service.impls;

import gov.iti.jets.shoppy.presentation.helpers.ProfileViewHelper;
import gov.iti.jets.shoppy.repository.entity.AddressEntity;
import gov.iti.jets.shoppy.repository.entity.CustomerEntity;
import gov.iti.jets.shoppy.repository.entity.UserEntity;
import gov.iti.jets.shoppy.repository.util.RepoFactory;
import gov.iti.jets.shoppy.service.dtos.AddressDto;
import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import gov.iti.jets.shoppy.service.interfaces.ProfileService;
import gov.iti.jets.shoppy.service.mappers.AddressMapper;
import gov.iti.jets.shoppy.service.mappers.CustomerMapper;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class ProfileServiceImpl implements ProfileService {
    private final RepoFactory repoFactory = RepoFactory.INSTANCE;
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    private final AddressMapper addressMapper = AddressMapper.INSTANCE;


    @Override
    public ProfileViewHelper getUser(long id, EntityManager entityManager) {
        ProfileViewHelper profileViewHelper=new ProfileViewHelper();
        Optional<? extends UserEntity> userEntityOptional = repoFactory.getUserRepo(entityManager).findUserById(id);
        if(userEntityOptional.isPresent()){
            CustomerEntity customerEntity = (CustomerEntity) userEntityOptional.get();
            CustomerDto customerDto = customerMapper.customerEntityToDto(customerEntity);
            customerDto.setAddress(addressMapper.addressEntityToDto(customerEntity.getAddressEntity()));
            System.out.println("profileViewHepler" + customerDto);
            profileViewHelper.setCustomerDto(customerDto);
        }
        else {
            profileViewHelper.setError("Fail");
        }

        return  profileViewHelper;
    }

    @Override
    public boolean updateUser(int id ,CustomerDto customerDto,AddressDto addressDto ,EntityManager entityManager) {
        CustomerEntity customerEntity = CustomerMapper.INSTANCE.customerDtoToEntity(customerDto);
        AddressEntity addressEntity=AddressMapper.INSTANCE.addressDtoToEntity(addressDto);
        customerEntity.setAddressEntity(addressMapper.addressDtoToEntity(customerDto.getAddress()));
        boolean updateUserResult = repoFactory.getUserRepo(entityManager).updateUser(id,customerEntity,addressEntity);
        return updateUserResult;
    }

}
