package com.dangdat.ecommerce.product;

import com.dangdat.ecommerce.category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "product")
public class Product {
    @Id
    private String id;
    private String name;
    private String brand;
    private String description;
    private int status;
    private int countBuy;
    private int countView;
    private double priceImport;
    private double priceExport;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;
    private int totalQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cate_id", referencedColumnName = "id")
    private Category category;
}
