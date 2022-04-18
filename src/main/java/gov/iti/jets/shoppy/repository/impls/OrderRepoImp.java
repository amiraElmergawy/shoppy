package gov.iti.jets.shoppy.repository.impls;

import gov.iti.jets.shoppy.repository.entity.OrderEntity;
import gov.iti.jets.shoppy.repository.entity.OrderProductsEntity;
import gov.iti.jets.shoppy.repository.interfaces.OrderRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.util.Optional;
import java.util.Set;

public class OrderRepoImp implements OrderRepo {
    private final EntityManager entityManager;
    public OrderRepoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public Optional<OrderEntity> getUnSubmittedOrder(Integer customerId) {
        Optional<OrderEntity> optional = Optional.empty();
        try{
            optional = Optional.of(entityManager.createQuery("from OrderEntity where customer.id = :customerId and isSubmitted = false", OrderEntity.class)
                    .setParameter("customerId", customerId).getSingleResult());
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return optional;
    }

    @Override
    public boolean saveOrder(OrderEntity orderEntity) {
        Set<OrderProductsEntity> orderProductsEntityList = orderEntity.getOrderProducts();
        orderEntity.setOrderProducts(null);
        try {
            entityManager.getTransaction().begin();
            OrderEntity order = entityManager.merge(orderEntity);
            orderProductsEntityList.forEach(orderProductsEntity -> {
                orderProductsEntity.getId().setOrderId(order.getId());
                entityManager.merge(orderProductsEntity);
            });
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
    }

}
