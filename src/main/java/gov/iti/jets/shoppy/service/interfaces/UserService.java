package gov.iti.jets.shoppy.service.interfaces;

import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import gov.iti.jets.shoppy.service.dtos.OrderDto;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public interface UserService {
    public boolean updateCustomer(Integer customerId, double amount, EntityManager entityManager);
}
