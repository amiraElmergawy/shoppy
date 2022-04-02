package gov.iti.jets.shoppy.repository.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity implements Serializable {

    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Column(name = "email", unique = true, nullable = false, length = 254)
    private String email;
    @Column(name = "pass", nullable = false, length = 150)
    private String password;
}
