package gov.iti.jets.shoppy.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AddressesId implements java.io.Serializable {

    private String area;
    private int buildingNum;
    private int customerId;
    private Integer floorNum;
    private String street;

    public AddressesId() {
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

    @Column(name = "customer_id", unique = true, nullable = false)
    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof AddressesId))
            return false;
        AddressesId castOther = (AddressesId) other;

        return ((this.getArea() == castOther.getArea()) || (this.getArea() != null && castOther.getArea() != null
                && this.getArea().equals(castOther.getArea())))
                && (this.getBuildingNum() == castOther.getBuildingNum())
                && (this.getCustomerId() == castOther.getCustomerId())
                && ((this.getFloorNum() == castOther.getFloorNum()) || (this.getFloorNum() != null
                        && castOther.getFloorNum() != null && this.getFloorNum().equals(castOther.getFloorNum())))
                && ((this.getStreet() == castOther.getStreet()) || (this.getStreet() != null
                        && castOther.getStreet() != null && this.getStreet().equals(castOther.getStreet())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getArea() == null ? 0 : this.getArea().hashCode());
        result = 37 * result + this.getBuildingNum();
        result = 37 * result + this.getCustomerId();
        result = 37 * result + (getFloorNum() == null ? 0 : this.getFloorNum().hashCode());
        result = 37 * result + (getStreet() == null ? 0 : this.getStreet().hashCode());
        return result;
    }

}
