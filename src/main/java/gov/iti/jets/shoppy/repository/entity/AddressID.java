package gov.iti.jets.shoppy.repository.entity;// package gov.iti.jets.generated;

// import jakarta.persistence.AttributeOverride;
// import jakarta.persistence.AttributeOverrides;
// import jakarta.persistence.Column;
// import jakarta.persistence.EmbeddedId;
// import jakarta.persistence.Entity;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.PrimaryKeyJoinColumn;
// import jakarta.persistence.Table;
// import jakarta.persistence.UniqueConstraint;

// @Entity
// @Table(name = "addresses", catalog = "shoppy", uniqueConstraints = @UniqueConstraint(columnNames = "customer_id"))
// public class Address implements java.io.Serializable {

//     private AddressesId id;
//     private Customer customers;

//     public Address() {
//     }

//     @EmbeddedId
//     @AttributeOverrides({
//             @AttributeOverride(name = "area", column = @Column(name = "area", nullable = false, length = 100)),
//             @AttributeOverride(name = "buildingNum", column = @Column(name = "building_num", nullable = false)),
//             @AttributeOverride(name = "customerId", column = @Column(name = "customer_id", unique = true, nullable = false)),
//             @AttributeOverride(name = "floorNum", column = @Column(name = "floor_num")),
//             @AttributeOverride(name = "street", column = @Column(name = "street", nullable = false, length = 100)) })
//     public AddressesId getId() {
//         return this.id;
//     }

//     public void setId(AddressesId id) {
//         this.id = id;
//     }

//     @OneToOne
//     @PrimaryKeyJoinColumn
//     public Customer getCustomers() {
//         return this.customers;
//     }

//     public void setCustomers(Customer customers) {
//         this.customers = customers;
//     }



// }
