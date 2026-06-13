package com.pranavd.foody.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;

    @Column(nullable = false)
    private LocalDate orderDate;

    @Column(nullable = false)
    private LocalTime orderTime;

    private String orderStatus;

    private BigDecimal totalPrice;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}
