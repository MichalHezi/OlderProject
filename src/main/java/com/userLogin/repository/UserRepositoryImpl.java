package com.userLogin.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLogin.model.CustomUser;
import com.userLogin.model.FavoriteList;
import com.userLogin.repository.mapper.FavoriteListMapper;
import com.userLogin.repository.mapper.ItemMapper;
import com.userLogin.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String USERS_TABLE_NAME = "users";
    private static final String FAVORITE_TABLE_NAME = "favorite_list";
    private static final String ORDER_TABLE_NAME = "orders";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Long createUser(CustomUser customUser) {
        String sql = "INSERT INTO " + USERS_TABLE_NAME + " (username, password, firstname, lastname, email, phone, address, roles, permissions) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, customUser.getUsername(), customUser.getPassword(), customUser.getFirstname(),customUser.getLastname(),customUser.getEmail(), customUser.getPhone(), customUser.getAddress(), customUser.getRoles(), customUser.getPermissions());
        sql = "SELECT MAX(id) FROM " + USERS_TABLE_NAME;
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    @Override
    public String deleteUserById(int id) {
        String deleteFavoriteListSql = "DELETE FROM " + FAVORITE_TABLE_NAME + " WHERE id = ?";
        jdbcTemplate.update(deleteFavoriteListSql,id);
        String deleteOrdersSql = "DELETE FROM " + ORDER_TABLE_NAME + " WHERE id = ?";
        jdbcTemplate.update(deleteOrdersSql,id);
        String sql = "DELETE FROM " + USERS_TABLE_NAME + " WHERE id = ?";
        if(jdbcTemplate.update(sql,id) == 1){
            return "User with id " + id + " was deleted";
        }else{
            return "User with id " + id + " was not found";
        }
    }

    @Override
    public CustomUser findUserByUsername(String username) {
        String sql = "SELECT * FROM " + USERS_TABLE_NAME + " WHERE username=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), username);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public String updateUserPassword(String newPassword, Long id){
        String sql = "UPDATE " + USERS_TABLE_NAME + " SET password = ? WHERE id = ?";
        jdbcTemplate.update(sql,newPassword,id);
        return "User's password updated";
    }

    @Override
    public String updateUsername(String newUsername, Long id) {
        String sql = "UPDATE " + USERS_TABLE_NAME + " SET username = ? WHERE id = ?";
        jdbcTemplate.update(sql,newUsername,id);
        return "User's username updated";
    }

    @Override
    public CustomUser getUserById(Long id) throws JsonProcessingException {
        String sql = "SELECT * FROM " + USERS_TABLE_NAME + " WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    public List<FavoriteList> getFavoriteList(Long id) {
        String sql = "SELECT * FROM " + FAVORITE_TABLE_NAME + " WHERE id = ?";
        return jdbcTemplate.query(sql,new Object[]{id},new FavoriteListMapper());
    }

    @Override
    public void addToFavoriteList(Long userId, Long itemId) {
        String sql = "INSERT INTO " + FAVORITE_TABLE_NAME + " (user_id, item_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, userId, itemId);
    }

    @Override
    public boolean isItemInFavoriteList(Long userId, Long itemId) {
        String sql = "SELECT COUNT(*) > 0 FROM " + FAVORITE_TABLE_NAME + " WHERE user_id = ? AND item_id = ?";
        return jdbcTemplate.queryForObject(sql, Boolean.class, userId, itemId);
    }

    @Override
    public void removeFromFavoriteList(Long userId, Long itemId) {
        String sql = "DELETE FROM " + FAVORITE_TABLE_NAME + " WHERE user_id = ? AND item_id = ?";
        jdbcTemplate.update(sql, userId, itemId);
    }


}


