package gov.iti.jets.shoppy.service.dtos;

import gov.iti.jets.shoppy.repository.entity.AddressEntity;
import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
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
    private boolean isAdmin;
}
