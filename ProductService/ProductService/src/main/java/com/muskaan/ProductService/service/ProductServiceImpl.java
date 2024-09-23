package com.muskaan.ProductService.service;

import com.muskaan.ProductService.entity.Product;
import com.muskaan.ProductService.exception.ProductServiceCustomException;
import com.muskaan.ProductService.model.ProductRequest;
import com.muskaan.ProductService.model.ProductResponse;
import com.muskaan.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

@Log4j2
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
   public long addProduct(ProductRequest productRequest)
   {
       log.info("Adding Product");
       //creating obj of productRequest
       Product product = Product.builder()
               .productName(productRequest.getName())
               .quantity(productRequest.getQuantity())
               .price(productRequest.getPrice())
               .build();
       productRepository.save(product);
       log.info("Product created");
       return product.getProductId();
   }

    @Override
    public ProductResponse getProductById(long productId) {
       log.info("get the product for productid "+productId);
       Product product = productRepository.findById(productId)
               .orElseThrow(()->new ProductServiceCustomException("Product with given Id not project","PRODUCT_NOTFOUND"));

       ProductResponse productResponse =new ProductResponse();
        copyProperties(product,productResponse);
       return productResponse;
    }


}
