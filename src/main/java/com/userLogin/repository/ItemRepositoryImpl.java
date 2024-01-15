package com.userLogin.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userLogin.model.Item;
import com.userLogin.repository.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository{
    private static final String ITEM_TABLE_NAME = "item";
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public Long createItem(Item item) {
        String sql = "INSERT INTO " + ITEM_TABLE_NAME + " (title,photoURL,price,stock) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, item.getTitle(), item.getPhotoURL(), item.getPrice(), item.getStock());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);

    }

    @Override
    public String deleteItem(int id) {
        String sql = "DELETE FROM " + ITEM_TABLE_NAME + " WHERE id = ?";
        if(jdbcTemplate.update(sql,id) == 1){
            return "Item with id " + id + " was deleted";
        }else{
            return "Item with id " + id + " was not found";
        }
    }

    @Override
    public String updatePriceOfItemById(double newPrice,int id) {
        String sql = "UPDATE " + ITEM_TABLE_NAME + " SET price = ? WHERE id = ?";
        jdbcTemplate.update(sql,newPrice,id);
        return "Item updated";
    }

    @Override
    public String updateStockById(int newStock, int id) {
        String sql = "UPDATE " + ITEM_TABLE_NAME + " SET stock = ? WHERE id = ?";
        jdbcTemplate.update(sql,newStock,id);
        return "Stock updated";
    }

    @Override
    public List<Item> getAllItems() {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME;
        return jdbcTemplate.query(sql,new ItemMapper());

    }


}
