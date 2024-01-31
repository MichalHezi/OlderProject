package com.userLogin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLogin.model.Order;
import com.userLogin.model.OrderType;
import com.userLogin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/create")
    public String createOrder(@RequestBody Order order){
        orderService.createOrder(order);
        return "The order has been created";
    }
    @DeleteMapping("/delete")
    public String deleteOrderByUserId (@RequestParam Long id){
        orderService.deleteOrderByUserId(id);
        return "The order has been deleted";
    }
}
