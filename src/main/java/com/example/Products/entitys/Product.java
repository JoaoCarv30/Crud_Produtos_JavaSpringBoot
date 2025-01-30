package com.example.Products.entitys;

import com.example.Products.enums.typeProduct;
import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
@Table(name = "tb_products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "type")
    private typeProduct type;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    public Product() {
    }

    public Product(Long id, String name, String description, Double price, typeProduct type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public typeProduct getType() {
        return type;
    }

    public void setType(typeProduct type) {
        this.type = type;
    }
}
