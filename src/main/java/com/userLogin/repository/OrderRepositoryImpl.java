package com.userLogin.repository;

import com.userLogin.model.Order;
import com.userLogin.repository.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
    private static final String ORDER_TABLE_NAME = "order";
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void createOrder(Order order) {

    }

    @Override
    public void deleteOrder(int id) {

    }

    @Override
    public List<Order> getOrdersByUserId(Long id) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE user_id = ?";
        return jdbcTemplate.query(sql, new OrderMapper(), id);
    }
}
