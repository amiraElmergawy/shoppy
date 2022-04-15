package gov.iti.jets.shoppy.service.impls;

import gov.iti.jets.shoppy.presentation.helpers.ShoppingCartViewHelper;
import gov.iti.jets.shoppy.repository.entity.CustomerEntity;
import gov.iti.jets.shoppy.repository.entity.OrderEntity;
import gov.iti.jets.shoppy.repository.entity.ProductEntity;
import gov.iti.jets.shoppy.repository.interfaces.ProductRepo;
import gov.iti.jets.shoppy.repository.util.ImageUtility;
import gov.iti.jets.shoppy.repository.util.RepoFactory;
import gov.iti.jets.shoppy.service.dtos.OrderDto;
import gov.iti.jets.shoppy.service.dtos.OrderProductDto;
import gov.iti.jets.shoppy.service.dtos.ProductDto;
import gov.iti.jets.shoppy.service.interfaces.ShoppingCartService;
import gov.iti.jets.shoppy.service.mappers.AddressMapper;
import gov.iti.jets.shoppy.service.mappers.CustomerMapper;
import gov.iti.jets.shoppy.service.mappers.OrderMapper;
import gov.iti.jets.shoppy.service.mappers.ProductMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final RepoFactory repoFactory = RepoFactory.INSTANCE;
    private final OrderMapper orderMapper = OrderMapper.INSTANCE;
    private final ImageUtility  imageUtility = ImageUtility.getInstance();
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    private final AddressMapper addressMapper = AddressMapper.INSTANCE;
    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    @Override
    public ShoppingCartViewHelper getShoppingCart(Integer customerId, EntityManager entityManager) {
        Optional<OrderEntity> orderEntityOptional = repoFactory.getOrderRepo(entityManager).getUnSubmittedOrder(customerId);
        ShoppingCartViewHelper shoppingCartViewHelper = new ShoppingCartViewHelper();
        if(orderEntityOptional.isPresent()) {
            OrderEntity orderEntity = orderEntityOptional.get();
            shoppingCartViewHelper.setOrderDto(mapOrderEntityToDto(orderEntity));
        }
        return shoppingCartViewHelper;
    }

    private OrderDto mapOrderEntityToDto(OrderEntity orderEntity) {
        OrderDto orderDto = orderMapper.orderEntityToDTO(orderEntity);
        orderDto.getCustomer().setAddress(addressMapper.addressEntityToDto(orderEntity.getCustomer().getAddressEntity()));
        orderDto.getOrderProducts().forEach(orderProductDto -> {
            ProductDto productDto = orderProductDto.getProduct();
            productDto.setImagesPaths(imageUtility.loadImages(productDto.getId()));
        });
        return orderDto;
    }

    public ShoppingCartViewHelper initializeCustomerCart(Integer customerId, Integer productId, EntityManager entityManager) {
        ProductRepo productRepo = repoFactory.getProductRepo(entityManager);
        Optional<ProductEntity> optionalProduct = getProduct(productId, productRepo);
        ShoppingCartViewHelper shoppingCartViewHelper = new ShoppingCartViewHelper();
        if(optionalProduct.isPresent() && increaseProductQuantity(optionalProduct.get(), productRepo)) {
            ProductEntity productEntity = optionalProduct.get();
            ProductDto productDto = productMapper.productEntityToDto(productEntity);
            OrderDto orderDto = getNewShoppingCart(customerId, entityManager);
            addProductToShoppingCart(orderDto, productDto);
            shoppingCartViewHelper.setOrderDto(orderDto);
        }else
            shoppingCartViewHelper.setError("could not add product to shopping cart");
        return shoppingCartViewHelper;
    }

    @Override
    public boolean increaseProductInShoppingCartTest(Integer productId, EntityManager entityManager) {
        ProductRepo productRepo = repoFactory.getProductRepo(entityManager);
        Optional<ProductEntity> optionalProduct = getProduct(productId, productRepo);
        return increaseProductQuantity(optionalProduct.get(), productRepo);
       }

    @Override
    public void decreaseProductInShoppingCart(Integer productId, EntityManager entityManager) {
        ProductRepo productRepo = repoFactory.getProductRepo(entityManager);
        Optional<ProductEntity> optionalProduct = getProduct(productId, productRepo);
        decreaseProductQuantity(optionalProduct.get(), productRepo);
    }

    private Optional<ProductEntity> getProduct(Integer productId, ProductRepo productRepo) {
        Optional<ProductEntity> optionalProduct = productRepo.findProductById(productId);
        if(optionalProduct.isPresent() && optionalProduct.get().getStock() > 0)
            return optionalProduct;
        return Optional.empty();
    }

    private void addProductToShoppingCart(OrderDto orderDto, ProductDto productDto) {
        OrderProductDto orderProductDto = OrderProductDto.builder()
                .product(productDto)
                .quantity(1).build();
        orderDto.getOrderProducts().add(orderProductDto);
    }

    private OrderDto getNewShoppingCart(Integer customerId, EntityManager entityManager) {
        CustomerEntity customerEntity = (CustomerEntity) repoFactory.getUserRepo(entityManager).findUserById(customerId).get();
        return OrderDto.builder().orderProducts(new ArrayList<>())
                .createdAt(new Date())
                .isSubmitted(false)
                .totalPrice(0)
                .customer(customerMapper.customerEntityToDto(customerEntity))
                .build();
    }

    public boolean increaseProductQuantity(ProductEntity productEntity, ProductRepo productRepo) {
        //decrease product in db test
        //??
//        Integer stock = productEntity.getStock();
//        productEntity.setStock(--stock);
        productEntity.setStock(productEntity.getStock()- 1);
        return productRepo.updateProduct(productEntity);
    }

    public void decreaseProductQuantity(ProductEntity productEntity, ProductRepo productRepo) {
        productEntity.setStock(productEntity.getStock()+ 1);
        productRepo.updateProduct(productEntity);
    }
}
