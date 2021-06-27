package com.easydojo.template.product;

import com.easydojo.template.common.utils.PagedResource;
import com.easydojo.template.product.representation.ProductSummaryRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping
    @ResponseStatus(CREATED)
    public ProductSummaryRepresentation createProduct(@RequestBody @Valid CreateProductCommand command) {
        Product saved = productRepository.save(command.newProduct());
        return ProductSummaryRepresentation.from(saved);
    }

    @GetMapping
    public PagedResource<ProductSummaryRepresentation> pagedProducts(@RequestParam(required = false, defaultValue = "1") int pageIndex,
                                                                     @RequestParam(required = false, defaultValue = "10") int pageSize) {

        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Page<Product> productsPage = productRepository.findAll(pageable);

        return PagedResource.of(
                productsPage.getTotalPages(),
                productsPage.getNumber(),
                productsPage.getContent().stream().map(ProductSummaryRepresentation::from).collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public Object byId(@PathVariable(name = "id") String id) {
        return productRepository.findById(id).orElse(null);
    }
}
