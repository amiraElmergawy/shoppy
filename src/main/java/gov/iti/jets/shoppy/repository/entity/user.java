package gov.iti.jets.shoppy.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class user {



    @Column(name = "username", nullable = false, length = 50)
    protected String username;

    @Column(name = "email", unique = true, nullable = false, length = 254)
    protected String email;

    @Column(name = "pass", nullable = false, length = 150)
    protected String pass;


    public abstract String getUsername();
    public abstract void setUsername(String username);

    public abstract String getEmail();
    public abstract void setEmail(String email);

    public abstract String getPass();
    public abstract void setPass(String pass);

}
