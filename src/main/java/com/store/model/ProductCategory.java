package com.store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "product_category")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private short id;

    @Column(name = "parent_category_id")
    private short parentId;

    @Column(name = "name", nullable = false, unique = true, length = 20)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();
}
