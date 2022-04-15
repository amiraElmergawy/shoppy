package gov.iti.jets.shoppy.service.dtos;

import gov.iti.jets.shoppy.repository.entity.AddressEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

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
}
