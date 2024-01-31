package com.userLogin.repository;

import com.userLogin.model.Order;
import com.userLogin.model.OrderType;
import com.userLogin.repository.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
    private static final String ORDER_TABLE_NAME = "orders";
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void createOrder(Order order) {
        String sql = "INSERT INTO " + ORDER_TABLE_NAME +  "(user_id, order_date, shipping_address, total_price, order_status) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,order.getUserId(),order.getOrderDate(),order.getShippingAddress(),order.getTotalPrice(), order.getOrderStatus().toString());
    }

    @Override
    public void deleteOrderByUserId(Long id) {
        String sql = "DELETE FROM " + ORDER_TABLE_NAME + " WHERE id = ?";
        jdbcTemplate.update(sql,id);

    }

    @Override
    public List<Order> getOrdersByUserId(Long id) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE user_id = ?";
        return jdbcTemplate.query(sql, new OrderMapper(), id);
    }
}
