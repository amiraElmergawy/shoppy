package gov.iti.jets.shoppy.repository.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders", catalog = "shoppy")
public class Orders implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customers;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at", nullable = false, length = 10)
    private Date createdAt;

    @Column(name = "is_submitted")
    private Boolean isSubmitted;

    @Column(name = "total_price", nullable = false, precision = 22, scale = 0)
    private double totalPrice;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
    private Set<OrderProducts> orderProductses = new HashSet<OrderProducts>(0);

    public Orders() {
    }

    public Orders(int id, Customers customers, Date createdAt, double totalPrice) {
        this.id = id;
        this.customers = customers;
        this.createdAt = createdAt;
        this.totalPrice = totalPrice;
    }

    public Orders(int id, Customers customers, Date createdAt, Boolean isSubmitted, double totalPrice,
            Set<OrderProducts> orderProductses) {
        this.id = id;
        this.customers = customers;
        this.createdAt = createdAt;
        this.isSubmitted = isSubmitted;
        this.totalPrice = totalPrice;
        this.orderProductses = orderProductses;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Customers getCustomers() {
        return this.customers;
    }
    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getIsSubmitted() {
        return this.isSubmitted;
    }
    public void setIsSubmitted(Boolean isSubmitted) {
        this.isSubmitted = isSubmitted;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<OrderProducts> getOrderProductses() {
        return this.orderProductses;
    }
    public void setOrderProductses(Set<OrderProducts> orderProductses) {
        this.orderProductses = orderProductses;
    }

}
