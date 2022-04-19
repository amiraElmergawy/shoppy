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
        //check for order
        //if it already exists delete all its current products and add the products in the session only update the order updates
        //if not add the order then add its products
        Set<OrderProductsEntity> orderProductsEntityList = orderEntity.getOrderProducts();
        try {
            entityManager.getTransaction().begin();
            if (orderEntity.getId() != null && orderEntity.getOrderProducts() != null && orderEntity.getOrderProducts().size() != 0){
                var currentOrderProducts = entityManager.createQuery("from OrderProductsEntity where order.id = :orderId").setParameter("orderId", orderEntity.getId()).getResultList();
                currentOrderProducts.forEach(orderProduct->{
                    entityManager.remove(orderProduct);
                });
            }

            orderEntity.setOrderProducts(null);
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
