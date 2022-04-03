package gov.iti.jets.shoppy.repository.entity;

import java.io.Serializable;

import jakarta.persistence.*;
//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users", catalog = "shoppy", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class UserEntity implements Serializable {


    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Column(name = "email", unique = true, nullable = false, length = 254)
    private String email;
    @Column(name = "pass", nullable = false, length = 150)
    private String password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
