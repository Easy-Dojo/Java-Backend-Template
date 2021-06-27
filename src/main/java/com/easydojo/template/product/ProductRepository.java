package com.easydojo.template.product;

import com.easydojo.template.common.ddd.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepository extends JpaRepository<Product, String>, Repository {
}
