package gov.iti.jets.shoppy.service.impls;

import gov.iti.jets.shoppy.repository.util.RepoFactory;
import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import gov.iti.jets.shoppy.service.interfaces.UserService;
import gov.iti.jets.shoppy.service.mappers.CustomerMapper;
import jakarta.persistence.EntityManager;

public class UserServiceImpl implements UserService {
    private final RepoFactory repoFactory = RepoFactory.INSTANCE;
    @Override
    public boolean updateCustomer(Integer customerId, double amount, EntityManager entityManager) {
        return repoFactory.getUserRepo(entityManager).updateCustomerCreditLimit(customerId, amount);
    }
}
