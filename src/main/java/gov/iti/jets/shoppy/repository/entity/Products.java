package gov.iti.jets.shoppy.repository.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products", catalog = "shoppy")
public class Products implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "product_name", nullable = false, length = 65535)
    private String productName;

    @Column(name = "product_desc", nullable = false, length = 65535)
    private String productDesc;

    @Column(name = "price", nullable = false, precision = 22, scale = 0)
    private double price;

    @Column(name = "category_id", nullable = false)
    private int categoryId;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "img_path", nullable = false, length = 65535)
    private String imgPath;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
    private Set<OrderProducts> orderProductses = new HashSet<OrderProducts>(0);

    public Products() {
    }

    public Products(int id, String productName, String productDesc, double price, int categoryId, int stock,
            String imgPath) {
        this.id = id;
        this.productName = productName;
        this.productDesc = productDesc;
        this.price = price;
        this.categoryId = categoryId;
        this.stock = stock;
        this.imgPath = imgPath;
    }

    public Products(int id, String productName, String productDesc, double price, int categoryId, int stock,
            String imgPath, Set<OrderProducts> orderProductses) {
        this.id = id;
        this.productName = productName;
        this.productDesc = productDesc;
        this.price = price;
        this.categoryId = categoryId;
        this.stock = stock;
        this.imgPath = imgPath;
        this.orderProductses = orderProductses;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return this.productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return this.productDesc;
    }
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryId() {
        return this.categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getStock() {
        return this.stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return this.imgPath;
    }
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Set<OrderProducts> getOrderProductses() {
        return this.orderProductses;
    }
    public void setOrderProductses(Set<OrderProducts> orderProductses) {
        this.orderProductses = orderProductses;
    }

}
