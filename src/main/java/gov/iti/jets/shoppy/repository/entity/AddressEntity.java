package gov.iti.jets.shoppy.repository.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressEntity {
    private Long id;
    private String area;
    private String street;
    private int buildingNum;
    private int floorNum;
}
