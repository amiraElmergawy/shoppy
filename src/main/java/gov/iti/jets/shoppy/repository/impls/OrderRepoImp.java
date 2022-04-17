package gov.iti.jets.shoppy.repository.impls;

import gov.iti.jets.shoppy.repository.entity.OrderEntity;
import gov.iti.jets.shoppy.repository.interfaces.OrderRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.util.Optional;

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
    public boolean updateOrder(OrderEntity orderEntity) {
        try {
            entityManager.getTransaction().begin();
            System.out.println("ssssss");
            entityManager.persist(orderEntity);
            entityManager.getTransaction().commit();
            System.out.println("lol");
            return true;
        } catch (Exception exception){
            exception.printStackTrace();
            System.out.println(exception);
            return false;
        }
    }

}
