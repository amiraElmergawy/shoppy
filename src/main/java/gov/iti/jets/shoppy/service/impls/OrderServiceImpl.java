package gov.iti.jets.shoppy.service.impls;

import gov.iti.jets.shoppy.presentation.helpers.ShoppingCartViewHelper;
import gov.iti.jets.shoppy.repository.entity.CustomerEntity;
import gov.iti.jets.shoppy.repository.entity.OrderEntity;
import gov.iti.jets.shoppy.repository.util.ImageUtility;
import gov.iti.jets.shoppy.repository.util.RepoFactory;
import gov.iti.jets.shoppy.service.dtos.OrderDto;
import gov.iti.jets.shoppy.service.dtos.ProductDto;
import gov.iti.jets.shoppy.service.interfaces.OrderService;
import gov.iti.jets.shoppy.service.mappers.AddressMapper;
import gov.iti.jets.shoppy.service.mappers.CustomerMapper;
import gov.iti.jets.shoppy.service.mappers.OrderMapper;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {
    private final RepoFactory repoFactory = RepoFactory.INSTANCE;
    private final OrderMapper orderMapper = OrderMapper.INSTANCE;
    private final ImageUtility  imageUtility = ImageUtility.getInstance();
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    private final AddressMapper addressMapper = AddressMapper.INSTANCE;

    @Override
    public ShoppingCartViewHelper getShoppingCart(Integer customerId, EntityManager entityManager) {
        Optional<OrderEntity> orderEntityOptional = repoFactory.getOrderRepo(entityManager).getUnSubmittedOrder(customerId);
        ShoppingCartViewHelper shoppingCartViewHelper = new ShoppingCartViewHelper();
        if(orderEntityOptional.isPresent()) {
            OrderEntity orderEntity = orderEntityOptional.get();
            shoppingCartViewHelper.setOrderDto(mapOrderEntityToDto(orderEntity));
        }else
            shoppingCartViewHelper.setOrderDto(getNewShoppingCart(customerId, entityManager));

        return shoppingCartViewHelper;
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

    private OrderDto mapOrderEntityToDto(OrderEntity orderEntity) {
        OrderDto orderDto = orderMapper.orderEntityToDTO(orderEntity);
        orderDto.getCustomer().setAddress(addressMapper.addressEntityToDto(orderEntity.getCustomer().getAddressEntity()));
        orderDto.getOrderProducts().forEach(orderProductDto -> {
            ProductDto productDto = orderProductDto.getProduct();
            productDto.setImagesPaths(imageUtility.loadImages(productDto.getId()));
        });
        return orderDto;
    }
}
