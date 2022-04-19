package gov.iti.jets.shoppy.service.impls;

import gov.iti.jets.shoppy.presentation.helpers.ViewCustomerHelper;
import gov.iti.jets.shoppy.repository.interfaces.UserRepo;
import gov.iti.jets.shoppy.repository.util.RepoFactory;
import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import gov.iti.jets.shoppy.service.interfaces.UserService;
import gov.iti.jets.shoppy.service.mappers.AddressMapper;
import gov.iti.jets.shoppy.service.mappers.CustomerMapper;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final RepoFactory repoFactory = RepoFactory.INSTANCE;
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    private final AddressMapper addressMapper = AddressMapper.INSTANCE;
    @Override
    public ViewCustomerHelper getCustomers(int pageNumber, EntityManager entityManager) {
        UserRepo userRepo = repoFactory.getUserRepo(entityManager);
        List<CustomerDto> CustomerDtoList = userRepo.getCustomers(pageNumber).stream().map(
                UserEntity -> {
                    System.out.println(UserEntity);
                    CustomerDto customerDto = customerMapper.customerEntityToDto(UserEntity);
                    customerDto.setAddress(addressMapper.addressEntityToDto(UserEntity.getAddressEntity()));
                    System.out.println(customerDto);
                    return customerDto;
                }
        ).collect(Collectors.toList());
        Long allCustomerCount = userRepo.getCustomerCount();
        return ViewCustomerHelper.builder().customerDtoList(CustomerDtoList).allCustomerCount(allCustomerCount).build();
    }
    @Override
    public boolean updateCustomer(Integer customerId, double amount, EntityManager entityManager) {
        return repoFactory.getUserRepo(entityManager).updateCustomerCreditLimit(customerId, amount);
    }
}
