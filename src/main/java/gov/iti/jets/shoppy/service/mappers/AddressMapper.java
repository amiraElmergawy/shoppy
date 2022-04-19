package gov.iti.jets.shoppy.service.mappers;

import gov.iti.jets.shoppy.repository.entity.AddressEntity;
import gov.iti.jets.shoppy.service.dtos.AddressDto;
import gov.iti.jets.shoppy.service.dtos.AdminDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    AddressDto addressEntityToDto(AddressEntity addressEntity);
    AddressEntity addressDtoToEntity(AddressDto addressDto);
}
