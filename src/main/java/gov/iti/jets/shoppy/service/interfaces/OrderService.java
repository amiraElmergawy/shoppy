package gov.iti.jets.shoppy.service.interfaces;

import gov.iti.jets.shoppy.presentation.helpers.HomeViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.ViewOrderHelper;
import jakarta.persistence.EntityManager;

public interface OrderService {
    ViewOrderHelper getOrders(int pageNumber, EntityManager entityManager);
    ViewOrderHelper getOrdersByCustomerId(int id , EntityManager entityManager);
}
