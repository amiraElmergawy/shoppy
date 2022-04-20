package gov.iti.jets.shoppy.repository.impls;

import gov.iti.jets.shoppy.repository.entity.*;
import gov.iti.jets.shoppy.repository.interfaces.UserRepo;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.List;
import java.util.Optional;

public class UserRepoImpl implements UserRepo {
    private final static int pageSize = 12;
    private final EntityManager entityManager;
    public UserRepoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Optional<UserEntity> findUserById(long id) {
        var userEntity =entityManager.find(UserEntity.class, id);
        if(userEntity != null)
            return Optional.of(userEntity);
        return Optional.empty();
    }

    @Override
    public Optional<? extends UserEntity> findUser(String email, String password) {
        String select = "select  u from UserEntity u where u.email=:email and u.pass=:password";
        Query query = entityManager.createQuery(select);
        query.setParameter("email", email);
        query.setParameter("password", password);
        try {
            String entityType = query.getSingleResult().getClass().getName().substring(query.getSingleResult().getClass().getName().lastIndexOf(".")+1);
            if(entityType.equals("AdminEntity")){
                return Optional.of((AdminEntity) query.getSingleResult());
            }else {
                return Optional.of((CustomerEntity) query.getSingleResult());
            }
        }catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean insertUser(UserEntity userEntity) {
        if(findUserByEmail(userEntity.getEmail()))
            return false;
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(userEntity);
            entityManager.getTransaction().commit();
            return true;
        } catch (EntityExistsException exception){
            return false;
        }
    }

    @Override
    public boolean updateUser(int id , CustomerEntity customer, AddressEntity addressEntity) {
        entityManager.getTransaction().begin();

        try {
            AddressEntity addressEntityData = entityManager.find(AddressEntity.class,id);
            if(addressEntityData == null) {
                addressEntityData = new AddressEntity();
            }
            addressEntityData.setArea(addressEntity.getArea());
            addressEntityData.setBuildingNum(addressEntity.getBuildingNum());
            addressEntityData.setFloorNum(addressEntity.getFloorNum());
            addressEntityData.setStreet(addressEntity.getStreet());

            CustomerEntity customerEntity=entityManager.find(CustomerEntity.class,id);
            customerEntity.setUsername(customer.getUsername());
            customerEntity.setDob(customer.getDob());
            customerEntity.setInterests(customer.getInterests());
            customerEntity.setCreditLimit(customer.getCreditLimit());
            customerEntity.setAddressEntity(addressEntityData);
            customerEntity.setJob(customer.getJob());
            customerEntity.setIsMale(customer.getIsMale());

            entityManager.merge(customerEntity);

            entityManager.getTransaction().commit();
            return true;
        } catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public List<CustomerEntity> getCustomers(int pageNumber) {
        Query query = entityManager.createQuery("from CustomerEntity", CustomerEntity.class);
        query.setFirstResult((pageNumber-1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public Long getCustomerCount() {
        return entityManager.createQuery("select count(*) from CustomerEntity ", Long.class)
                .getSingleResult();
    }
    private boolean findUserByEmail(String email){
        String select = "select  u from UserEntity u where u.email=:email";
        Query query = entityManager.createQuery(select);
        query.setParameter("email", email);
        try {
            query.getSingleResult();
            return true;
        }catch (NoResultException e) {
            return false;
        }
    }
    @Override
    public boolean updateCustomerCreditLimit(Integer customerId, double amount) {
        try {
            entityManager.getTransaction().begin();
            var customer = entityManager.find(CustomerEntity.class,customerId);
            customer.setCreditLimit(amount);
            System.out.println(entityManager.merge(customer));
//            System.out.println(entityManager.createQuery("update CustomerEntity c set c.creditLimit = 1000 where c.id = 4").executeUpdate());
//                    .setParameter("creditLimit", customerEntity.getCreditLimit()).setParameter("id",customerEntity.getId()).getResultList());
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
    }

}
