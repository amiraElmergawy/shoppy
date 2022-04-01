package gov.iti.jets.shoppy.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import java.util.Set;
import java.util.Date;

@Entity
@Table(name = "customers", catalog = "shoppy", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Customers implements java.io.Serializable {

    private int id;
    private String username;
    private String email;
    private String pass;
    private String interests;
    private Date dob;
    private Boolean isMale;
    private String job;
    private double creditLimit;
    private Addresses addresseses;
    private Set<Orders> orderses;

    public Customers() {
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

    @Column(name = "interests", length = 65535)
    public String getInterests() {
        return this.interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dob", length = 10)
    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Column(name = "is_male")
    public Boolean getIsMale() {
        return this.isMale;
    }

    public void setIsMale(Boolean isMale) {
        this.isMale = isMale;
    }

    @Column(name = "job", length = 50)
    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Column(name = "credit_limit", nullable = false, precision = 22, scale = 0)
    public double getCreditLimit() {
        return this.creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @OneToOne(mappedBy = "customers")
    public Addresses getAddresseses() {
        return this.addresseses;
    }

    public void setAddresseses(Addresses addresseses) {
        this.addresseses = addresseses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customers")
    public Set<Orders> getOrderses() {
        return this.orderses;
    }

    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }

}
