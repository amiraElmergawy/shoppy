package gov.iti.jets.shoppy.service.interfaces;

import gov.iti.jets.shoppy.presentation.helpers.ShoppingCartViewHelper;
import jakarta.persistence.EntityManager;

public interface ShoppingCartService {
    ShoppingCartViewHelper getShoppingCart(Integer customerId, EntityManager entityManager);
    ShoppingCartViewHelper initializeCustomerCart(Integer customerId, Integer productId, EntityManager entityManager);
    boolean increaseProductInShoppingCart(Integer productId, EntityManager entityManager);
    void decreaseProductInShoppingCart(Integer productId, EntityManager entityManager);
    void deleteProductFromShoppingCard(Integer productId, Integer productQuantity, EntityManager entityManager);
}
