package gov.iti.jets.shoppy.service.mappers;

import gov.iti.jets.shoppy.repository.entity.AdminEntity;
import gov.iti.jets.shoppy.repository.entity.UserEntity;
import gov.iti.jets.shoppy.service.dtos.AdminDto;
import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper <T extends UserEntity> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    AdminDto entityToAdminDto(T adminEntity);
    T dtoToAdminEntity(AdminDto adminDto);
    CustomerDto entityToCustomerDto(T customerEntity);
    T dtoToCustomerEntity(CustomerDto customerDto);
}
