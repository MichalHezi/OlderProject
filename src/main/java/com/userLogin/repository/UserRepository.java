package com.userLogin.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLogin.model.CustomUser;

public interface UserRepository {
    void createUser(CustomUser customUser);
    String deleteUserById(int id);
    CustomUser findUserByUsername(String username);
    String updateUserPassword(String newPassword, Long id);
    String updateUsername(String newUsername, Long id);
    CustomUser getUserById(Long id) throws JsonProcessingException;
}
