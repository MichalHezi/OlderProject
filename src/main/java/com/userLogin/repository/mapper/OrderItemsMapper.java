package com.userLogin.repository.mapper;

import com.userLogin.model.OrderItems;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemsMapper implements RowMapper<OrderItems> {
    @Override
    public OrderItems mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new OrderItems(
                rs.getLong("id"),
                rs.getLong("order_id"),
                rs.getLong("item_id")
        );
    }
}
