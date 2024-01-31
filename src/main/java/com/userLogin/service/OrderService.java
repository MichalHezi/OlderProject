package com.userLogin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLogin.model.Order;

public interface OrderService {
    void createOrder(Order order);
    void deleteOrderByUserId(Long id);
}
