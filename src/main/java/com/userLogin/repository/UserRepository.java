package com.userLogin.repository;

import com.userLogin.model.CustomUser;

public interface UserRepository {
    void createUser(CustomUser customUser);
    String deleteUserById(int id);
    CustomUser findUserByUsername(String username);
}
