package com.easydojo.template;

import com.easydojo.template.product.CreateProductCommand;
import com.easydojo.template.product.Product;
import com.easydojo.template.product.ProductController;
import com.easydojo.template.product.ProductRepository;
import com.easydojo.template.product.representation.ProductSummaryRepresentation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @InjectMocks
    ProductController productController;

    @Mock
    ProductRepository productRepository;

    @Test
    void should_call_repository_when_save_product_given_product() {
        Product product = new Product("name", "dec", BigDecimal.ONE);
        when(productRepository.save(any())).thenReturn(product);

        ProductSummaryRepresentation result = productController.createProduct(new CreateProductCommand("name", "des", BigDecimal.ONE));

        assertEquals("name", result.getName());
        verify(productRepository, times(1)).save(any());
    }
}
