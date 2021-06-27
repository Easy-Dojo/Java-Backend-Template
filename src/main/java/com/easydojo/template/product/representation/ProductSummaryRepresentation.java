package com.easydojo.template.product.representation;


import com.easydojo.template.common.ddd.Representation;
import com.easydojo.template.product.Product;

import java.math.BigDecimal;

public class ProductSummaryRepresentation implements Representation {
    private String id;
    private String name;
    private BigDecimal price;

    public ProductSummaryRepresentation(String id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static ProductSummaryRepresentation from(Product product) {
        return new ProductSummaryRepresentation(product.getId(), product.getName(), product.getPrice());
    }

    public String getName() {
        return name;
    }
}
