package com.store.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "id")
    //TODO create sequence
    private int id;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private ProductCategory category;

    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "product_image", nullable = false)
    private String productImage;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "quantity", nullable = false)
    private short quantity;

    @Column(name = "brand", nullable = false, length = 50)
    private String brand;

    @Column(name = "size", nullable = false)
    private short size;

    @Column(name = "strength", nullable = false)
    private short strength;

    @Column(name = "sugar", nullable = false)
    private short sugar;

    @Column(name = "maturation_period", nullable = false)
    private short maturationPeriod;

    @Column(name = "color", nullable = false, length = 15)
    private String color;

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    private Date createdAt;

    private Date updatedAt;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
