package com.userLogin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userLogin.model.CustomUser;
import com.userLogin.model.CustomUserRequest;
import com.userLogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(CustomUserRequest customUserRequest) throws Exception {
        CustomUser existingCustomUser = userRepository.findUserByUsername(customUserRequest.getUsername());
        if(existingCustomUser != null){
            throw new Exception("Username " + customUserRequest.getUsername() + " is already taken");
        }
        userRepository.createUser(customUserRequest.toCustomUser());
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

}





