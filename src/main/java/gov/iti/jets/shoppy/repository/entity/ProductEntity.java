package gov.iti.jets.shoppy.repository.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class ProductEntity{
    private long id;
    private String name;
    private double price;
    private String desc;
    private CategoryEntity category;
    private int stock;
    private String imagePath;
}
