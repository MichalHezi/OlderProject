package com.userLogin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLogin.model.OrderRequest;
import com.userLogin.model.OrderResponse;
import com.userLogin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) throws JsonProcessingException {
        return orderService.createOrder(orderRequest);
    }
}
