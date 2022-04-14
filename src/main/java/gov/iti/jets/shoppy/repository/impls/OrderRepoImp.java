package gov.iti.jets.shoppy.repository.impls;

import gov.iti.jets.shoppy.repository.entity.OrderEntity;
import gov.iti.jets.shoppy.repository.interfaces.OrderRepo;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class OrderRepoImp implements OrderRepo {
    private final EntityManager entityManager;
    public OrderRepoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public Optional<OrderEntity> getUnSubmittedOrder(Integer customerId) {
        return Optional.of(entityManager.createQuery("from OrderEntity where customer.id = :customerId and isSubmitted = false", OrderEntity.class)
                .setParameter("customerId", customerId).getSingleResult());
    }
}
