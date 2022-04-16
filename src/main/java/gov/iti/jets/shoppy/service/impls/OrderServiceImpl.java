package gov.iti.jets.shoppy.service.impls;

import gov.iti.jets.shoppy.presentation.helpers.HomeViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.ViewOrderHelper;
import gov.iti.jets.shoppy.repository.interfaces.OrderRepo;
import gov.iti.jets.shoppy.repository.interfaces.ProductRepo;
import gov.iti.jets.shoppy.repository.util.RepoFactory;
import gov.iti.jets.shoppy.service.dtos.OrderDto;
import gov.iti.jets.shoppy.service.dtos.ProductDto;
import gov.iti.jets.shoppy.service.interfaces.OrderService;
import gov.iti.jets.shoppy.service.mappers.OrderMapper;
import gov.iti.jets.shoppy.service.mappers.ProductMapper;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    private final RepoFactory repoFactory = RepoFactory.INSTANCE;
    private final OrderMapper orderMapper = OrderMapper.INSTANCE;
    @Override
    public ViewOrderHelper getOrders(int pageNumber, EntityManager entityManager) {
        OrderRepo orderRepo = repoFactory.getOrderRepo(entityManager);
        List<OrderDto> orderDtoList = orderRepo.getOrders(pageNumber).stream().map(
                OrderEntity -> {
                    System.out.println(OrderEntity.toString());
                    OrderDto orderDto = orderMapper.orderEntityToDTO(OrderEntity);
                    System.out.println(orderDto.toString());
                    return orderDto;
                }
        ).collect(Collectors.toList());
        Long allOrdersCount = orderRepo.getOrdersCount();
        return ViewOrderHelper.builder().ordersDtoList(orderDtoList).allOrdersCount(allOrdersCount).build();
    }
}
