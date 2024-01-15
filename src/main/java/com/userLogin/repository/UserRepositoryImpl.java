package com.userLogin.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLogin.model.CustomUser;
import com.userLogin.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String USER_TABLE_NAME = "user";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createUser(CustomUser customUser) {
        String sql = "INSERT INTO " + USER_TABLE_NAME + " (username, password, firstname, lastname, email, phone, address, roles, permissions) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, customUser.getUsername(), customUser.getPassword(), customUser.getFirstname(),customUser.getLastname(),customUser.getEmail(), customUser.getPhone(), customUser.getAddress(), customUser.getRoles(), customUser.getPermissions());
    }

    @Override
    public String deleteUserById(int id) {
        String sql = "DELETE FROM " + USER_TABLE_NAME + " WHERE id = ?";
        if(jdbcTemplate.update(sql,id) == 1){
            return "User with id " + id + " was deleted";
        }else{
            return "User with id " + id + " was not found";
        }
    }

    @Override
    public CustomUser findUserByUsername(String username) {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE username=?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), username);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public String updateUserPassword(String newPassword, Long id){
        String sql = "UPDATE " + USER_TABLE_NAME + " SET password = ? WHERE id = ?";
        jdbcTemplate.update(sql,newPassword,id);
        return "User's password updated";
    }

    @Override
    public String updateUsername(String newUsername, Long id) {
        String sql = "UPDATE " + USER_TABLE_NAME + " SET username = ? WHERE id = ?";
        jdbcTemplate.update(sql,newUsername,id);
        return "User's username updated";
    }

    @Override
    public CustomUser getUserById(Long id) throws JsonProcessingException {
        String sql = "SELECT * FROM " + USER_TABLE_NAME + " WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

}


