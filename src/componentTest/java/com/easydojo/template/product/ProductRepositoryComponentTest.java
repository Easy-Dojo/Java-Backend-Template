package com.easydojo.template.product;

import com.easydojo.template.BaseComponentTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ProductRepositoryComponentTest extends BaseComponentTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void should_save_order() {
        Product product = Product.create("娃哈哈", "小孩喝的娃哈哈", valueOf(2));
        Product saved = repository.save(product);

        assertEquals(product.getName(), saved.getName());
    }

}