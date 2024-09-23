package com.muskaan.ProductService.controller;

import com.muskaan.ProductService.model.ProductRequest;
import com.muskaan.ProductService.model.ProductResponse;
import com.muskaan.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Product")
public class ProductController {

    @Autowired
   private ProductService productService;
    //name, price ,quantity-productRequest
    @PostMapping("/productAdd")
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest)
    {
       long productId = productService.addProduct(productRequest);
       return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId)
    {
     ProductResponse productResponse= productService.getProductById(productId);
     return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }
}
