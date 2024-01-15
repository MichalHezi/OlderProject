package com.userLogin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLogin.model.CustomUser;
import com.userLogin.model.Order;
import com.userLogin.model.OrderRequest;
import com.userLogin.model.OrderResponse;
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
    public OrderResponse createOrder(OrderRequest orderRequest) throws JsonProcessingException {
        CustomUser customUser = orderRequest.getCustomUser();
        Order order = orderRequest.getOrder();
//        OrderResponse orderResponse;
        if (customUser.getId() != null && userService.getUserById(customUser.getId()) != null){
            order.setUserId(customUser.getId());
            orderRepository.createOrder(order);
//            orderResponse = new OrderResponse(
//                    userService.getUserById(customUser.getId()),
//                    orderRepository.getOrdersByUserId(customUser.getId())
//            );
        }
        return new OrderResponse(
                userService.getUserById(customUser.getId()),
                orderRepository.getOrdersByUserId(customUser.getId())
        );
    }

    @Override
    public void deleteOrder(int id) {

    }
}
