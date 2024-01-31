package com.userLogin.repository;

import com.userLogin.model.Order;

import java.util.List;

public interface OrderRepository {
    void createOrder(Order order);
    void deleteOrderByUserId(Long id);
    List<Order> getOrdersByUserId(Long id);
}
