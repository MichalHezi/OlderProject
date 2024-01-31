package com.userLogin.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLogin.model.CustomUser;
import com.userLogin.model.FavoriteList;

import java.util.List;

public interface UserRepository {
    Long createUser(CustomUser customUser);
    String deleteUserById(int id);
    CustomUser findUserByUsername(String username);
    String updateUserPassword(String newPassword, Long id);
    String updateUsername(String newUsername, Long id);
    CustomUser getUserById(Long id) throws JsonProcessingException;
    List<FavoriteList> getFavoriteList(Long id);
    void addToFavoriteList(Long userId, Long itemId);
    boolean isItemInFavoriteList(Long userId, Long itemId);
    void removeFromFavoriteList(Long userId, Long itemId);
}
