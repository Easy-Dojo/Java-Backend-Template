package com.easydojo.template.product;

import com.easydojo.template.common.ddd.AggregateRoot;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "PRODUCT")
public class Product implements AggregateRoot {
    @Id
    @GeneratedValue(generator = "id_generator")
    @GenericGenerator(name = "id_generator", strategy = "uuid2")
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Instant createdAt;

    public Product() {
    }

    public Product(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = Instant.now();
    }

    public static Product create(String name, String description, BigDecimal price) {
        return new Product(name, description, price);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
