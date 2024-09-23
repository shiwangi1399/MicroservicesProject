package com.muskaan.ProductService.exception;

import lombok.Data;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Data
public class ProductServiceCustomException extends RuntimeException {
    private String errorCode;

    public ProductServiceCustomException(String message,String errorCode)
    {
      super(message);
      this.errorCode=errorCode;
    }

}
