package com.easydojo.template.product;


import com.easydojo.template.common.exception.AppException;
import com.google.common.collect.ImmutableMap;

import static com.easydojo.template.common.exception.ErrorCode.PRODUCT_NOT_FOUND;

public class ProductNotFoundException extends AppException {
    public ProductNotFoundException(String id) {
        super(PRODUCT_NOT_FOUND, ImmutableMap.of("productId", id));
    }
}
