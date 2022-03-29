package gov.iti.jets.shoppy.service.mappers;

import gov.iti.jets.shoppy.repository.entity.UserEntity;
import gov.iti.jets.shoppy.service.dtos.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto UserEntityToDto(UserEntity userEntity);
    UserEntity userDtoToEntity(UserDto userDto);
}
