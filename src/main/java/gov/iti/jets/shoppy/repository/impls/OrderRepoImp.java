package gov.iti.jets.shoppy.repository.impls;

import gov.iti.jets.shoppy.repository.entity.OrderEntity;
import gov.iti.jets.shoppy.repository.entity.ProductEntity;
import gov.iti.jets.shoppy.repository.interfaces.OrderRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.Order;

import java.util.List;
import java.util.Optional;

public class OrderRepoImp implements OrderRepo {
    private static int pageSize = 12;
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
            System.out.println(e.getMessage());
        }
        return optional;
    }

    @Override
    public Long getOrdersCount() {
        return entityManager.createQuery("select count(*) from OrderEntity ", Long.class)
                .getSingleResult();
    }

    @Override
    public List<OrderEntity> getOrders(int pageNumber) {
        Query query = entityManager.createQuery("from OrderEntity ", OrderEntity.class);
        query.setFirstResult((pageNumber-1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public List<OrderEntity> getOrdersByCustomerId(int customerId) {
        TypedQuery<OrderEntity> typedQuery = entityManager.createQuery("from OrderEntity where customer.id=:customerID" , OrderEntity.class)
                .setParameter("customerID",customerId);
        return typedQuery.getResultList();
    }
}
