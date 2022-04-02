package gov.iti.jets.shoppy.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admins", catalog = "shoppy", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Admins extends user implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;


    public Admins() {
    }

    public Admins(int id, String username, String email, String pass) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.pass = pass;
    }


    public int getId() {return this.id;}
    public void setId(int id) {this.id = id;}

    public String getUsername() {return this.username;}
    public void setUsername(String username) {this.username = username;}

    public String getEmail() {return this.email;}
    public void setEmail(String email) {this.email = email;}

    public String getPass() {return this.pass;}
    public void setPass(String pass) {this.pass = pass;}

}
