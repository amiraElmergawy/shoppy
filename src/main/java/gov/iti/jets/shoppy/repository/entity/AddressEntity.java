package gov.iti.jets.shoppy.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
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
@Data
@NoArgsConstructor
@Table(name = "addresses", catalog = "shoppy", uniqueConstraints = @UniqueConstraint(columnNames = "customer_id"))
public class AddressEntity implements java.io.Serializable {
    @Id
    @Column(name = "customer_id", unique = true, nullable = false)
    @GenericGenerator(name = "Generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "customers"))
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
    private CustomerEntity customers;
}
