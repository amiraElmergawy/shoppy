package gov.iti.jets.shoppy.service.impls;

import gov.iti.jets.shoppy.presentation.helpers.ProfileViewHelper;
import gov.iti.jets.shoppy.repository.entity.UserEntity;
import gov.iti.jets.shoppy.repository.util.RepoFactory;
import gov.iti.jets.shoppy.service.interfaces.ProfileService;
import gov.iti.jets.shoppy.service.mappers.CustomerMapper;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class ProfileServiceImpl implements ProfileService {
    private final RepoFactory repoFactory = RepoFactory.INSTANCE;
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;


    @Override
    public ProfileViewHelper getUser(int id, EntityManager entityManager) {
        ProfileViewHelper profileViewHelper=new ProfileViewHelper();
        Optional<? extends UserEntity> userEntityOptional = repoFactory.getUserRepo(entityManager).findUserById(id);
        if(userEntityOptional.isPresent()){
            profileViewHelper = buildProfileViewHelper(userEntityOptional.get());
        }
        else {
            profileViewHelper.setError("Fail");
        }

        return  profileViewHelper;
    }
        private ProfileViewHelper buildProfileViewHelper(UserEntity userEntity) {

        ProfileViewHelper profileViewHelper = new ProfileViewHelper();
        profileViewHelper.setId(userEntity.getId());
        return profileViewHelper;
    }
}
