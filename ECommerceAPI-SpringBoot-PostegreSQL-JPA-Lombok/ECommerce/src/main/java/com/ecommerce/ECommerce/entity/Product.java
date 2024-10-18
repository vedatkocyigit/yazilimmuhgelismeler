package com.ecommerce.ECommerce.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "name")
    private String name;


    @Column(name = "category")
    private String category;


    @Column(name = "price")
    private int price;


    @Column(name = "piece")
    private int piece;


    @Column(name = "seller")
    private String seller;


}