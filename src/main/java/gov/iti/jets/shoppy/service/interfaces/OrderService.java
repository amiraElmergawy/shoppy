package gov.iti.jets.shoppy.service.interfaces;

import gov.iti.jets.shoppy.presentation.helpers.ShoppingCartViewHelper;
import jakarta.persistence.EntityManager;

public interface OrderService {
    ShoppingCartViewHelper getShoppingCart(Integer customerId, EntityManager entityManager);
}
