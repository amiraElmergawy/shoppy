package gov.iti.jets.shoppy.service.impls;

import gov.iti.jets.shoppy.presentation.helpers.HomeViewHelper;
import gov.iti.jets.shoppy.repository.interfaces.ProductRepo;
import gov.iti.jets.shoppy.repository.util.RepoFactory;
import gov.iti.jets.shoppy.service.dtos.ProductDto;
import gov.iti.jets.shoppy.service.interfaces.ProductService;
import gov.iti.jets.shoppy.service.mappers.ProductMapper;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    private final RepoFactory repoFactory = RepoFactory.INSTANCE;
    private final ProductMapper productMapper = ProductMapper.INSTANCE;
    @Override
    public HomeViewHelper getProducts(int pageNumber, EntityManager entityManager) {
        ProductRepo productRepo = repoFactory.getProductRepo(entityManager);
        List<ProductDto> productDtoList = productRepo.getProducts(pageNumber).stream().map(
                productMapper::productEntityToDto
        ).collect(Collectors.toList());

        return HomeViewHelper.builder().productDtoList(productDtoList).build();
    }
}
