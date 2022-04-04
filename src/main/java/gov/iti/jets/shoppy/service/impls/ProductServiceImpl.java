package gov.iti.jets.shoppy.service.impls;

import gov.iti.jets.shoppy.presentation.helpers.HomeViewHelper;
import gov.iti.jets.shoppy.service.interfaces.ProductService;
import jakarta.persistence.EntityManager;

public class ProductServiceImpl implements ProductService {
    @Override
    public HomeViewHelper getProducts(EntityManager entityManager) {
        return null;
    }
}
