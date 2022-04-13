package gov.iti.jets.shoppy.service.interfaces;

import gov.iti.jets.shoppy.presentation.helpers.HomeViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.ProfileViewHelper;
import jakarta.persistence.EntityManager;

public interface ProfileService {
    ProfileViewHelper getUser(long id, EntityManager entityManager);
}
