package gov.iti.jets.shoppy.service.interfaces;

import gov.iti.jets.shoppy.presentation.helpers.HomeViewHelper;
import jakarta.persistence.EntityManager;

public interface ProductService {
    HomeViewHelper getProducts(EntityManager entityManager);
}
