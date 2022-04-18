package gov.iti.jets.shoppy.service.dtos;


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
    private String password;
    private boolean isMale;
    private Date dob;
    private String job;
    private double creditLimit;
    private AddressDto address;
}
