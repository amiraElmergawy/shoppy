package gov.iti.jets.shoppy.service.interfaces;

import gov.iti.jets.shoppy.presentation.helpers.HomeViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.ViewProductHelper;
import gov.iti.jets.shoppy.service.dtos.ProductDto;
import jakarta.persistence.EntityManager;

public interface ProductService {
    HomeViewHelper getProducts(int pageNumber, EntityManager entityManager);
    ViewProductHelper getProductById(int id , EntityManager entityManager);
    boolean addProduct(ProductDto productDto,EntityManager entityManager);
    boolean updateProduct(ProductDto productDto, EntityManager entityManager, int id);
}
