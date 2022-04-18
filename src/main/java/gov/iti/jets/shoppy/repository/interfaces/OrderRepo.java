package gov.iti.jets.shoppy.repository.interfaces;

import gov.iti.jets.shoppy.repository.entity.OrderEntity;
import gov.iti.jets.shoppy.repository.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface OrderRepo {
    Optional<OrderEntity> getUnSubmittedOrder(Integer customerId);
    Long getOrdersCount();
    List<OrderEntity> getOrders(int pageNumber);
}
