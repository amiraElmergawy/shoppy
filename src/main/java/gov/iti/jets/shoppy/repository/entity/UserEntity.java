package gov.iti.jets.shoppy.repository.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserEntity {
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
