package gov.iti.jets.shoppy.repository.impls;

import gov.iti.jets.shoppy.repository.entity.*;
import gov.iti.jets.shoppy.repository.interfaces.OrderRepo;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

//    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shoppy");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        AdminEntity admin = new AdminEntity();
//        admin.setEmail("zizo@gmail.com");
//        admin.setPassword("3075141a16bb2dbb6e5b4f54167913f4");
//        admin.setUsername("abdelaziz");
//        entityManager.persist(admin);
//        CustomerEntity customer = new CustomerEntity();
//        customer.setEmail("saif@gmail.com");
//        customer.setDob(new Date());
//        customer.setUsername("saif");
//        customer.setJob("programmer");
//        customer.setIsMale(true);
//        customer.setCreditLimit(12334);
//        customer.setPassword("3075141a16bb2dbb6e5b4f54167913f4");
//        customer.setInterests("interstes");
//        entityManager.persist(customer);
//        AddressEntity address = new AddressEntity();
//        address.setArea("giza");
//        address.setBuildingNum(54);
//        address.setCustomer(customer);
//        address.setFloorNum(9);
//        address.setStreet("El-fadi");
//        entityManager.persist(address);
//        ProductEntity product = new ProductEntity();
//        product.setCategory(ProductCategory.BEDROOM);
//        product.setImgPath("new image path");
//        product.setProductName("In Home Bed 160 Cm Capton");
//        product.setProductDesc("Bed 120 cm gray capton\n" +
//                " Made of beech wood\n" +
//                " Cloth plush\n" +
//                " High density sponge");
//        product.setPrice(2700.00);
//        product.setStock(23);
//        entityManager.persist(product);
//        OrderEntity order = new OrderEntity();
//        order.setCreatedAt(new Date());
//        order.setCustomer(customer);
//        order.setIsSubmitted(false);
//        order.setTotalPrice(223.233);
//        entityManager.persist(order);
//        OrderProductsIdEntity orderProductsId = new OrderProductsIdEntity();
//        orderProductsId.setOrderId(order.getId());
//        orderProductsId.setProductId(product.getId());
//        OrderProductsEntity orderProduct = new OrderProductsEntity();
//        orderProduct.setId(orderProductsId);
//        orderProduct.setOrder(order);
//        orderProduct.setProducts(product);
//        orderProduct.setQuantity(3);
//        entityManager.persist(orderProduct);
//
//
//        entityManager.getTransaction().commit();
//    }
}
