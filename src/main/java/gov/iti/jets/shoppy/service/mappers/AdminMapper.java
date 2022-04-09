package gov.iti.jets.shoppy.service.mappers;

import gov.iti.jets.shoppy.repository.entity.AdminEntity;
import gov.iti.jets.shoppy.service.dtos.AdminDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {
    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);
    AdminDto adminEntityToDto(AdminEntity adminEntity);
    AdminEntity adminDtoToEntity(AdminDto adminDto);
}
