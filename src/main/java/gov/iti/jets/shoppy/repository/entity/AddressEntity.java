package gov.iti.jets.shoppy.repository.entity;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.annotations.Parameter;
import java.util.Objects;


@Entity
@Table(name = "addresses", catalog = "shoppy", uniqueConstraints = @UniqueConstraint(columnNames = "customer_id"))
public class AddressEntity implements java.io.Serializable {
    @Id
    @Column(name = "customer_id", unique = true, nullable = false)
    @GenericGenerator(name = "Generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "customer"))
    @GeneratedValue(generator = "Generator")
    private Integer id;

    @Column(name = "area", nullable = false, length = 100)
    private String area;

    @Column(name = "building_num", nullable = false)
    private Integer buildingNum;

    @Column(name = "floor_num")
    private Integer floorNum;

    @Column(name = "street", nullable = false, length = 100)
    private String street;

    @OneToOne
    @PrimaryKeyJoinColumn
    private CustomerEntity customer;

    public AddressEntity(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(Integer buildingNum) {
        this.buildingNum = buildingNum;
    }

    public Integer getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(Integer floorNum) {
        this.floorNum = floorNum;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return id.equals(that.id) && area.equals(that.area) && buildingNum.equals(that.buildingNum) && Objects.equals(floorNum, that.floorNum) && street.equals(that.street) && Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, area, buildingNum, floorNum, street, customer);
    }

    @Override
    public String toString() {
        return "building number "+buildingNum+", "+street+", "+area+", "+" floor Number "+floorNum;
    }
}
