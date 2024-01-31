package com.userLogin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLogin.model.CustomUser;
import com.userLogin.model.CustomUserRequest;
import com.userLogin.model.FavoriteList;
import com.userLogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Long createUser(CustomUserRequest customUserRequest) throws Exception {
        CustomUser existingCustomUser = userRepository.findUserByUsername(customUserRequest.getUsername());
        if(existingCustomUser != null){
            throw new Exception("Username " + customUserRequest.getUsername() + " is already taken");
        }
        return userRepository.createUser(customUserRequest.toCustomUser());
    }

    @Override
    public String deleteUserById(int id) {
        return userRepository.deleteUserById(id);
    }

    @Override
    public CustomUser findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public String updateUserPassword(String newPassword, Long id) {
        return userRepository.updateUserPassword(newPassword,id);
    }

    @Override
    public String updateUsername(String newUsername, Long id) {
        return userRepository.updateUsername(newUsername, id);
    }

    @Override
    public CustomUser getUserById(Long id) throws JsonProcessingException {
        return userRepository.getUserById(id);
    }

    @Override
    public List<FavoriteList> getFavoriteList(Long id) {
        return userRepository.getFavoriteList(id);
    }

    @Override
    public void addToFavoriteList(Long userId, Long itemId) {
        if (!userRepository.isItemInFavoriteList(userId, itemId)){
            userRepository.addToFavoriteList(userId, itemId);
        }else{
            System.out.println("Item already exists in the favorite list.");

        }
    }

    @Override
    public boolean isItemInFavoriteList(Long userId, Long itemId) {
        return userRepository.isItemInFavoriteList(userId, itemId);
    }

    @Override
    public void removeFromFavoriteList(Long userId, Long itemId) {
        userRepository.removeFromFavoriteList(userId, itemId);
    }


}





