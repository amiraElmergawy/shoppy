package gov.iti.jets.shoppy.service.dtos;

import gov.iti.jets.shoppy.repository.entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@Builder
public class CustomerDto {
    private long id;
    private String username;
    private String email;
    private String password;
    private String interests;
    private boolean isMale;
    private Date dateOfBirth;
    private String jobTitle;
    private double creditLimit;
    private AddressEntity address;
}
