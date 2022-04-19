package gov.iti.jets.shoppy.service.interfaces;

import gov.iti.jets.shoppy.presentation.helpers.ViewCustomerHelper;
import jakarta.persistence.EntityManager;

public interface UserService {
    ViewCustomerHelper getCustomers(int pageNumber, EntityManager entityManager);
    boolean updateCustomer(Integer customerId, double amount, EntityManager entityManager);
}
