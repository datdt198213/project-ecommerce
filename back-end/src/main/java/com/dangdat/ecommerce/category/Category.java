package com.dangdat.ecommerce.category;

import com.dangdat.ecommerce.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "category")
public class Category {
    @Id
    private String id;
    private String name;
    private String description;
    private int status;
    private String parentId;
    private Date createdAt;
    private Date modifiedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
