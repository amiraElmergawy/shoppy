package gov.iti.jets.shoppy.repository.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_products", catalog = "shoppy")
public class OrderProducts implements java.io.Serializable {

    @EmbeddedId

    @AttributeOverrides({
            @AttributeOverride(name = "orderId", column = @Column(name = "order_id", nullable = false)),
            @AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)) })
    private OrderProductsId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, insertable = false, updatable = false)
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
    private Products products;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    public OrderProducts() {
    }

    public OrderProducts(OrderProductsId id, Orders orders, Products products, int quantity) {
        this.id = id;
        this.orders = orders;
        this.products = products;
        this.quantity = quantity;
    }


    public OrderProductsId getId() {
        return this.id;
    }
    public void setId(OrderProductsId id) {
        this.id = id;
    }

    public Orders getOrders() {
        return this.orders;
    }
    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Products getProducts() {
        return this.products;
    }
    public void setProducts(Products products) {
        this.products = products;
    }

    public int getQuantity() {
        return this.quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
