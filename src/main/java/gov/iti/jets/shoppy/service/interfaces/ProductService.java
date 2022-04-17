package gov.iti.jets.shoppy.service.interfaces;

import gov.iti.jets.shoppy.presentation.helpers.HomeViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.ViewProductHelper;
import jakarta.persistence.EntityManager;

public interface ProductService {
    HomeViewHelper getProducts(int pageNumber, EntityManager entityManager);
    ViewProductHelper getProductById(int id , EntityManager entityManager);
    HomeViewHelper searchForProducts(EntityManager entityManager, String value);
    boolean deleteProduct(int id , EntityManager entityManager);
}
