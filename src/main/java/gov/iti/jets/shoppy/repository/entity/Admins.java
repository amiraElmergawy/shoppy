package gov.iti.jets.shoppy.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "admins", catalog = "shoppy", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Admins implements java.io.Serializable {

    private int id;
    private String username;
    private String email;
    private String pass;

    public Admins() {
    }

    public Admins(int id, String username, String email, String pass) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.pass = pass;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "email", unique = true, nullable = false, length = 254)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "pass", nullable = false, length = 150)
    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
