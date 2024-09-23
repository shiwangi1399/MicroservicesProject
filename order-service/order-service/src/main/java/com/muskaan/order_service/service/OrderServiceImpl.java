package com.muskaan.order_service.service;

import com.muskaan.order_service.entity.Order;
import com.muskaan.order_service.model.OrderRequest;
import com.muskaan.order_service.repository.OrderRepository;
import com.netflix.discovery.converters.Auto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public long placeOrder(OrderRequest orderRequest) {
        log.info("placing order "+orderRequest);
                Order order = Order.builder().
                        amount(orderRequest.getTotalAmount())
                        .orderStatus("Created")
                        .id(orderRequest.getProductId())
                        .Orderdate(Instant.now())
                        .quantity(orderRequest.getQuantity())
                        .build();
        order= orderRepository.save(order);
        log.info("order placed sucessfully with order ID"+order.getId());

        //order entity ->save the data with status order
        //product service ->block product
        //payment service ->payment complete , success->complete, else ->cancelled
       return order.getId();
    }
}
