package gov.iti.jets.shoppy.repository.impls;

import gov.iti.jets.shoppy.repository.interfaces.UserRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepoImpl implements UserRepo {
    /*
    List<UserEntity> userEntityList = new ArrayList<>();

    private final static UserRepoImpl userRepo = new UserRepoImpl();
    private UserRepoImpl() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1);
        userEntity.setEmail("zizo@gmail.com");
        userEntity.setAddress(null);
        userEntity.setAdmin(false);
        userEntity.setPassword("25d55ad283aa400af464c76d713c07ad");
        userEntity.setUsername("abdelaziz");
        userEntityList.add(userEntity);
    }

    public static UserRepoImpl getInstance() {
        return userRepo;
    }

    @Override
    public Optional<UserEntity> findUserById(long id) {
        return userEntityList.stream().filter(userEntity -> userEntity.getId() == id).findFirst();
    }

    @Override
    public Optional<UserEntity> findUser(String email, String password) {
          return userEntityList.stream().filter(userEntity ->
                    userEntity.getEmail().equals(email) && userEntity.getPassword().equals(password)
        ).findFirst();
    }

    @Override
    public boolean insertUser(UserEntity userEntity) {
        for(UserEntity user: userEntityList) {
            if(userEntity.getEmail().equals(user.getEmail()))
                return false;
        }
        userEntityList.add(userEntity);
        int size = userEntityList.size();
        userEntity.setId(size++);
        return true;
    }

    @Override
    public boolean updateUser(UserEntity userEntity) {
        return false;
    }
     */
}
