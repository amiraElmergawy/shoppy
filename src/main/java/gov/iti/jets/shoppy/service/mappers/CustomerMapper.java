package gov.iti.jets.shoppy.service.mappers;

import gov.iti.jets.shoppy.repository.entity.CustomerEntity;
import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDto customerEntityToDto(CustomerEntity customerEntity);
    CustomerEntity customerDtoToEntity(CustomerDto customerDto);
}
