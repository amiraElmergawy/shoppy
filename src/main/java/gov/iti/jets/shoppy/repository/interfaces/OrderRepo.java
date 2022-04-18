package gov.iti.jets.shoppy.repository.interfaces;

import gov.iti.jets.shoppy.repository.entity.OrderEntity;

import java.util.Optional;

public interface OrderRepo {
    Optional<OrderEntity> getUnSubmittedOrder(Integer customerId);
    boolean saveOrder(OrderEntity orderEntity);

}
