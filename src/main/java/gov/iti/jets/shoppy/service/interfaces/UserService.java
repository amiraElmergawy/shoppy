package gov.iti.jets.shoppy.service.interfaces;

import gov.iti.jets.shoppy.presentation.helpers.HomeViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.ViewCustomerHelper;
import jakarta.persistence.EntityManager;

public interface UserService {
    ViewCustomerHelper getCustomers(int pageNumber, EntityManager entityManager);
}
