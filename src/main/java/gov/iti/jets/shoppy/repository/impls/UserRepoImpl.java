package gov.iti.jets.shoppy.repository.impls;

import gov.iti.jets.shoppy.repository.entity.UserEntity;
import gov.iti.jets.shoppy.repository.interfaces.UserRepo;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepoImpl implements UserRepo {

//    private final static UserRepoImpl userRepo = new UserRepoImpl();
//    private UserRepoImpl() {}

//    public static UserRepoImpl getInstance() {
//        return userRepo;
//    }
    private EntityManager entityManager;
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
    public Optional<UserEntity> findUser(String email, String password) {
        String select = "SELECT u FROM UserEntity u WHERE u.email=:email and u.pass=:pass";

        Query query = entityManager.createQuery(select);
        query.setParameter("email", email);
        query.setParameter("pass", password);

        return (Optional<UserEntity>) query.getSingleResult();
    }

    @Override
    public boolean insertUser(UserEntity userEntity) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(userEntity);
            entityManager.getTransaction().commit();
            return true;
        } catch (EntityExistsException exception){
            return false;
        }
    }

    @Override
    public boolean updateUser(UserEntity userEntity) {
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(userEntity);
            entityManager.getTransaction().commit();
            return true;
        } catch (IllegalArgumentException exception){
            return false;
        }
    }

}
