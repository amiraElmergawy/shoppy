package gov.iti.jets.shoppy.service.impls;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.repository.entity.AdminEntity;
import gov.iti.jets.shoppy.repository.entity.CustomerEntity;
import gov.iti.jets.shoppy.repository.entity.UserEntity;
import gov.iti.jets.shoppy.repository.util.RepoFactory;
import gov.iti.jets.shoppy.service.dtos.Role;
import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import gov.iti.jets.shoppy.service.interfaces.AuthService;
import gov.iti.jets.shoppy.service.mappers.CustomerMapper;
import gov.iti.jets.shoppy.service.util.HashManager;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class AuthServiceImpl implements AuthService {
    private final HashManager hashManager = HashManager.INSTANCE;
    private final RepoFactory repoFactory = RepoFactory.INSTANCE;

    @Override
    public LoginViewHelper signIn(String email, String password, EntityManager entityManager){
        LoginViewHelper loginViewHelper = new LoginViewHelper();
        String hashedPassword = hashManager.generateSecurePassword(password);
        Optional<? extends UserEntity> userEntityOptional = repoFactory.getUserRepo(entityManager).findUser(email, password);
        if(userEntityOptional.isPresent())
            loginViewHelper = buildLoginViewHelper(userEntityOptional.get());
        else
            loginViewHelper.setError("Invalid email or password");
        return loginViewHelper;
    }

    @Override
    public LoginViewHelper rememberMe(Long uid, EntityManager entityManager) {
        LoginViewHelper loginViewHelper = new LoginViewHelper();
        Optional<? extends UserEntity> userEntityOptional = repoFactory.getUserRepo(entityManager).findUserById(uid);
        if(userEntityOptional.isPresent())
            loginViewHelper = buildLoginViewHelper(userEntityOptional.get());
        else
            loginViewHelper.setError("Invalid email or password");
        return loginViewHelper;
    }

    private LoginViewHelper buildLoginViewHelper(UserEntity userEntity) {
//     String entityType = value.getClass().getName().substring(value.getClass().getName().lastIndexOf(".")+1);
//     System.out.println("Value is present, its: "+ value);
//     if(entityType.equals("AdminEntity")){
//        loginViewHelper.setAdminDto(AdminMapper.INSTANCE.adminEntityToDto((AdminEntity) value));
//     }else {
//        loginViewHelper.setCustomerDto(CustomerMapper.INSTANCE.customerEntityToDto((CustomerEntity) value));
//     }
        LoginViewHelper loginViewHelper = new LoginViewHelper();
        loginViewHelper.setEmail(userEntity.getEmail());
        loginViewHelper.setId(userEntity.getId());
        if(userEntity instanceof AdminEntity)
            loginViewHelper.setRole(Role.ADMIN);
        else
            loginViewHelper.setRole(Role.CUSTOMER);
        return loginViewHelper;
    }

    @Override
    public boolean signUp(CustomerDto customerDto, EntityManager entityManager) {
        CustomerEntity customerEntity= CustomerMapper.INSTANCE.customerDtoToEntity(customerDto);
        boolean insertUserResult = RepoFactory.INSTANCE.getUserRepo(entityManager).insertUser(customerEntity);
        return  insertUserResult;
    }
}
