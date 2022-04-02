package gov.iti.jets.shoppy.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import java.util.Set;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "customers", catalog = "shoppy", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Customer extends User implements Serializable {

    private int id;
    // private String username;
    // private String email;
    // private String pass;
    private String interests;
    private Date dob;
    private Boolean isMale;
    private String job;
    private double creditLimit;
    private Address address;
    private Set<Order> orders;

    public Customer() {
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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customers")
    public Address getAddresseses() {
        return this.address;
    }

    public void setAddresseses(Address addresseses) {
        this.address = addresseses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customers")
    public Set<Order> getOrderses() {
        return this.orders;
    }

    public void setOrderses(Set<Order> orderses) {
        this.orders = orderses;
    }

    @Override
    public String toString() {
        return "Customer [address=" + address + ", creditLimit=" + creditLimit + ", dob=" + dob + ", email="
                + super.getEmail() + ", id=" + id + ", interests=" + interests + ", isMale=" + isMale + ", job=" + job
                + ", orderses=" + orders + ", pass=" + super.getPass() + ", username=" + super.getUsername() + "]";
    }
}
