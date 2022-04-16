package gov.iti.jets.shoppy.service.dtos;

import gov.iti.jets.shoppy.repository.entity.AddressEntity;
import gov.iti.jets.shoppy.repository.entity.OrderEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Builder
public class CustomerDto {
    private long id;
    private String username;
    private String email;
    private String interests;
    private boolean isMale;
    private Date dob;
    private String job;
    private double creditLimit;
    private AddressEntity addressEntity;
    private Set<OrderEntity> orders;
}
