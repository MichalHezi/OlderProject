package com.userLogin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLogin.model.CustomUser;
import com.userLogin.model.Order;
import com.userLogin.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserService userService;

    @Override
    public void createOrder(Order order) {
        orderRepository.createOrder(order);
    }

    @Override
    public void deleteOrderByUserId(Long id) {
        orderRepository.deleteOrderByUserId(id);
    }
}
