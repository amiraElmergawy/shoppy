package gov.iti.jets.shoppy.service.mappers;

import gov.iti.jets.shoppy.repository.entity.ProductEntity;
import gov.iti.jets.shoppy.service.dtos.ProductDto;
import org.hibernate.annotations.Source;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
//    @Source(ign)
    ProductDto productEntityToDto(ProductEntity productEntity);
    ProductEntity productDtoToEntity(ProductDto productDto);
}
