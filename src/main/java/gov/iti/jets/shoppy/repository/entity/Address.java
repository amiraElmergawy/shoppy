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


@Entity
@Table(name = "addresses", catalog = "shoppy", uniqueConstraints = @UniqueConstraint(columnNames = "customer_id"))
public class Address implements java.io.Serializable {

    private int id;
    private String area;
    private int buildingNum;
    private Integer floorNum;
    private String street;
    private Customer customers;

    public Address() {
    }

    @Column(name = "area", nullable = false, length = 100)
    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name = "building_num", nullable = false)
    public int getBuildingNum() {
        return this.buildingNum;
    }

    public void setBuildingNum(int buildingNum) {
        this.buildingNum = buildingNum;
    }

    @Id
    @Column(name = "customer_id", unique = true, nullable = false)
    @GenericGenerator(name = "Generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "customers"))
    @GeneratedValue(generator = "Generator")
    public int getid() {
        return this.id;
    }

    public void setid(int customerId) {
        this.id = customerId;
    }

    @Column(name = "floor_num")
    public Integer getFloorNum() {
        return this.floorNum;
    }

    public void setFloorNum(Integer floorNum) {
        this.floorNum = floorNum;
    }

    @Column(name = "street", nullable = false, length = 100)
    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    public Customer getCustomers() {
        return this.customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    // public boolean equals(Object other) {
    // if ((this == other))
    // return true;
    // if ((other == null))
    // return false;
    // if (!(other instanceof AddressesId))
    // return false;
    // AddressesId castOther = (AddressesId) other;

    // return ((this.getArea() == castOther.getArea()) || (this.getArea() != null &&
    // castOther.getArea() != null
    // && this.getArea().equals(castOther.getArea())))
    // && (this.getBuildingNum() == castOther.getBuildingNum())
    // && (this.getCustomerId() == castOther.getCustomerId())
    // && ((this.getFloorNum() == castOther.getFloorNum()) || (this.getFloorNum() !=
    // null
    // && castOther.getFloorNum() != null &&
    // this.getFloorNum().equals(castOther.getFloorNum())))
    // && ((this.getStreet() == castOther.getStreet()) || (this.getStreet() != null
    // && castOther.getStreet() != null &&
    // this.getStreet().equals(castOther.getStreet())));
    // }

    // public int hashCode() {
    // int result = 17;

    // result = 37 * result + (getArea() == null ? 0 : this.getArea().hashCode());
    // result = 37 * result + this.getBuildingNum();
    // result = 37 * result + this.getCustomerId();
    // result = 37 * result + (getFloorNum() == null ? 0 :
    // this.getFloorNum().hashCode());
    // result = 37 * result + (getStreet() == null ? 0 :
    // this.getStreet().hashCode());
    // return result;
    // }

    @Override
    public String toString() {
        return "AddressesId [area=" + area + ", buildingNum=" + buildingNum + ", customerId=" + id
                + ", floorNum=" + floorNum + ", street=" + street + "]";
    }
}
