package com.userLogin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLogin.model.OrderRequest;
import com.userLogin.model.OrderResponse;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest) throws JsonProcessingException;
    void deleteOrder(int id);
}
