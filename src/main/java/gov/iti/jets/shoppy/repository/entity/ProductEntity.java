package gov.iti.jets.shoppy.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product", catalog = "shoppy")
public class ProductEntity implements java.io.Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name", nullable = false, length = 65535)
    private String productName;

    @Column(name = "product_desc", nullable = false, length = 65535)
    private String productDesc;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "img_path", nullable = false, length = 65535)
    private String imgPath;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
    private Set<OrderProductsEntity> orderProducts = new HashSet<OrderProductsEntity>();
}
