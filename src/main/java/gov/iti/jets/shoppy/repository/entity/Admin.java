package gov.iti.jets.shoppy.repository.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "admins", catalog = "shoppy", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Admin extends User implements Serializable {

    private int id;
    public Admin() {
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // @Column(name = "username", nullable = false, length = 50)
    // public String getUsername() {
    //     return this.username;
    // }

    // public void setUsername(String username) {
    //     this.username = username;
    // }

    // @Column(name = "email", unique = true, nullable = false, length = 254)
    // public String getEmail() {
    //     return this.email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    // @Column(name = "pass", nullable = false, length = 150)
    // public String getPass() {
    //     return this.pass;
    // }

    // public void setPass(String pass) {
    //     this.pass = pass;
    // }

}
