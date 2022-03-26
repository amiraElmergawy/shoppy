package gov.iti.jets.shoppy.repository.util;

import gov.iti.jets.shoppy.repository.impls.UserRepoImpl;
import gov.iti.jets.shoppy.repository.interfaces.UserRepo;

public enum RepoFactory {
    INSTANCE;
    private final UserRepo userRepo = UserRepoImpl.getInstance();
}
