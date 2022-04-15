package gov.iti.jets.shoppy.service.interfaces;

import gov.iti.jets.shoppy.presentation.helpers.ShoppingCartViewHelper;
import gov.iti.jets.shoppy.service.dtos.OrderDto;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public interface ShoppingCartService {
    ShoppingCartViewHelper getShoppingCart(Integer customerId, EntityManager entityManager);

    ShoppingCartViewHelper initializeCustomerCart(Integer customerId, Integer productId, EntityManager entityManager);

    boolean increaseProductInShoppingCart(Integer productId, EntityManager entityManager);

    void decreaseProductInShoppingCart(Integer productId, EntityManager entityManager);

    void deleteProductFromShoppingCard(Integer productId, Integer productQuantity, EntityManager entityManager);

    ShoppingCartViewHelper addProductToShoppingCart(OrderDto orderDto, Integer productId, EntityManager entityManager);

//    ShoppingCartViewHelper mergeShoppingCart(Optional<OrderDto> , ShoppingCartViewHelper );
}
