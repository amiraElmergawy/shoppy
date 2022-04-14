package gov.iti.jets.shoppy.service.dtos;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {
    private Integer id;
    private String area;
    private Integer buildingNum;
    private Integer floorNum;
    private String street;
}
