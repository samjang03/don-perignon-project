package com.store.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "user_account")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "patronymic", nullable = false, length = 50)
    private String patronymic;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "phone", nullable = false, length = 12)
    private String phone;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "admin", nullable = false)
    private boolean admin;

    @Column(name = "registered_at", nullable = false)
    private Date registeredAt;

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @Column(name = "last_login_at", nullable = false)
    private Date lastLoginAt;

//    @OneToMany(mappedBy = "userAccount")
//    private List<ProductReview> productReviews;

    @OneToMany(mappedBy = "user")
    private List<UserAddress> userAddresses = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    private List<Cart> carts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<OrderDetails> orderDetails = new ArrayList<>();

    @PrePersist
    void registeredAt() {
        this.registeredAt = new Date();
    }
}
