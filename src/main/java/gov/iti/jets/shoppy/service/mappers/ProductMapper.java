package gov.iti.jets.shoppy.service.mappers;

import gov.iti.jets.shoppy.repository.entity.ProductEntity;
import gov.iti.jets.shoppy.service.dtos.ProductDto;
import org.hibernate.annotations.Source;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mapping(source = "imgPath",target = "imagesPaths", ignore = true)
    ProductDto productEntityToDto(ProductEntity productEntity);
    @Mapping(source = "imagesPaths",target = "imgPath", ignore = true)
    ProductEntity productDtoToEntity(ProductDto productDto);
}
