package gov.iti.jets.shoppy.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "orders", catalog = "shoppy")
public class OrderEntity implements java.io.Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customers;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at", nullable = false, length = 10)
    private Date createdAt = new Date();

    @Column(name = "is_submitted")
    private Boolean isSubmitted = false;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orders", cascade = CascadeType.REMOVE)
    private Set<OrderProductsEntity> orderProducts = new HashSet<OrderProductsEntity>();
}
