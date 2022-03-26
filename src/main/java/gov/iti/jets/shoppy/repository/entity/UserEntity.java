package gov.iti.jets.shoppy.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String email;
    private String password;
    private String interests;
    private boolean isMale;
    private String dateOfBirth;
    private String jobTitle;
    private double creditLimit;
    private AddressEntity address;
    private Role role;
}
