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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "order_products", catalog = "shoppy")
public class OrderProductsEntity implements java.io.Serializable {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "orderId", column = @Column(name = "order_id", nullable = false)),
            @AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)) })
    private OrderProductsIdEntity id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, insertable = false, updatable = false)
    private OrderEntity orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
    private ProductEntity products;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
