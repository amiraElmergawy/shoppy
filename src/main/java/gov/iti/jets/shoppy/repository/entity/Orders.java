package gov.iti.jets.shoppy.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.HashSet;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders", catalog = "shoppy")
public class Orders implements java.io.Serializable {

    private int id;
    private Customers customers;
    private Date createdAt;
    private Boolean isSubmitted;
    private double totalPrice;
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

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    public Customers getCustomers() {
        return this.customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at", nullable = false, length = 10)
    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "is_submitted")
    public Boolean getIsSubmitted() {
        return this.isSubmitted;
    }

    public void setIsSubmitted(Boolean isSubmitted) {
        this.isSubmitted = isSubmitted;
    }

    @Column(name = "total_price", nullable = false, precision = 22, scale = 0)
    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
    public Set<OrderProducts> getOrderProductses() {
        return this.orderProductses;
    }

    public void setOrderProductses(Set<OrderProducts> orderProductses) {
        this.orderProductses = orderProductses;
    }

}
