package gov.iti.jets.shoppy.repository.entity;

import jakarta.persistence.*;

import java.util.Set;
import java.util.Date;

@Entity
@Table(name = "customers", catalog = "shoppy", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Customers extends user implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "interests", length = 65535)
    private String interests;

    @Temporal(TemporalType.DATE)
    @Column(name = "dob", length = 10)
    private Date dob;

    @Column(name = "is_male")
    private Boolean isMale;

    @Column(name = "job", length = 50)
    private String job;

    @Column(name = "credit_limit", nullable = false, precision = 22, scale = 0)
    private double creditLimit;

    @OneToOne(mappedBy = "customers")
    private Addresses addresseses;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customers")
    private Set<Orders> orderses;


    public Customers() {
    }


    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return this.pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getInterests() {
        return this.interests;
    }
    public void setInterests(String interests) {
        this.interests = interests;
    }

    public Date getDob() {
        return this.dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Boolean getIsMale() {
        return this.isMale;
    }
    public void setIsMale(Boolean isMale) {
        this.isMale = isMale;
    }

    public String getJob() {
        return this.job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    public double getCreditLimit() {
        return this.creditLimit;
    }
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Addresses getAddresseses() {
        return this.addresseses;
    }
    public void setAddresseses(Addresses addresseses) {
        this.addresseses = addresseses;
    }

    public Set<Orders> getOrderses() {
        return this.orderses;
    }
    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }

}
