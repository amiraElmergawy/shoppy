package gov.iti.jets.shoppy.service.impls;

import gov.iti.jets.shoppy.presentation.helpers.HomeViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.ViewProductHelper;
import gov.iti.jets.shoppy.repository.entity.ProductEntity;
import gov.iti.jets.shoppy.repository.interfaces.ProductRepo;
import gov.iti.jets.shoppy.repository.util.ImageUtility;
import gov.iti.jets.shoppy.repository.util.RepoFactory;
import gov.iti.jets.shoppy.service.dtos.ProductDto;
import gov.iti.jets.shoppy.service.interfaces.ProductService;
import gov.iti.jets.shoppy.service.mappers.ProductMapper;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    private final RepoFactory repoFactory = RepoFactory.INSTANCE;
    private final ProductMapper productMapper = ProductMapper.INSTANCE;
    private final ImageUtility imageUtility = ImageUtility.getInstance();
    @Override
    public HomeViewHelper getProducts(int pageNumber, EntityManager entityManager) {
        ProductRepo productRepo = repoFactory.getProductRepo(entityManager);
        List<ProductDto> productDtoList = productRepo.getProducts(pageNumber).stream().map(
                productEntity -> {
                    ProductDto productDto = productMapper.productEntityToDto(productEntity);
                    productDto.setImagesPaths(imageUtility.loadImages(productDto.getId()));
                    return productDto;
                }
        ).collect(Collectors.toList());
        Long allProductCount = productRepo.getProductsCount();
        return HomeViewHelper.builder().productDtoList(productDtoList).allProductCount(allProductCount).build();
    }

    @Override
    public ViewProductHelper getProductById(int id , EntityManager entityManager) {
        ProductRepo productRepo = RepoFactory.INSTANCE.getProductRepo(entityManager);
        Optional<ProductEntity> productEntity =  productRepo.findProductById(id);
        ViewProductHelper viewProductHelper = new ViewProductHelper();
        if(productEntity.isPresent()){
            ProductDto productDto = productMapper.productEntityToDto(productEntity.get());
            productDto.setImagesPaths(imageUtility.loadImages(productDto.getId()));
            viewProductHelper.setProductDto(productDto);
        }else {
            viewProductHelper.setErrorMessage("Not Found");
        }
        return viewProductHelper;
    }

    @Override
    public boolean addProduct(ProductDto productDto, EntityManager entityManager) {
        ProductEntity productEntity= productMapper.productDtoToEntity(productDto);
        System.out.println(productEntity);
        ProductRepo productRepo = RepoFactory.INSTANCE.getProductRepo(entityManager);
        return productRepo.addProduct(productEntity);

    }

}
