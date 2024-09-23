package com.muskaan.order_service.service;

import com.muskaan.order_service.model.OrderRequest;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);
}
