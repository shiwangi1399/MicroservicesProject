package com.muskaan.order_service.entity;

import jakarta.persistence.*;
import jakarta.ws.rs.SeBootstrap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name="ORDER_DETAIL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PRODUCT_ID")
    private long id;
    @Column(name="QUANTITY")
    private long quantity;
    @Column(name="ORDER_DATE")
    private Instant Orderdate;
    @Column(name="ORDER_STATUS")
    private String orderStatus;
    @Column(name="ORDER_AMOUNT")
    private long amount;
//Instant is a class from the java.time package, introduced in Java 8.
//It represents a point in time, typically used to capture timestamps
// in a precise way, down to nanoseconds.

}
