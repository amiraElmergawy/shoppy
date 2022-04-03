package gov.iti.jets.shoppy.repository.entity;

import jakarta.persistence.*;
import java.util.Set;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "customers", catalog = "shoppy", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class CustomerEntity extends UserEntity implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "interests", length = 65535)
    private String interests;

    @Temporal(TemporalType.DATE)
    @Column(name = "dob", length = 10)
    private Date dob;

    @Column(name = "is_male")
    private Boolean isMale = true;

    @Column(name = "job", length = 50)
    private String job;

    @Column(name = "credit_limit", nullable = false)
    private double creditLimit = 1000;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.REMOVE)
    private AddressEntity addressEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.REMOVE)
    private Set<OrderEntity> orders;

    public CustomerEntity() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Boolean getIsMale() {
        return isMale;
    }

    public void setIsMale(Boolean male) {
        isMale = male;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", interests='" + interests + '\'' +
                ", dob=" + dob +
                ", isMale=" + isMale +
                ", job='" + job + '\'' +
                ", creditLimit=" + creditLimit +
                ", addressEntity=" + addressEntity +
                ", orders=" + orders +
                '}';
    }
}
