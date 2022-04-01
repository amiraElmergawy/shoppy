package gov.iti.jets.shoppy.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products", catalog = "shoppy")
public class Products implements java.io.Serializable {

    private int id;
    private String productName;
    private String productDesc;
    private double price;
    private int categoryId;
    private int stock;
    private String imgPath;
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

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "product_name", nullable = false, length = 65535)
    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name = "product_desc", nullable = false, length = 65535)
    public String getProductDesc() {
        return this.productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    @Column(name = "price", nullable = false, precision = 22, scale = 0)
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "category_id", nullable = false)
    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "stock", nullable = false)
    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Column(name = "img_path", nullable = false, length = 65535)
    public String getImgPath() {
        return this.imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
    public Set<OrderProducts> getOrderProductses() {
        return this.orderProductses;
    }

    public void setOrderProductses(Set<OrderProducts> orderProductses) {
        this.orderProductses = orderProductses;
    }

}
