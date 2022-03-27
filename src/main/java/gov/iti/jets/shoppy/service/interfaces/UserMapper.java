package gov.iti.jets.shoppy.service.interfaces;

import gov.iti.jets.shoppy.repository.entity.UserEntity;
import gov.iti.jets.shoppy.service.dtos.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    UserDto userEntityToUserDto(UserEntity userEntity);

    UserEntity userEntityToUserDto(UserDto userDto);

}

