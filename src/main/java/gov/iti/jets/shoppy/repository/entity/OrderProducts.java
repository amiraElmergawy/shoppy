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

    private OrderProductsId id;
    private Order orders;
    private Product products;
    private int quantity;

    public OrderProducts() {
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "orderId", column = @Column(name = "order_id", nullable = false)),
            @AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)) })
    public OrderProductsId getId() {
        return this.id;
    }

    public void setId(OrderProductsId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, insertable = false, updatable = false)
    public Order getOrders() {
        return this.orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
    public Product getProducts() {
        return this.products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderProduct [id=" + id + ", orders=" + orders.toString() + ", products=" + products.toString() + ", quantity=" + quantity
                + "]";
    }
}
