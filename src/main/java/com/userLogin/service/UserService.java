package com.userLogin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLogin.model.CustomUser;
import com.userLogin.model.CustomUserRequest;

public interface UserService {
    void createUser(CustomUserRequest customUser) throws Exception;
    String deleteUserById(int id);
    CustomUser findUserByUsername(String username);
    String updateUserPassword(String newPassword, Long id);
    String updateUsername(String newUsername, Long id);
    CustomUser getUserById(Long id) throws JsonProcessingException;

}
