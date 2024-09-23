package com.muskaan.ProductService.service;

import com.muskaan.ProductService.model.ProductRequest;
import com.muskaan.ProductService.model.ProductResponse;
import org.springframework.stereotype.Service;


public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);
}
