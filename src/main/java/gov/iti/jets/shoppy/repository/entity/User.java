package gov.iti.jets.shoppy.repository.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class User implements Serializable {

    private String username;
    private String email;
    private String pass;

    public User() {

    }

    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "email", unique = true, nullable = false, length = 254)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "pass", nullable = false, length = 150)
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    };
}
