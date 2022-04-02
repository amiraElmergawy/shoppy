package gov.iti.jets.shoppy.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customers", cascade = CascadeType.REMOVE)
    private AddressEntity addressEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customers", cascade = CascadeType.REMOVE)
    private Set<OrderEntity> orders;

}
