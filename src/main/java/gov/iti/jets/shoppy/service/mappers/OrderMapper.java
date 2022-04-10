package gov.iti.jets.shoppy.service.mappers;

import gov.iti.jets.shoppy.repository.entity.OrderEntity;
import gov.iti.jets.shoppy.service.dtos.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto orderEntityToDTO(OrderEntity orderEntity);
    OrderEntity orderDTOToEntity(OrderDto orderDto);
}
